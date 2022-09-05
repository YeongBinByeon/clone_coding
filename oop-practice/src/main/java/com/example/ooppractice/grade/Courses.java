package com.example.ooppractice.grade;

import java.util.List;

// 일급 콜랙션이란 ? : list 형태로 된 course 만 인스턴스 변수로 가지는 클래스이다.
// 해당 값 이외의 변수가 있으면 안된다.
// 해당 인스턴스 정보들을 가지고 처리 할 수 있는 책임들이 해당 일급 컬렉션 안으로 응집될 수 있다.
public class Courses {
    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multiplyCreditAndCourseGrade(){
        // (학점수*교과목 평점)의 합계
//        double multipliedCreditAndCourseGrade = 0;
//        for(Course course : courses){
//            multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
//        }
//        return multipliedCreditAndCourseGrade;

        return courses.stream()
                .mapToDouble(Course::multiplyCreditAndCourseGrade)
                .sum();
    }

    public int calculateTotalCompletedCredit() {
        return courses.stream()
                .mapToInt(course -> course.getCredit())
                .sum();
    }
}
