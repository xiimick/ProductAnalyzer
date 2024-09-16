// src/test/java/app/MainTest.java
package app;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    public void testGetAveragePriceByCategory() {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.0),
                new Product("Coffee Maker", "Appliances", 80.0),
                new Product("Headphones", "Electronics", 150.0),
                new Product("Blender", "Appliances", 50.0),
                new Product("Smartphone", "Electronics", 800.0),
                new Product("Oven", "Appliances", 400.0)
        );

        Map<String, Double> avgPriceByCategory = Main.getAveragePriceByCategory(products);
        assertEquals(725.0, avgPriceByCategory.get("Electronics"));  // Вірна середня ціна
        assertEquals(180.0, avgPriceByCategory.get("Appliances"));   // Вірна середня ціна
    }

    @Test
    public void testGetMaxAveragePriceCategory() {
        Map<String, Double> avgPriceByCategory = Map.of(
                "Electronics", 725.0,
                "Appliances", 180.0
        );

        Optional<Map.Entry<String, Double>> maxAvgPriceCategory = Main.getMaxAveragePriceCategory(avgPriceByCategory);
        assertTrue(maxAvgPriceCategory.isPresent());
        assertEquals("Electronics", maxAvgPriceCategory.get().getKey());
        assertEquals(725.0, maxAvgPriceCategory.get().getValue());
    }
}
