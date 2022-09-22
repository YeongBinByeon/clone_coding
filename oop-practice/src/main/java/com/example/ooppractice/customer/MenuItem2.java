package com.example.ooppractice.customer;

import java.util.Objects;

public class MenuItem2 {
    private final String name;

    private final int price;

    public MenuItem2(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean matches(String name){
        return this.name.equals(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem2 menuItem2 = (MenuItem2) o;
        return price == menuItem2.price && Objects.equals(name, menuItem2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
