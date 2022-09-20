package com.example.ooppractice.calculator.calculate2;

public class PositiveNumber2 {
    private final int num;

    public PositiveNumber2(int num) {
        validCheck(num);
        this.num = num;
    }

    private void validCheck(int num) {
        if(isNegativeNumber(num)){
            throw new IllegalArgumentException("0또는 음수를 전달할 수 없습니다.");
        }
    }

    private boolean isNegativeNumber(int num) {
        return 0>=num;
    }

    public int toInt(){
        return this.num;
    }
}
