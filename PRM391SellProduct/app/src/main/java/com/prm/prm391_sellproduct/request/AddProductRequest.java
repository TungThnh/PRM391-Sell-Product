package com.prm.prm391_sellproduct.request;

public class AddProductRequest {
    private String name;
    private String code;
    private String description;
    private float price;
    private String unit;
    private float quantity;


    // Getter Methods

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public String getUnit() {
        return unit;
    }

    public float getQuantity() {
        return quantity;
    }

    // Setter Methods

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }
}
