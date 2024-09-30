package pizzeria.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PizzaDto {
  private UUID id;

  private String name;

  private String description;
}
