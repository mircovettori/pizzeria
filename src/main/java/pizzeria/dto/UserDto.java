package pizzeria.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
  private UUID id;

  private String name;

  private String surname;

  private String mail;

  private String address;

}
