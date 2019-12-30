package testServices;

import MainApp.PizzaioloApplication;
import controllers.PizzaioloController;
import models.Pizzaiolo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import services.PizzaioloService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PizzaioloApplication.class)
public class TestPizzaioloService {
    @MockBean
    private PizzaioloService service;

    private PizzaioloController controller;

    @Before
    public void setup(){
        this.controller = new PizzaioloController(service);
    }


    @Test
    public void testCreate() {
        // Given
        HttpStatus expected = HttpStatus.CREATED;
        Pizzaiolo expectedPizzaiolo = new Pizzaiolo(null, null, null);
        BDDMockito
                .given(service.create(expectedPizzaiolo))
                .willReturn(expectedPizzaiolo);

        // When
        ResponseEntity<Pizzaiolo> response = controller.create(expectedPizzaiolo);
        HttpStatus actual = response.getStatusCode();
        Pizzaiolo actualPizzaiolo = response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedPizzaiolo, actualPizzaiolo);
    }


    @Test
    public void testShow() {
        // Given
        Long pizzaioloId = 1L;
        HttpStatus expected = HttpStatus.OK;
        Pizzaiolo expectedPizzaiolo = new Pizzaiolo(pizzaioloId, null, null, null);
        BDDMockito.
                given(service.show(1L))
                .willReturn(expectedPizzaiolo);

        // When
        ResponseEntity<Pizzaiolo> response = controller.show(pizzaioloId);
        HttpStatus actual = response.getStatusCode();
        Pizzaiolo actualPizzaiolo = response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedPizzaiolo, actualPizzaiolo);
    }

}
