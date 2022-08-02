package ru.netology.javaqa_hw13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product book1 = new Book(111,"Выбор", 457, "Эдит Ева Эгер");
    Product book2 = new Book(22,"Хочу и буду", 80, "Лобковский");
    Product book3 = new Book(3333,"1984", 113, "Джордж Оруэлл");


    @Test
    public void searchByName() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product [] actual = manager.searchBy("Выбор");
        Product[] expected = {book3};
        Assertions.assertArrayEquals(expected,actual);
    }



}
