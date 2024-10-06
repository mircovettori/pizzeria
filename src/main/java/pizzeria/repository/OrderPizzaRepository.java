package pizzeria.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import pizzeria.domain.OrderPizza;

import java.util.UUID;

public interface OrderPizzaRepository extends JpaRepository<OrderPizza, UUID>, JpaRepositoryImplementation<OrderPizza, UUID> {}
