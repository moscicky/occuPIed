package pl.moscicki.remoteserver;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
class QueueService {
  private final Db database;

  public QueueService(Db database) {
    this.database = database;
  }

  List<String> getQueue() {
    return database.getPeople();
  }

  public void addToQueue(String person) {
    database.getPeople().add(person);
  }
}
