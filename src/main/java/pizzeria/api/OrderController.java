package pizzeria.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pizzeria.dto.CreateOrderDto;
import pizzeria.dto.OrderHistoryResponseDto;
import pizzeria.dto.OrderResponseDto;
import pizzeria.dto.UpdateOrderStatusDto;
import pizzeria.service.OrderService;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@Controller
@RequestMapping("/order")
public class OrderController {

  @Autowired
  OrderService orderService;

  @GetMapping({"user/{userId}"})
  public ResponseEntity<List<OrderResponseDto>> getOrdersByUserId(@PathVariable UUID userId) {
    List<OrderResponseDto> orders = orderService.getOrdersByUserId(userId);
    return ResponseEntity.ok(orders);
  }

  @PostMapping
  public ResponseEntity<OrderResponseDto> createOrder(@RequestBody CreateOrderDto createOrderDto) {
    OrderResponseDto newOrder = orderService.createOrder(createOrderDto);
    return ResponseEntity.ok(newOrder);
  }

  @GetMapping({"/{orderId}"})
  public ResponseEntity<OrderResponseDto> getOrder(@PathVariable UUID orderId) {
    OrderResponseDto order = orderService.getOrderById(orderId);
    return ResponseEntity.ok(order);
  }

  @GetMapping({"{orderId}/status"})
  public ResponseEntity<List<OrderHistoryResponseDto>> getOrderStatusesById(@PathVariable UUID orderId) {
    List<OrderHistoryResponseDto> orderHistoryResponseDtos = orderService.getOrderHistoryById(orderId);
    return ResponseEntity.ok(orderHistoryResponseDtos);
  }

  @PostMapping({"{orderId}/status"})
  public ResponseEntity<OrderHistoryResponseDto> updateOrderStatus(@PathVariable UUID orderId, @RequestBody UpdateOrderStatusDto updateOrderStatusDto) {
    OrderHistoryResponseDto orderHistoryResponseDto = orderService.createOrderHistory(orderId, updateOrderStatusDto.getOrderStatus(), updateOrderStatusDto.getUpdateTime());
    return ResponseEntity.ok(orderHistoryResponseDto);
  }

}
