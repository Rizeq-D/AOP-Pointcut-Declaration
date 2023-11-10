package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

    // applying the pointcut declarations on another device.
    @Before("com.luv2code.aopdemo.aspect.LuvAOPExpressions.forDAOPackageWithoutSetterOrGetter()")
    public void performAPIAnalytics() {

        System.out.println("\n============> performing API analytics");
    }

}
