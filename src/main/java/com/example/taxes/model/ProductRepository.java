package com.example.taxes.model;

import java.math.BigDecimal;
import java.util.ArrayList;

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
        addProduct(new Product("Headphone", new BigDecimal(10), true));
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
