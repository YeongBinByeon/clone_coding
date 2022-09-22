package com.example.ooppractice.customer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MenuTest2 {
    @DisplayName("메뉴판에서 해당하는 메뉴를 반환한다.")
    @Test
    void chooseTest(){
        Menu2 menu = new Menu2(List.of(new MenuItem2("돈까스", 5000), new MenuItem2("냉면", 7000)));

        MenuItem2 menuItem = menu.choose("돈까스");

        Assertions.assertThat(menuItem).isEqualTo(new MenuItem2("돈까스", 5000));
    }

    @DisplayName("메뉴판에서 해당하는 메뉴를 반환한다.")
    @Test
    void chooseTest2(){
        Menu2 menu = new Menu2(List.of(new MenuItem2("돈까스", 5000), new MenuItem2("냉면", 7000)));

        Assertions.assertThatCode(()-> menu.choose("통닭"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 메뉴 이름입니다.");
    }
}
