package pizzeria.dto;

import lombok.*;
import pizzeria.domain.OrderStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateOrderStatusDto {

    private OrderStatus orderStatus;

    private Long updateTime;

}
