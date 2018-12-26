package pl.moscicki.remoteserver;

import org.springframework.stereotype.Component;

import java.util.Queue;

@Component
class QueueService {
  private final Db database;

  public QueueService(Db database) {
    this.database = database;
  }

  Queue<String> getQueue() {
    return database.getPeople();
  }

  void addToQueue(String person) {
    database.getPeople().add(person);
  }
}
