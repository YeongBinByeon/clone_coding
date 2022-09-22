package com.example.ooppractice.grade;

import java.util.List;

public class Courses2 {

    private final List<Course2> courses;

    public Courses2(List<Course2> courses) {
        this.courses = courses;
    }


    public double multiplyCreditAndCourseGrade(){
        return courses.stream()
                .mapToDouble(Course2::multiplyCreditAndCourseGrade)
                .sum();
    }

    public int calculateTotalCompletedCredit() {
        return courses.stream()
                .mapToInt(course -> course.getCredit())
                .sum();
    }
}
