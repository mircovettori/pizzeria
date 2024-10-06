package pizzeria.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrderDto {

  private UUID userId;

  private List<InsertOrderPizzaDto> orderPizzas;
}
