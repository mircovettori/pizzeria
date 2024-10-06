package pizzeria.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pizzeria.domain.*;
import pizzeria.dto.CreateOrderDto;
import pizzeria.dto.OrderHistoryResponseDto;
import pizzeria.dto.OrderResponseDto;
import pizzeria.repository.OrderRepository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static pizzeria.exception.RestException.supplierCreateRestFormattedException;

@Slf4j
@Service
public class OrderService {

  @Autowired
  OrderRepository orderRepository;

  @Autowired
  OrderPizzaService orderPizzaService;

  @Autowired
  OrderHistoryService orderHistoryService;

  @Autowired
  UserService userService;

  @Transactional
  public OrderResponseDto createOrder(CreateOrderDto createOrderDto) {
    User user = userService.getUserById(createOrderDto.getUserId());
    Order order = orderRepository.save(Order.builder().user(user).build());
    List<OrderPizza> orderPizzas = orderPizzaService.createOrderPizza(order, createOrderDto.getOrderPizzas());
    OrderHistory orderHistory = orderHistoryService.createOrderHistory(order, OrderStatus.ORDERED, OffsetDateTime.now().toInstant().toEpochMilli());
    return OrderResponseDto.of(order, orderPizzas);
  }

  @Transactional
  public OrderResponseDto getOrderById(UUID orderId) {
    Order order = findById(orderId);
    return OrderResponseDto.of(order, order.getOrderPizzas());
  }

  @Transactional
  public Order findById(UUID orderId) {
    return orderRepository.findById(orderId).orElseThrow(
            supplierCreateRestFormattedException(INTERNAL_SERVER_ERROR, "Order not found")
    );
  }

  @Transactional
  public List<OrderResponseDto> getOrdersByUserId(UUID userId) {
    List<Order> orders = orderRepository.findByUserId(userId);
    return orders.stream().map(order -> OrderResponseDto.of(order, order.getOrderPizzas())).toList();
  }

  @Transactional
  public OrderHistoryResponseDto createOrderHistory(UUID orderId, OrderStatus orderStatus, Long updateTime) {
    Order order = findById(orderId);
    OrderHistory newOrderHistory = orderHistoryService.createOrderHistory(order, orderStatus, updateTime);
    return OrderHistoryResponseDto.of(newOrderHistory);
  }

  public List<OrderHistoryResponseDto> getOrderHistoryById(UUID orderId) {
    return orderHistoryService.getOrderHistoryById(orderId).stream().map(OrderHistoryResponseDto::of).toList();
  }
}
