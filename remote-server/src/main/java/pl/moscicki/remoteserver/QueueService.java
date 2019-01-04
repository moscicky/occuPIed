package pl.moscicki.remoteserver;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Queue;

@Component
class QueueService {
  private final Db database;

  QueueService(Db database) {
    this.database = database;
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
        getQueue().poll();
        return new AccessDto(uuid, AccessStatus.REVOKED);
      } else {
        database.setToiletOccupied(true);
        return new AccessDto(uuid, AccessStatus.GRANTED);
      }
    } else {
      return new AccessDto(uuid, AccessStatus.DENIED);
    }
  }


}
