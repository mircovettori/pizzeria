package pizzeria.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import pizzeria.dto.PizzaDto;
import pizzeria.dto.UserDto;


@Entity
@Table(name = "pizza", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Pizza extends GenericDomain {

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "description")
  private String description;


  public static Pizza of(PizzaDto pizzaDto) {
    Pizza pizza = Pizza.builder()
        .name(pizzaDto.getName())
        .description(pizzaDto.getDescription())
        .build();
    pizza.setId(pizzaDto.getId());
    return pizza;
  }
}
