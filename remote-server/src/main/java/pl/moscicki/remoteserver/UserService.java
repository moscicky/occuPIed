package pl.moscicki.remoteserver;

import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
class UserService {
  private final Db database;

  UserService(Db database) {
    this.database = database;
  }

  void addUser(UserDto userDto) {
    database.getUsers().put(userDto.getName(), userDto.getUuid());
  }

  Set<UserDto> getUsers() {
    return database.getUsers().entrySet().stream()
            .map(user -> new UserDto(user.getKey(), user.getValue()))
            .collect(Collectors.toSet());
  }

}
