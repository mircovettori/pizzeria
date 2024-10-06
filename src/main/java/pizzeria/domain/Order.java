package pizzeria.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Table(name = "order", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Order extends GenericDomain {

  @ManyToOne
  @JoinColumn(name="user_id", nullable=false)
  private User user;

  @OneToMany(mappedBy="order")
  private Set<OrderPizza> orderPizzas;

}
