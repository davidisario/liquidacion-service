package com.mx.gepp.liquidacion.config;

import java.util.Date;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LogAspectConfig {
    private Date date;

    @Before("execution(* com.mx.gepp.*.controller.*.*(..))")

    public void logControllerMethodsBefore(JoinPoint joinPoint) {
        date = new Date();
        String nameMethod = joinPoint.getSignature().getName();
        String[] canonicalClase = joinPoint.getTarget().getClass().getCanonicalName().split("\\.");
        String className = canonicalClase[canonicalClase.length - 1];
        log.info("-");
        log.info("-");
        log.info("========== START {}.{} " + date + " ==========", className, nameMethod);
    }

    @After("execution(* com.mx.gepp.*.controller.*.*(..) )")
    public void logControllerMethodsAfter(JoinPoint joinPoint) {
        date = new Date();
        String nameMethod = joinPoint.getSignature().getName();
        String[] canonicalClase = joinPoint.getTarget().getClass().getCanonicalName().split("\\.");
        String className = canonicalClase[canonicalClase.length - 1];
        log.info("========== END {}.{} " + date + " ==========", className, nameMethod);
    }
}