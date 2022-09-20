package com.example.ooppractice.calculator;

import com.example.ooppractice.calculator.calculate2.*;

import java.util.List;

public class Calculator2 {

    private static final List<NewArithmeticOperator2> arithmeticOperator2List =
            List.of(new AdditionOperator2(), new DivisionOperator2(), new MultiplicationOperator2(), new SubtractionOperator2());

    public static int calculate(PositiveNumber2 num1, String operand, PositiveNumber2 num2){
        return arithmeticOperator2List.stream()
                .filter( newArithmeticOperator2 -> newArithmeticOperator2.support(operand) )
                .map( newArithmeticOperator2 -> newArithmeticOperator2.calculate(num1,num2) )
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));



    }
}
