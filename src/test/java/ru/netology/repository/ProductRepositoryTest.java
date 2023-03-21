package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.inheritance.Book;
import ru.netology.inheritance.Product;
import ru.netology.inheritance.Smartphone;

public class ProductRepositoryTest {
    Smartphone Smartphone1 = new Smartphone(121, "Smartphone_1", 70_000, "Fabricator_1");
    Smartphone Smartphone2 = new Smartphone(122, "Smartphone_2", 75_000, "Fabricator_2");
    Smartphone Smartphone3 = new Smartphone(123, "Smartphone_3", 80_000, "Fabricator_3");
    Book Book1 = new Book(111, "Book_1", 1_000, "Author_1");
    Book Book2 = new Book(112, "Book_2", 2_000, "Author_2");
    Book Book3 = new Book(113, "Book_3", 3_000, "Author_3");
    Book Book4 = new Book(113, "Book_3", 3_000, "Author_3");


    //сохранение
    @Test
    public void testBySaveAllProducts() {
        ProductRepository repo = new ProductRepository();
        repo.save(Smartphone1);
        repo.save(Smartphone2);
        repo.save(Smartphone3);

        repo.save(Book1);
        repo.save(Book2);
        repo.save(Book3);
        repo.save(Book4);

        Product[] expected = {Smartphone1, Smartphone2, Smartphone3, Book1, Book2, Book3, Book4};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    //удаление по Id
    @Test
    public void testByRemoveById() {
        ProductRepository repo = new ProductRepository();
        repo.save(Smartphone1);
        repo.save(Smartphone2);
        repo.save(Smartphone3);

        repo.save(Book1);
        repo.save(Book2);
        repo.save(Book3);
        repo.save(Book4);
        repo.removeById(Smartphone3.getId());

        Product[] expected = {Smartphone1, Smartphone2, Book1, Book2, Book3, Book4};
        ;
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindById() {
        ProductRepository repo = new ProductRepository();
        repo.save(Smartphone3);
        repo.findById(Smartphone3.getId());

        Product[] expected = {Smartphone3};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testNotFoundException() {
        ProductRepository repo = new ProductRepository();
        repo.save(Smartphone1);
        repo.save(Smartphone2);
        repo.save(Smartphone3);

        repo.save(Book1);
        repo.save(Book2);
        repo.save(Book3);
        repo.save(Book4);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(-1);
        });
    }
}
