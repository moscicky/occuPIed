package pl.moscicki.remoteserver;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Component
public class Db {
  private Queue<String> people;

  public Db() {
    people = new LinkedList<>();
  }

  Queue<String> getPeople() {
    return people;
  }

  void setPeople(Queue<String> people) {
    this.people = people;
  }
}
