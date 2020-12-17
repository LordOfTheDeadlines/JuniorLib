package com.lod.JuniorLib.logging;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;


@Component
@Aspect
public class ServLoggingAspect {
    private Logger logger = Logger.getLogger(ServLoggingAspect.class.getName());

    @Pointcut("within(com.lod.JuniorLib.service.*)")
    public void stringProcessingServicesMethods() {
    }

    @After("stringProcessingServicesMethods()")
    public void logServiceMethodCall(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        String className = jp.getSignature().getDeclaringTypeName().substring(26);
        logger.log(Level.INFO, "название сервиса: " + className+", название метода: " + methodName);
    }


}