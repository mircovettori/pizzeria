package pizzeria.domain;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "order_history", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class OrderHistory extends GenericDomain {

  @ManyToOne
  @JoinColumn(name="order_id", nullable=false)
  private Order order;

  @Enumerated(EnumType.STRING)
  @Column(name = "status")
  private OrderStatus orderStatus;

  @Column(name = "update_ts")
  private Long updateTime;

}

