package services;

import models.Pizzaiolo;
import org.springframework.stereotype.Service;
import repositories.PizzaioloRepository;

@Service
public class PizzaioloService {
    private PizzaioloRepository repository;
    public PizzaioloService(PizzaioloRepository repository) {
        this.repository = repository;
    }

    public Iterable<Pizzaiolo> index() {
        return repository.findAll();
    }

    public Pizzaiolo show(Long id) {
        return repository.findById(id).get();
    }

    public Pizzaiolo create(Pizzaiolo pizzaiolo) {
        return repository.save(pizzaiolo);
    }

    public Pizzaiolo update(Long id, Pizzaiolo newPizzaioloData) {
        Pizzaiolo pizzaiolo = repository.findById(id).get();
        pizzaiolo.setName(newPizzaioloData.getName());
        pizzaiolo.setSpecialty(newPizzaioloData.getSpecialty());
        return repository.save(pizzaiolo);
    }

    public Boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}