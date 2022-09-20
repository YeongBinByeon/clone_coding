package com.example.ooppractice.calculator.calculate2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PositiveNumber2Test {

    @ParameterizedTest
    @ValueSource(ints = {0,-1})
    void toInt(int value) {
        Assertions.assertThatCode(()-> new PositiveNumber2(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0또는 음수를 전달할 수 없습니다.");
    }
}