package testModels;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Pizzaiolo;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.Entity;


public class TestPizzaiolo {
    @Test
    public void testClassSignatureAnnotations() {
        Assert.assertTrue(Pizzaiolo.class.isAnnotationPresent(Entity.class));
    }
    @Test
    public void testCreateJson() throws JsonProcessingException {
        ObjectMapper jsonWriter = new ObjectMapper();
        Pizzaiolo pizzaiolo = new Pizzaiolo();
        String json = jsonWriter.writeValueAsString(pizzaiolo);
    }
}
