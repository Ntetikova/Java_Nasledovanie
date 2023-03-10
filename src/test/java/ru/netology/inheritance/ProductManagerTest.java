package ru.netology.inheritance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Smartphone Smartphone1 = new Smartphone(121, "Smartphone_1", 70_000, "Fabricator_1");
    Smartphone Smartphone2 = new Smartphone(122, "Smartphone_2", 75_000, "Fabricator_2");
    Smartphone Smartphone3 = new Smartphone(123, "Smartphone_3", 80_000, "Fabricator_3");
    Book Book1 = new Book(111, "Book_1", 1_000, "Author_1");
    Book Book2 = new Book(112, "Book_2", 2_000, "Author_2");
    Book Book3 = new Book(113, "Book_3", 3_000, "Author_3");
    Book Book4 = new Book(113, "Book_3", 3_000, "Author_3");

    @BeforeEach
    public void setup() {
        manager.add(Smartphone1);
        manager.add(Smartphone2);
        manager.add(Smartphone3);

        manager.add(Book1);
        manager.add(Book2);
        manager.add(Book3);
        manager.add(Book4);
    }

    @Test
    public void shouldSearchAllBookBySameProductName() {
        String bookToSearch = "Book_3";
        Product[] expected = {Book3, Book4};
        Product[] actual = manager.searchBy(bookToSearch);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchBookByNonameAuthor() {
        String bookToSearchByAuthor = "Noname";
        Product[] expected = {};
        Product[] actual = manager.searchBy(bookToSearchByAuthor);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneByProductName() {
        String smartphoneToSearch = "Smartphone_2";
        Product[] expected = {Smartphone2};
        Product[] actual = manager.searchBy(smartphoneToSearch);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchSmartphoneByNonexistentProductName() {
        String smartphoneToSearch = "Smartphone_0";
        Product[] expected = {};
        Product[] actual = manager.searchBy(smartphoneToSearch);

        Assertions.assertArrayEquals(expected, actual);
    }
}
