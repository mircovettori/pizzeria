package pizzeria.dto;

import lombok.*;
import pizzeria.domain.Order;
import pizzeria.domain.OrderPizza;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponseDto {

    private UUID orderId;

    private List<OrderPizzaResponseDto> orderPizzaResponseDtos;

    public static OrderResponseDto of(Order order, Collection<OrderPizza> orderPizzas) {
        return OrderResponseDto.builder()
                .orderId(order.getId())
                .orderPizzaResponseDtos(orderPizzas.stream().map(OrderPizzaResponseDto::of).toList())
                .build();
    }
}
