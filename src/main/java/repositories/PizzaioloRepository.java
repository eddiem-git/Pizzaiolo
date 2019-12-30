package repositories;

import models.Pizzaiolo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaioloRepository extends CrudRepository<Pizzaiolo, Long> {
}