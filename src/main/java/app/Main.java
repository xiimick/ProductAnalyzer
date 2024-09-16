// src/main/java/app/Main.java
package app;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.0),
                new Product("Coffee Maker", "Appliances", 80.0),
                new Product("Headphones", "Electronics", 150.0),
                new Product("Blender", "Appliances", 50.0),
                new Product("Smartphone", "Electronics", 800.0),
                new Product("Oven", "Appliances", 400.0)
        );

        Map<String, Double> avgPriceByCategory = getAveragePriceByCategory(products);
        avgPriceByCategory.forEach((category, avgPrice) ->
                System.out.println("Категорія: " + category + ", Середня ціна: " + avgPrice));

        Optional<Map.Entry<String, Double>> maxAvgPriceCategory = getMaxAveragePriceCategory(avgPriceByCategory);
        maxAvgPriceCategory.ifPresent(category ->
                System.out.println("Категорія з найвищою середньою ціною: " + category.getKey() + ", Середня ціна: " + category.getValue()));
    }

    public static Map<String, Double> getAveragePriceByCategory(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));
    }

    public static Optional<Map.Entry<String, Double>> getMaxAveragePriceCategory(Map<String, Double> avgPriceByCategory) {
        return avgPriceByCategory.entrySet().stream()
                .max(Map.Entry.comparingByValue());
    }
}
