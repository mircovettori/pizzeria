package pizzeria.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import pizzeria.domain.Order;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID>, JpaRepositoryImplementation<Order, UUID> {
    List<Order> findByUserId(UUID userId);
}
