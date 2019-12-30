package testModels;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Pizza;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.Entity;

public class TestPizza {
    @Test
    public void testClassSignatureAnnotations() {
        Assert.assertTrue(Pizza.class.isAnnotationPresent(Entity.class));
    }
    @Test
    public void testCreateJson() throws JsonProcessingException {
        ObjectMapper jsonWriter = new ObjectMapper();
        Pizza pizza = new Pizza();
        String json = jsonWriter.writeValueAsString(pizza);
    }
}