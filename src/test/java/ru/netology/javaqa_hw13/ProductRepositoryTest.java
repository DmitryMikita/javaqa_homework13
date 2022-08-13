package ru.netology.javaqa_hw13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();

    Product book1 = new Book(1, "1984", 250, "Дж.Оруэл");
    Product book2 = new Book(2, "100 советов мэру", 300, "Илья Варламов");
    Product book3 = new Book(3, "Транспортные системы городов", 350, "Вукан Вучик");
    Product smartphone1 = new Smartphone(4, "Google Pixel2", 12000, "Google");
    Product smartphone2 = new Smartphone(5, "Honor Play", 25000, "Huawei");

    @BeforeEach
    public void SetUp() {
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
    }

    @Test

    public void shouldRemoveProductById() {
        repo.removeProductById(1);
        Product[] expected = {book2, book3, smartphone1, smartphone2};
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldFindAllProducts() {
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2};
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldAddProduct() {
        Smartphone smartphone3 = new Smartphone(6, "Honor Play", 50000, "Huawei");
        repo.save(smartphone3);
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.getProducts();
    }
}
