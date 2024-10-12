package pizzeria.repository;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.PagingAndSortingRepository;
import pizzeria.domain.Order;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends PagingAndSortingRepository<Order, UUID> {
    List<Order> findByUserId(UUID userId, Pageable pageable);
}
