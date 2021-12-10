package com.example.taxes.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductRepository {
    private static ProductRepository instance;
    private ArrayList<Product> products;

    public static ProductRepository getInstance() {
        if (instance == null){
            instance = new ProductRepository();
        }
        return instance;
    }

    private ProductRepository(){
        products = new ArrayList<>();
        products.add(new Product("Headphone", new BigDecimal(10), true));
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    private Product findProductById(String id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst().orElse(null);
    }

    public void deleteProduct(String id) {
        products.remove(findProductById(id));
    }

    public BigDecimal calculateTotalTaxes() {
        BigDecimal total = new BigDecimal(0);
        for(Product product : products) {
            total = total.add(product.getPriceWithTaxes());
        }
        System.out.println(total);
        return total;
    }
}
