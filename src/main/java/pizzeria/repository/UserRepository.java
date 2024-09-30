package pizzeria.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import pizzeria.domain.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID>, JpaRepositoryImplementation<User, UUID> {}
