package ru.netology.inheritance;

public class Book extends Product {
    private String author;

    public Book(int id, String productName, int price, String author) {
        super(id, productName, price);
        this.author = author;
    }

}
