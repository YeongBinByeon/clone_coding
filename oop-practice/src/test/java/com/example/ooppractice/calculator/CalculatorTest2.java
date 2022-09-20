package com.example.ooppractice.calculator;

import com.example.ooppractice.calculator.calculate2.PositiveNumber2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * 요구사항
 * 간단한 사칙연산을 할 수 있다.
 * 양수로만 계산할 수 있다
 * 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다
 * MVC패턴(Model-view-Controller) 기반으로 구현한다.
 */
public class CalculatorTest2 {

    @DisplayName("사칙 연산을 수행한다.")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void calculateTest(int num1, String operand, int num2, int result){
        int calculateResult = Calculator2.calculate(new PositiveNumber2(num1),operand, new PositiveNumber2(num2));
        Assertions.assertEquals(calculateResult,result);
    }

    private static Stream<Arguments> formulaAndResult(){
        return Stream.of(
                arguments(1,"+",2,3),
                arguments(1,"-",2,-1),
                arguments(4,"*",2,8),
                arguments(4,"/",2,2)
        );
    }

}
