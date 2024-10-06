package pizzeria.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pizzeria.domain.Order;
import pizzeria.domain.OrderHistory;
import pizzeria.domain.OrderStatus;
import pizzeria.repository.OrderHistoryRepository;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class OrderHistoryService {

  @Autowired
  OrderHistoryRepository orderHistoryRepository;

  @Transactional
  public OrderHistory createOrderHistory(Order order, OrderStatus orderStatus, Long updateTime) {
    OrderHistory orderHistory = OrderHistory.builder().order(order).orderStatus(orderStatus).updateTime(updateTime).build();
    return orderHistoryRepository.save(orderHistory);
  }

  @Transactional
  public List<OrderHistory> getOrderHistoryById(UUID orderId) {
    return orderHistoryRepository.findByOrderId(orderId);
  }
}
