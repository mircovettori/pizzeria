package pizzeria.dto;

import lombok.*;
import pizzeria.domain.OrderHistory;
import pizzeria.domain.OrderStatus;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderHistoryResponseDto {

    private UUID orderId;

    private OrderStatus orderStatus;

    private Long updateTime;


    public static OrderHistoryResponseDto of(OrderHistory orderHistory) {
        return OrderHistoryResponseDto.builder()
                .orderId(orderHistory.getOrder().getId())
                .orderStatus(orderHistory.getOrderStatus())
                .updateTime(orderHistory.getUpdateTime())
                .build();
    }
}
