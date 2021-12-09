package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;
import static org.junit.jupiter.api.Assertions.*;


class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book book1 = new Book(1, "Garry Potter", 150, "Rowling J.");
    private Book book2 = new Book(2, "Fantastic Beasts", 180, "Rowling J.");
    private Book book3 = new Book(3, "Glow", 250, "King S.");
    private Smartphone smartphone1 = new Smartphone(1, "Iphone", 56000, "Apple");
    private Smartphone smartphone2 = new Smartphone(2, "Honor", 30000, "Huawei");
    private Smartphone smartphone3 = new Smartphone(3, "Samsung", 56000, "Samsung");

    @BeforeEach
    void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    //по названию книги
    @Test
    public void shouldSearchByNameBook() {
        Product[] actual = manager.searchBy("Glow");
        Product[] expected = new Product[]{book3};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByNameBookFirstWord() {
        Product[] actual = manager.searchBy("Garry");
        Product[] expected = new Product[]{book1};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByNameBookSecondWord() {
        Product[] actual = manager.searchBy("Beasts");
        Product[] expected = new Product[]{book2};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByNameBookTwoWord() {
        Product[] actual = manager.searchBy("Fantastic Beasts");
        Product[] expected = new Product[]{book2};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByNameBookOneLetter() {
        Product[] actual = manager.searchBy("G");
        Product[] expected = new Product[]{book1, book3};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByNameNonExistentBook() {
        Product[] actual = manager.searchBy("Sinister");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);

    }
//по автору книги

    @Test
    public void shouldSearchByAuthorBook() {
        Product[] actual = manager.searchBy("King S.");
        Product[] expected = new Product[]{book3};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByAuthorNonExistentBook() {
        Product[] actual = manager.searchBy("Twain");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByAuthorNonExistentBookTwoWords() {
        Product[] actual = manager.searchBy("Mark Twain");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByAuthorTwoBook() {
        Product[] actual = manager.searchBy("Rowling");
        Product[] expected = new Product[]{book1, book2};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByAuthorTwoLetters() {
        Product[] actual = manager.searchBy("in");
        Product[] expected = new Product[]{book1, book2, book3};

        assertArrayEquals(expected, actual);

    }

//    Смартфоны по названию

    @Test
    public void shouldSearchByNameSmartphone() {
        Product[] actual = manager.searchBy("Iphone");
        Product[] expected = new Product[]{smartphone1};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByNameSmartphoneOneLetters() {
        Product[] actual = manager.searchBy("H");
        Product[] expected = new Product[]{smartphone2};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByNameSmartphoneTwo() {
        Product[] actual = manager.searchBy("on");
        Product[] expected = new Product[]{smartphone1, smartphone2};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByNameSmartphoneInvalid() {
        Product[] actual = manager.searchBy("Samsuong");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByNameNonExistentSmartphone() {
        Product[] actual = manager.searchBy("LG");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);


    }
// Смартфоны по производителю

    @Test
    public void shouldSearchByManufacturerSmartphone() {
        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = new Product[]{smartphone3};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByManufacturerSmartphoneTwoLetters() {
        Product[] actual = manager.searchBy("aw");
        Product[] expected = new Product[]{smartphone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByManufacturerTwoSmartphone() {
        Product[] actual = manager.searchBy("u");
        Product[] expected = new Product[]{smartphone2, smartphone3};

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchByNonExistentManufacturerSmartphone() {
        Product[] actual = manager.searchBy("Microsoft");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByTwoManufacturerSmartphone() {
        Product[] actual = manager.searchBy("");
        Product[] expected = new Product[]{book1, book2, book3, smartphone1, smartphone2, smartphone3};

        assertArrayEquals(expected, actual);
    }

}












