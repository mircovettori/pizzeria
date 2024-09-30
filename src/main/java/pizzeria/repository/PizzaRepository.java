package pizzeria.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import pizzeria.domain.Pizza;
import pizzeria.domain.User;

import java.util.UUID;

public interface PizzaRepository extends JpaRepository<Pizza, UUID>, JpaRepositoryImplementation<Pizza, UUID> {}
