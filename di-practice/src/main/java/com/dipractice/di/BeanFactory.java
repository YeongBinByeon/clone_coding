package com.dipractice.di;

import com.dipractice.annotation.Inject;
import com.dipractice.controller.UserController;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class BeanFactory {
    private final Set<Class<?>> preInstantiatedClazz;
    private Map<Class<?>, Object> beans = new HashMap<>();

    public BeanFactory(Set<Class<?>> preInstantiatedClazz) {
        this.preInstantiatedClazz = preInstantiatedClazz;
        initialize();
    }

    private void initialize(){
        for(Class<?> clazz : this.preInstantiatedClazz){
            Object instance = createInstance(clazz);
            beans.put(clazz, instance);
            System.out.println("beans.toString() = " + beans.toString());
        }
    }

    // 아래는 인스턴스 생성 시도하는 순서
    // UserController
    // UserService
    private Object createInstance(Class<?> clazz) {
        // 생성자
        Constructor<?> constructor = findConstructor(clazz);

        // 파라미터
        List<Object> parameters = new ArrayList<>();
        for(Class<?> typeClass : constructor.getParameterTypes()){
            // UserService
            parameters.add(getParameterByClass(typeClass));
        }

        try {
            return constructor.newInstance(parameters.toArray());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
           throw new RuntimeException(e);
        }
    }

    private Object getParameterByClass(Class<?> typeClass) {
        Object instanceBean = getBean(typeClass);

        if(Objects.nonNull(instanceBean)){
            return instanceBean;
        }

        return createInstance(typeClass);
    }

    private Constructor<?> findConstructor(Class<?> clazz){
        Constructor<?> constructor = BeanFactoryUtils.getInjectedConstructor(clazz);

        if(Objects.nonNull(constructor)){
            return constructor;
        }
        return clazz.getConstructors()[0];
    }


    public <T> T getBean(Class<T> requiredType) {
        return (T) beans.get(requiredType);
    }
}
