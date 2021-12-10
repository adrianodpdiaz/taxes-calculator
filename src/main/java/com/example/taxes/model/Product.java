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
    private static String[] allCategories;
    private String category;
    static {
        allCategories = new String[] {"book","food","medical","other"};
    }

    public Product(String name, BigDecimal price, boolean imported, String category) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price.setScale(2, RoundingMode.HALF_UP);
        this.imported = imported;
        this.category = category;
        this.priceWithTaxes = calculateTaxes();
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
        this.price = price.setScale(2, RoundingMode.HALF_UP);
        this.priceWithTaxes = calculateTaxes();
    }

    public Boolean getImported() {
        return imported;
    }

    public void setImported(Boolean imported) {
        this.imported = imported;
    }

    private BigDecimal calculateTaxes() {
        if(!this.imported) {
            if (!this.category.equals("other"))
                return this.price;
            return this.price.add(this.price.multiply(new BigDecimal(0.10)))
                    .setScale(2, RoundingMode.HALF_UP);
        }
        if (!this.category.equals("other"))
            return this.price.add(this.price.multiply(new BigDecimal(0.05)))
                    .setScale(2, RoundingMode.HALF_UP);
        return this.price.add(this.price.multiply(new BigDecimal(0.15)))
                .setScale(2, RoundingMode.HALF_UP);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static String[] getAllCategories() {
        return allCategories;
    }
}