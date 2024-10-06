package pizzeria.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InsertOrderPizzaDto {

    private UUID pizzaId;

    private Integer number;
}
