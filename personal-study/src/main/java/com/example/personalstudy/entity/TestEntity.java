package com.example.personalstudy.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "TestEntity")
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int age;

}
