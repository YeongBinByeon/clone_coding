package com.dipractice.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.CONSTRUCTOR,ElementType.FIELD,ElementType.METHOD})
public @interface Inject {
}
