package services;

import models.Pizza;
import org.springframework.stereotype.Service;
import repositories.PizzaRepository;

@Service
public class PizzaService {
    private PizzaRepository repository;

    public PizzaService(PizzaRepository repository) {
        this.repository = repository;
    }

    public Iterable<Pizza> index() {
        return repository.findAll();
    }

    public Pizza show(Long id) {
        return repository.findById(id).get();
    }

    public Pizza create(Pizza pizza) {
        return repository.save(pizza);
    }

    public Pizza update(Long id, Pizza newPizzaData) {
        Pizza pizza = repository.findById(id).get();
        pizza.setKind(newPizzaData.getKind());
        return repository.save(pizza);
    }

    public Boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}