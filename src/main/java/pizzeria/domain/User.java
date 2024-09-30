package pizzeria.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import pizzeria.dto.UserDto;


@Entity
@Table(name = "user", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User extends GenericDomain {

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "surname", nullable = false)
  private String surname;

  @Column(name = "mail")
  private String mail;

  @Column(name = "address")
  private String address;

  public static User of(UserDto userDto) {
    User user = User.builder()
        .name(userDto.getName())
        .surname(userDto.getSurname())
        .mail(userDto.getMail())
        .address(userDto.getAddress())
        .build();
    user.setId(userDto.getId());
    return user;
  }
}
