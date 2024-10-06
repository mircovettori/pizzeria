package pizzeria.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pizzeria.domain.User;
import pizzeria.dto.UserDto;
import pizzeria.service.UserService;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping({"/{userId}"})
  public ResponseEntity<User> getUser(@PathVariable UUID userId) {
    return ResponseEntity.ok(userService.getUserById(userId));
  }

  @GetMapping
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = userService.getUsers();
    return ResponseEntity.ok(users);
  }

  @PostMapping
  public ResponseEntity<User> saveUser(@RequestBody UserDto userDto) {
    User newUser = userService.insert(userDto);
    return ResponseEntity.ok(newUser);
  }

  //The function receives a PUT request, updates the User with the specified Id and returns the updated User
  @PutMapping
  public ResponseEntity<User> updateUser(@RequestBody UserDto userDto) {
    User updatedUser = userService.updateUser(userDto);
    return ResponseEntity.ok(updatedUser);
  }

  //The function receives a DELETE request, deletes the User with the specified Id.
  @DeleteMapping({"/{userId}"})
  public ResponseEntity<Void> deleteUser(@PathVariable("userId") UUID userId) {
    userService.deleteUser(userId);
    return ResponseEntity.ok().build();
  }

}
