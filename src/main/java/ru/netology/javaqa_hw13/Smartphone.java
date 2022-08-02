package ru.netology.javaqa_hw13;

import java.util.Objects;

public class Smartphone extends Product {
    protected String model;

    public Smartphone(int id, String name, int price, String model, String manufacturer) {
        super(id, name, price);
        this.model = model;
        this.manufacturer = manufacturer;
    }

    protected String manufacturer;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return Objects.equals(model, that.model) && Objects.equals(manufacturer, that.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), model, manufacturer);
    }
}
