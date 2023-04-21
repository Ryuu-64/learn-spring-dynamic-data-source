package org.ryuu.learn.spring.dynamicdatasource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.ryuu.learn.spring.dynamicdatasource.PriorityPolicy.ANNOTATION_FIRST;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSourceRouting {
    String key();

    PriorityPolicy priorityPolicy() default ANNOTATION_FIRST;
}
