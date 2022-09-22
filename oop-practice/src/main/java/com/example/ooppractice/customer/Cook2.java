package com.example.ooppractice.customer;

import java.util.Objects;

public class Cook2 {
    public final String name;
    public final int price;

    public Cook2(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Cook2(MenuItem2 menuItem2) {
        this.name = menuItem2.getName();
        this.price = menuItem2.getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cook2 cook2 = (Cook2) o;
        return price == cook2.price && Objects.equals(name, cook2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}

