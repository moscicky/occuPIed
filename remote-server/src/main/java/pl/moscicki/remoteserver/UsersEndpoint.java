package pl.moscicki.remoteserver;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/users")
class UsersEndpoint {

  private final UserService userService;

  public UsersEndpoint(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  void add(@RequestBody @Validated UserDto user) {
    userService.addUser(user);
  }

  @GetMapping("/all")
  Set<UserDto> getUsers(){
    return userService.getUsers();
  }
}
