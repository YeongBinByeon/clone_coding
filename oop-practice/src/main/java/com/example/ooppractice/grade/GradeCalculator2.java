package com.example.ooppractice.grade;

import java.util.List;

public class GradeCalculator2 {

    private final Courses2 courses2;


    public GradeCalculator2(List<Course2> courses) {
        this.courses2 = new Courses2(courses);
    }

    public double calculate() {
        double totalMultipliedCreditAndCourseGrade = courses2.multiplyCreditAndCourseGrade();


        // 수강신청 총 학점 수
        int totalCompletedCount = courses2.calculateTotalCompletedCredit();
        return totalMultipliedCreditAndCourseGrade / totalCompletedCount;
    }


}
