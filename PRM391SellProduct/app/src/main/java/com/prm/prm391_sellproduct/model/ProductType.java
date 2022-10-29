package com.prm.prm391_sellproduct.model;

public class ProductType {
    int idProduct;
    String productName;
    String productImage;

    public ProductType(int idProduct, String productName, String productImage) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.productImage = productImage;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
}
