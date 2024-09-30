package pizzeria.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pizzeria.domain.Pizza;
import pizzeria.dto.PizzaDto;
import pizzeria.repository.PizzaRepository;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static pizzeria.exception.RestException.supplierCreateRestFormattedException;
import static pizzeria.exception.RestException.throwRestFormattedException;

@Slf4j
@Service
public class PizzaService {

  @Autowired
  PizzaRepository pizzaRepository;

  @Transactional
  public List<Pizza> getPizzas() {
    return pizzaRepository.findAll();
  }

  @Transactional
  public Pizza getPizzaById(UUID id) {
    return pizzaRepository.findById(id)
        .orElseThrow(
            supplierCreateRestFormattedException(INTERNAL_SERVER_ERROR, "Pizza not found")
        );
  }

  @Transactional
  public Pizza insert(PizzaDto pizzaDto) {
    if (pizzaDto.getId() != null) {
      throwRestFormattedException(INTERNAL_SERVER_ERROR, "cannot upload new pizza with id param");
    }
    Pizza pizza = Pizza.of(pizzaDto);
    return pizzaRepository.save(pizza);
  }

  @Transactional
  public Pizza updatePizza(PizzaDto pizzaDto) {
    Pizza pizza = Pizza.of(pizzaDto);
    Pizza pizzaFromDb = getPizzaById(pizza.getId());
    pizza.mergeWith(pizzaFromDb);
    return pizzaRepository.save(pizza);
  }

  @Transactional
  public void deletePizza(UUID id) {
    pizzaRepository.deleteById(id);
  }

}
