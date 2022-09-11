package com.dipractice.di;

import com.dipractice.annotation.Controller;
import com.dipractice.annotation.Service;
import com.dipractice.controller.UserController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BeanFactoryTest {
    private Reflections reflections;
    private BeanFactory beanFactory;

    @BeforeEach
    void setUp(){
        reflections = new Reflections("com.dipractice");
        // UserController, UserService
        Set<Class<?>> preInstantiatedClazz = getTypesAnnotatedWith(Controller.class, Service.class);
        beanFactory = new BeanFactory(preInstantiatedClazz);

    }

    private Set<Class<?>> getTypesAnnotatedWith(Class<? extends Annotation>... annotations ) {
        Set<Class<?>> beans = new HashSet<>();
        for(Class<? extends Annotation> annotation : annotations){
            beans.addAll(reflections.getTypesAnnotatedWith(annotation));
        }
        return beans;
    }

    @Test
    void diTest(){
        UserController userController = beanFactory.getBean(UserController.class);

        Assertions.assertThat(userController).isNotNull();
        Assertions.assertThat(userController.getUserService()).isNotNull();
    }

}