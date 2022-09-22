package com.example.ooppractice.customer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CookingTest2 {
    @DisplayName("메뉴에 해당하는 음식을 만든다.")
    @Test
    void makeCookTest() {
        Cooking2 cooking2 = new Cooking2();

        MenuItem2 menuItem2 = new MenuItem2("만두", 5000);

        Cook2 cook2 = cooking2.makeCook(menuItem2);

        Assertions.assertThat(cook2). isEqualTo(new Cook2("만두", 5000));
    }
}
