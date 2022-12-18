package org.example.bytecode;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited
public @interface myAnnotation {
    String value() default "yb";

    int number() default 100;
}

