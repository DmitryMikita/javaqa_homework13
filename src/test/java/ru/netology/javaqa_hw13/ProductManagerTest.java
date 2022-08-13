package ru.netology.javaqa_hw13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product book1 = new Book(1, "1984", 250, "Дж.Оруэл");
    Product book2 = new Book(2, "100 советов мэру", 300, "Илья Варламов");
    Product book3 = new Book(3, "Транспортные системы городов", 350, "Вукан Вучик");
    Product smartphone1 = new Smartphone(4, "Google Pixel2", 12000, "Google");
    Product smartphone2 = new Smartphone(5, "Honor Play", 25000, "Honor");

    @BeforeEach
    public void SetUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
    }

    @Test

    public void shouldAddProduct() {
        Smartphone smartphone3 = new Smartphone(6, "Honor Play", 50000, "Huawei");
        manager.add(smartphone3);
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = manager.findAll();
    }

    @Test

    public void shouldFindAllTitleProducts() {
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2};
        Product[] actual = manager.searchBy("");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldFindTitleSmartphone() {
        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("Google Pixel2");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldNotFindTitleSmartphone() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Samsung");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldNotFindTitleSmartphoneIncorrect() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("readmi note 11");
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test

    public void shouldFindTitleBook() {
        Product[] expected = {book1};
        Product[] actual = manager.searchBy("1984");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldNotFindTitleBook() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Курьер");
        Assertions.assertArrayEquals(expected, actual);

    }


    @Test

    public void shouldNotFindTitleBookIncorrect() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Мертвые в душе");
        Assertions.assertArrayEquals(expected, actual);
    }


}
