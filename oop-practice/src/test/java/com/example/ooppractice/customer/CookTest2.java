package com.example.ooppractice.customer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CookTest2 {
    @DisplayName("요리를 생성한다.")
    @Test
    void createTest(){
        Assertions.assertThatCode(()->new Cook2("만두", 5000))
                .doesNotThrowAnyException();
    }
}
