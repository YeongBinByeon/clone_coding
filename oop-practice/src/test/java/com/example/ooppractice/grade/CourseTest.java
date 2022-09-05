package com.example.ooppractice.grade;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CourseTest {
    @DisplayName("과목(코스)를 생성한다.")
    @Test
    void createTest(){
        Assertions.assertThatCode(()-> new Course("OOP",3,"A+"))
                .doesNotThrowAnyException();
    }

}
