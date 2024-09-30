package pizzeria.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pizzeria.domain.User;
import pizzeria.dto.UserDto;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static pizzeria.exception.RestException.supplierCreateRestFormattedException;
import static pizzeria.exception.RestException.throwRestFormattedException;

@Slf4j
@Service
public class UserService {

  @Autowired
  pizzeria.repository.UserRepository userRepository;

  @Transactional
  public List<User> getUsers() {
    return userRepository.findAll();
  }

  @Transactional
  public List<User> getUsers(Specification<User> spec) {
    return userRepository.findAll(spec);
  }

  @Transactional
  public User getUserById(UUID id) {
    return userRepository.findById(id)
        .orElseThrow(
            supplierCreateRestFormattedException(INTERNAL_SERVER_ERROR, "User not found")
        );
  }

  @Transactional
  public User insert(UserDto userDto) {
    if (userDto.getId() != null) {
      throwRestFormattedException(INTERNAL_SERVER_ERROR, "cannot upload new user with id param");
    }
    User user = User.of(userDto);
    return userRepository.save(user);
  }

  @Transactional
  public User updateUser(UserDto userDto) {
    User user = User.of(userDto);
    User userFromDb = getUserById(user.getId());
    user.mergeWith(userFromDb);
    return userRepository.save(user);
  }

  @Transactional
  public void deleteUser(UUID id) {
    userRepository.deleteById(id);
  }

}
