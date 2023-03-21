package ru.netology.inheritance;

public class Smartphone extends Product {
    private String fabricator;

    public Smartphone(int id, String productName, int price, String fabricator) {
        super(id, productName, price);
        this.fabricator = fabricator;
    }

}
