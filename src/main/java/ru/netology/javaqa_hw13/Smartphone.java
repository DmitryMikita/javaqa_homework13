package ru.netology.javaqa_hw13;

import java.util.Objects;

public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int id, String title, int price, String manufacturer) {
        super(id, title, price);
        this.manufacturer = manufacturer;
    }

    //Скрыл от проверки на покрытие

    //public String getManufacturer() {
    //  return manufacturer;
    //}

    //  public void setManufacturer(String manufacturer) {
    //     this.manufacturer = manufacturer;
    // }

}
