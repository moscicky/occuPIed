package pl.moscicki.remoteserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Queue;

@Component
class QueueService {

  @Value("${frontend-url}")
  private String frontendUrl;
  private final Db database;
  private final RestTemplate restTemplate;

  QueueService(Db database) {
    this.database = database;
    restTemplate = new RestTemplate();
  }

  Queue<String> getQueue() {
    return database.getQueue();
  }

  String addToQueue(String person) {
    if (database.getUsers().containsKey(person)) {
      database.getQueue().add(person);
      return String.format("%s added to queue successfully", person);
    } else {
      return "No such user registered";
    }
  }

  synchronized AccessDto scan(Integer[] uuid) {
    if (Arrays.equals(database.getUsers().get(getQueue().peek()), uuid)) {
      if (database.isToiletOccupied()) {
        String userLeft = getQueue().poll();
        updateFrontend(userLeft, AccessStatus.REVOKED);
        return new AccessDto(uuid, AccessStatus.REVOKED);
      } else {
        database.setToiletOccupied(true);
        updateFrontend(getQueue().peek(), AccessStatus.GRANTED);
        return new AccessDto(uuid, AccessStatus.GRANTED);
      }
    } else {
      return new AccessDto(uuid, AccessStatus.DENIED);
    }
  }

  private void updateFrontend(String user, AccessStatus status) {
    HttpEntity<QueueUpdateDto> request = new HttpEntity<>(new QueueUpdateDto(user, status));
    restTemplate.postForEntity(frontendUrl, request, String.class);
  }


}
