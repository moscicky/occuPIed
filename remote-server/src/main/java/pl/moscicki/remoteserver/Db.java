package pl.moscicki.remoteserver;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Db {
  private List<String> people;

  public Db() {
    people = new ArrayList<>();
  }

  List<String> getPeople() {
    return people;
  }

  void setPeople(List<String> people) {
    this.people = people;
  }
}
