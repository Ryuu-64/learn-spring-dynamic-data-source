package org.ryuu.learn.spring.dynamicdatasource.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.ryuu.learn.spring.dynamicdatasource.DataSourceRouting;
import org.ryuu.learn.spring.dynamicdatasource.PriorityPolicy;
import org.ryuu.learn.spring.dynamicdatasource.component.datasource.context.DataSourceContextHolder;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Aspect
@Component
public class DataSourceRoutingAspect {
    @Pointcut(
            "@annotation(org.ryuu.learn.spring.dynamicdatasource.DataSourceRouting)|| " +
            "within(@org.ryuu.learn.spring.dynamicdatasource.DataSourceRouting *)"
    )
    public void dataSourceRoutingPointCut() {
    }

    @Around("dataSourceRoutingPointCut()")
    public Object dataSourceRouting(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        DataSourceRouting dataSourceRouting = signature.getMethod().getAnnotation(DataSourceRouting.class);
        if (dataSourceRouting == null) {
            Class<?> targetClass = point.getTarget().getClass();
            dataSourceRouting = AnnotationUtils.findAnnotation(targetClass, DataSourceRouting.class);
        }
        if (dataSourceRouting == null) {
            throw new IllegalStateException("DataSourceRouting not found.");
        }
        if (
                dataSourceRouting.priorityPolicy() == PriorityPolicy.ANNOTATION_FIRST ||
                ObjectUtils.isEmpty(DataSourceContextHolder.getContext().getDataSourceKey())
        ) {
            DataSourceContextHolder.getContext().setDataSourceKey(dataSourceRouting.key());
        }
        try {
            return point.proceed();
        } finally {
            DataSourceContextHolder.getContext().clearDataSourceKey();
        }
    }
}
