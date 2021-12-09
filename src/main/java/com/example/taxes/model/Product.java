package com.example.taxes.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

public class Product {

    private String id;
    private String name;
    private BigDecimal price;
    private boolean imported;

    public Product(String name, BigDecimal price, boolean imported) {
        this.id = UUID.randomUUID().toString();
        System.out.println(this.id);
        this.name = name;
        this.price = price.setScale(2, RoundingMode.CEILING);
        this.imported = imported;
    }
    public Product() { }

    public String getId() {
        return id;
    }

    public void newId() {
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price.setScale(2, RoundingMode.CEILING);
    }

    public Boolean getImported() {
        return imported;
    }

    public void setImported(Boolean imported) {
        this.imported = imported;
    }
}
