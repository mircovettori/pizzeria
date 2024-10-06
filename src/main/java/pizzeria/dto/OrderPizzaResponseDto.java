package pizzeria.dto;

import lombok.*;
import pizzeria.domain.OrderPizza;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderPizzaResponseDto {

    private UUID pizzaId;

    private String pizzaName;

    private Integer number;


    public static OrderPizzaResponseDto of(OrderPizza orderPizza) {
        return OrderPizzaResponseDto.builder()
                .pizzaId(orderPizza.getPizza().getId())
                .pizzaName(orderPizza.getPizza().getName())
                .number(orderPizza.getNumber())
                .build();
    }
}
