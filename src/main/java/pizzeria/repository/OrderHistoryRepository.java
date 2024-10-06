package pizzeria.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import pizzeria.domain.OrderHistory;

import java.util.List;
import java.util.UUID;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, UUID>, JpaRepositoryImplementation<OrderHistory, UUID> {
    List<OrderHistory> findByOrderId(UUID orderId);
}
