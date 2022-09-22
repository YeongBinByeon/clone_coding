package com.example.ooppractice.customer;

public class Customer2 {
    public void order(String name, Menu2 menu, Cooking2 cooking) {
        MenuItem2 menuItem = menu.choose(name);
        Cook2 cook2 = cooking.makeCook(menuItem);
    }
}
