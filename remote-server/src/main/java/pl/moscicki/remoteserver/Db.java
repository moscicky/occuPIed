package pl.moscicki.remoteserver;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

@Component
public class Db {
  private boolean toiletOccupied;

  private Map<String, Integer[]> users;

  private Queue<String> queue;

  Db() {
    toiletOccupied = false;
    users = new HashMap<>();
    queue = new LinkedList<>();
  }

  Map<String, Integer[]> getUsers() {
    return users;
  }

  void setUsers(Map<String, Integer[]> users) {
    this.users = users;
  }

  Queue<String> getQueue() {
    return queue;
  }

  void setQueue(Queue<String> queue) {
    this.queue = queue;
  }

  public boolean isToiletOccupied() {
    return toiletOccupied;
  }

  public void setToiletOccupied(boolean toiletOccupied) {
    this.toiletOccupied = toiletOccupied;
  }
}
