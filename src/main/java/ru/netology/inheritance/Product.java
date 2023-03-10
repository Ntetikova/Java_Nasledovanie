package ru.netology.inheritance;

public class Product {
    protected int id;
    protected String productName;
    protected int price;

    public Product(int id, String productName, int price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
    }

    public int getId() {

        return id;
    }

    public String getProductName() {

        return productName;
    }

}
