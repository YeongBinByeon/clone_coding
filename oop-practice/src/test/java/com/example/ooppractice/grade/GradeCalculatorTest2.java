package com.example.ooppractice.grade;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 요구사항
 *  평균학점 계산 방법 = (학점수*교과목 평점)의 합계/수강신청 총학점 수
 *  일급 컬렉션 사용
 *
 *  객체지향 설계 및 구현
 *  1. 도메인을 구성하는 객체에는 어떤 것들이 있는지 고민 (해당 단계에서 전부 도출하는 것이 아니라 생각나는 부분까지만 도출함)
 *  2. 객체들 간의 관계를 고민
 *  3. 동적인 객체를 정적인 타입으로 추상화해서 도메인 모델링 하기
 *  4. 협력을 설계
 *  5. 객체들을 포괄하는 타입에 적절한 책임을 할당
 *  6. 구현하기기
 *
 */
public class GradeCalculatorTest2 {
    // 1. 학점계산기 도메인 : 이수한 과목, 학점 계산기 (해당 단계에서 전부 도출하는 것이 아니라 생각나는 부분까지만 도출함)

    // 2. 학점 계산기가 이수한 과목을 인스턴스 변수로  가지면서 평균 학점을 계산할 수 있겠다

    // 3. 떠오른 객체들을 쭉 나열한 다음 어떤 클래스로 매핑되는지 모델링 하는 것,
    //    객체지향프로그래밍, 자료구조, 중국어회화 과목이 있을 것이고 ---> 과목(코스) 클래스

    // 4. 이수한 과목을 전달하여 평균학점 계산 요청 ---> 학점 계산기  ---> (학점수*교과목 평점)의 합계  ---> 과목(코스)
    //
    @DisplayName("평균 학점을 계산한다.")
    @Test
    void calculateGradeTest(){
        List<Course2> courses = List.of(new Course2("OOP", 3, "A+"),
                new Course2("자료구조", 3, "A+"));
        GradeCalculator2 gradeCalculator2 = new GradeCalculator2(courses);
        Double result = gradeCalculator2.calculate();

        Assertions.assertThat(4.5).isEqualTo(result);

    }

}
