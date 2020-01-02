package controllers;

import models.Pizzaiolo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.PizzaioloService;

@Controller
public class PizzaioloController {
    private PizzaioloService service;

    public PizzaioloController(PizzaioloService service) {
        this.service = service;
    }

    @GetMapping("/pizzaiolos/")
    public ResponseEntity<Iterable<Pizzaiolo>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    @GetMapping("/pizzaiolos/{id}")
    public ResponseEntity<Pizzaiolo> show(@PathVariable Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    @PostMapping("/pizzaiolos/")
    public ResponseEntity create(@RequestBody Pizzaiolo pizzaiolo) {
        return new ResponseEntity<>(service.create(pizzaiolo), HttpStatus.CREATED);
    }

    @PutMapping("/pizzaiolos/{id}")
    public ResponseEntity<Pizzaiolo> update(@PathVariable Long id,@RequestBody Pizzaiolo pizzaiolo) {
        return new ResponseEntity<>(service.update(id, pizzaiolo), HttpStatus.OK);
    }

    @DeleteMapping("/pizzaiolos/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}