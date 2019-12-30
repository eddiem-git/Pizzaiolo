package controllers;

import models.Pizza;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.PizzaService;

@Controller
public class PizzaController {

    private PizzaService service;

    public PizzaController(PizzaService service) {
        this.service = service;
    }
    @GetMapping("/pizza")
    public ResponseEntity<Iterable<Pizza>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }
    @GetMapping("/pizza/{id}")
    public ResponseEntity<Pizza> show(@PathVariable Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }
    @PostMapping("/pizza")
    public ResponseEntity<Pizza> create(@RequestBody Pizza pizzaiolo) {
        return new ResponseEntity<>(service.create(pizzaiolo), HttpStatus.CREATED);
    }
    @PutMapping("/pizza/{id}")
    public ResponseEntity<Pizza> update(@PathVariable Long id,@RequestBody Pizza pizzaiolo) {
        return new ResponseEntity<>(service.update(id, pizzaiolo), HttpStatus.OK);
    }
    @DeleteMapping("/pizza/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}