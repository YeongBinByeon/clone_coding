package com.example.ooppractice.calculator.calculate2;

public class AdditionOperator2 implements NewArithmeticOperator2 {

    @Override
    public boolean support(String operand) {
        return "+".equalsIgnoreCase(operand);
    }

    @Override
    public int calculate(PositiveNumber2 num1, PositiveNumber2 num2) {
        return num1.toInt()+num2.toInt();
    }
}
