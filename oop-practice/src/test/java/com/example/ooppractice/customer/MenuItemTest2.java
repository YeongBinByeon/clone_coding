package com.example.ooppractice.customer;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuItemTest2 {
    @DisplayName("메뉴항목을 생성한다.")
    @Test
    void createTest(){
        Assertions.assertThatCode(()->new MenuItem2("만두", 5000))
                .doesNotThrowAnyException();
    }
}
