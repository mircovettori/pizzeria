package pizzeria.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pizzeria.domain.Pizza;
import pizzeria.dto.PizzaDto;
import pizzeria.service.PizzaService;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@Controller
@RequestMapping("/pizza")
public class PizzaController {

  @Autowired
  PizzaService pizzaService;

  @GetMapping({"/fetch/{pizzaId}"})
  public ResponseEntity<Pizza> getPizza(@PathVariable UUID pizzaId) {
    return ResponseEntity.ok(pizzaService.getPizzaById(pizzaId));
  }

  @GetMapping
  public ResponseEntity<List<Pizza>> getAllPizzas() {
    List<Pizza> pizzas = pizzaService.getPizzas();
    return ResponseEntity.ok(pizzas);
  }

  @PostMapping
  public ResponseEntity<Pizza> savePizza(@RequestBody PizzaDto userDto) {
    Pizza newPizza = pizzaService.insert(userDto);
    return ResponseEntity.ok(newPizza);
  }

  //The function receives a PUT request, updates the Pizza with the specified Id and returns the updated Pizza
  @PutMapping
  public ResponseEntity<Pizza> updatePizza(@RequestBody PizzaDto userDto) {
    Pizza updatedPizza = pizzaService.updatePizza(userDto);
    return ResponseEntity.ok(updatedPizza);
  }

  //The function receives a DELETE request, deletes the Pizza with the specified Id.
  @DeleteMapping({"/{pizzaId}"})
  public ResponseEntity<Void> deletePizza(@PathVariable("pizzaId") UUID pizzaId) {
    pizzaService.deletePizza(pizzaId);
    return ResponseEntity.ok().build();
  }

}
