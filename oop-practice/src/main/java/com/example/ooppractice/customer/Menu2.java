package com.example.ooppractice.customer;

import java.util.List;

public class Menu2 {
    private List<MenuItem2> menuItems;

    public Menu2(List<MenuItem2> menuItems) {
        this.menuItems = menuItems;
    }

    public MenuItem2 choose(String name){
        return this.menuItems.stream()
                .filter(menuItem ->{
                    return menuItem.matches(name);
                })
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("잘못된 메뉴 이름입니다."));
    }
}
