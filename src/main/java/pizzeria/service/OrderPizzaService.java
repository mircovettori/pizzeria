package pizzeria.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pizzeria.domain.Order;
import pizzeria.domain.OrderPizza;
import pizzeria.domain.Pizza;
import pizzeria.dto.InsertOrderPizzaDto;
import pizzeria.repository.OrderPizzaRepository;

import java.util.List;

@Slf4j
@Service
public class OrderPizzaService {

  @Autowired
  PizzaService pizzaService;

  @Autowired
  OrderPizzaRepository orderPizzaRepository;

  @Transactional
  public List<OrderPizza> createOrderPizza(Order order, List<InsertOrderPizzaDto> insertOrderPizzaDtos) {
    return insertOrderPizzaDtos.stream().map(insertOrderPizzaDto -> this.createOrderPizza(order, insertOrderPizzaDto)).toList();
  }

  @Transactional
  public OrderPizza createOrderPizza(Order order, InsertOrderPizzaDto insertOrderPizzaDto) {
    Pizza pizza = pizzaService.getPizzaById(insertOrderPizzaDto.getPizzaId());
    OrderPizza orderPizza = OrderPizza.builder().order(order).pizza(pizza).number(insertOrderPizzaDto.getNumber()).build();
    return orderPizzaRepository.save(orderPizza);
  }

}
