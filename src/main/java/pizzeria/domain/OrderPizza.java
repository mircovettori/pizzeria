package pizzeria.domain;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "order_pizza", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class OrderPizza extends GenericDomain {

  @ManyToOne
  @JoinColumn(name = "order_id")
  private Order order;

  @ManyToOne
  @JoinColumn(name = "pizza_id")
  private Pizza pizza;

  @Column(name = "number")
  private Integer number;

}
