package com.example.ooppractice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @DisplayName("패스워드를 초기화한다.")
    @Test
    void passwordTest(){
        // given
        User user = new User();

        // when
        user.initPassword(new CorrectFixedPasswordGenerator());

        // then
        assertThat(user.getPassword()).isNotNull();
    }

    @DisplayName("패스워드가 요구사하엥 부합되지 않아 초기화가 되지 않는다.")
    @Test
    void passwordTest2(){
        // given
        User user = new User();

        // when
        user.initPassword(new WrongFixedPasswordGenerator());

        // then
        assertThat(user.getPassword()).isNull();

    }
}