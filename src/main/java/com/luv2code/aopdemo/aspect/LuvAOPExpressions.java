package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LuvAOPExpressions {

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    public void forDAOPackage() {
    }

    // create a pointcut for the getters methods.
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
    public void getMethod() {}

    // create a pointcut for the setters methods.
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
    public void setMethod() {}

    // create a pointcut: include package... exclude the getters/setters methods.
    @Pointcut("forDAOPackage() && !(setMethod() || getMethod())")
    public void forDAOPackageWithoutSetterOrGetter() {}


}
