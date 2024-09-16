package app;

// ProductTest.java
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void testProductCreation() {
        Product product = new Product("Laptop", "Electronics", 1200.0);
        assertEquals("Laptop", product.getName());
        assertEquals("Electronics", product.getCategory());
        assertEquals(1200.0, product.getPrice());
    }

    @Test
    public void testSettersAndGetters() {
        Product product = new Product("Laptop", "Electronics", 1200.0);
        product.setName("Smartphone");
        product.setCategory("Mobile");
        product.setPrice(800.0);

        assertEquals("Smartphone", product.getName());
        assertEquals("Mobile", product.getCategory());
        assertEquals(800.0, product.getPrice());
    }
}
