package com.example.personalstudy.repository;

import com.example.personalstudy.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long> {

    // QueryMethod
    TestEntity findByAge(int age);

    // Spring Data JPA @Query 어노테이션 활용 - JPQL 문법 Version
    @Query("select t from TestEntity t where t.age >= :age")
    List<TestEntity> findEntityLargeThanAge(@Param("age") int age);

    // Spring Data JPA @Query 어노테이션 활용 - Native SQL 문법 Version
    @Query(value = "select * from TEST_ENTITY where age >= :age", nativeQuery = true)
    List<TestEntity> findEntityLargeThanAgeNativeQuery(@Param("age") int age);

}
