package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudAsyncAspect {

    @Before("com.luv2code.aopdemo.aspect.LuvAOPExpressions.forDAOPackageWithoutSetterOrGetter()")
    public void logToMyCloudAsync() {

        System.out.println("\n============> logging to my cloud async fashion");
    }
}
