package com.example.taxes.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {

    private String name;
    private BigDecimal price;
    private boolean imported;

    public Product(String name, BigDecimal price, boolean imported) {
        this.name = name;
        this.price = price.setScale(2, RoundingMode.CEILING);
        this.imported = imported;
    }
    public Product() { }

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
