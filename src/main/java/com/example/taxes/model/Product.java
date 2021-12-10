package com.example.taxes.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

public class Product {

    private String id;
    private String name;
    private BigDecimal price;
    private boolean imported;
    private BigDecimal priceWithTaxes;

    public Product(String name, BigDecimal price, boolean imported) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price.setScale(2, RoundingMode.CEILING);
        this.priceWithTaxes = calculateTaxes();
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

    public BigDecimal getPriceWithTaxes() {
        return priceWithTaxes;
    }

    public void setPrice(BigDecimal price) {
        this.price = price.setScale(2, RoundingMode.CEILING);
        this.priceWithTaxes = calculateTaxes();
    }

    public Boolean getImported() {
        return imported;
    }

    public void setImported(Boolean imported) {
        this.imported = imported;
    }

    private BigDecimal calculateTaxes() {
        if(!imported) {
            return this.price.add(this.price.multiply(new BigDecimal(0.10))).setScale(2, RoundingMode.CEILING);
        }
        return this.price.add(this.price.multiply(new BigDecimal(0.15))).setScale(2, RoundingMode.CEILING);
    }
}