package com.dipractice.di;

import com.dipractice.annotation.Inject;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.util.Set;

public class BeanFactoryUtils {
    public static Constructor<?> getInjectedConstructor(Class<?> clazz){
        // annotation이 붙은 class의 생성자에서 Inject annotation이 붙은 생성자만 가져옴
        Set<Constructor> injectedConstructors = ReflectionUtils.getAllConstructors(clazz, ReflectionUtils.withAnnotation(Inject.class));
        if(injectedConstructors.isEmpty()){
            return null;
        }
        return injectedConstructors.iterator().next();
    }
}
