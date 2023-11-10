package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.luv2code.aopdemo.service.*.fortune(..))")
    public Object aroundGetFortunes(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        // print out the method we are advising on.
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n ========> executing @Around on method:  " + method);

        // get begin timestamp.
        long begin = System.currentTimeMillis();

        // now, let us execute the method.
        Object result = null;

        try {

            result = theProceedingJoinPoint.proceed();

        }catch(Exception exe) {

            return exe;
        }


        // get ends timestamp.
        long end = System.currentTimeMillis();

        // compute duration and display it.
        long duration = end - begin;
        System.out.println("\n =====> the duration: " + duration);

        return result;
    }

    // add a new advice for @After on findAccounts method.
    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {

        // print out which method we are advising on.
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n ========> executing @After (finally) on method:  " + method);

    }

    // add a new advice for @AfterThrowing on findAccounts method.
    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExe")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExe) {

        // print out which method we are advising on.
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n ========> executing @AfterThrowing on method:  " + method);

        // log the exception
        System.out.println("\n ========> returning results: " + theExe);
    }

    // add a new advice for @AfterReturning on findAccounts method.
    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

        // print out which method we are advising on.
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n ========> executing @AfterReturning on method:  " + method);

        // print out the results of the method call.
        System.out.println("\n ========> returning results: " + result);

        // let's post-process the data ... let's modify it.

        // convert the account names to uppercase.
        convertAccountNamesToUppercase(result);

        System.out.println("\n ========> returning results: " + result);
    }

    private void convertAccountNamesToUppercase(List<Account> result) {

        // loop through the accounts.
        for (Account tempAccount : result) {

            // get uppercase version of the names.
            String theUpperName = tempAccount.getName().toUpperCase();

            // update the name of the account.
            tempAccount.setName(theUpperName);
        }
    }


    // applying pointcut oon one device.
    @Before("com.luv2code.aopdemo.aspect.LuvAOPExpressions.forDAOPackageWithoutSetterOrGetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

        System.out.println("\n============> Executing @Before Advice on AddAccount ()");

        // display the method signature.
        MethodSignature theMethodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + theMethodSignature);

        // display method arguments.

        // get args.
        Object[] args = theJoinPoint.getArgs();

        // loop thru the args.
        for (Object tempArg : args) {
            System.out.println(tempArg);

            if (tempArg instanceof Account) {

                // downcast and print account specific stuff.
                Account theAccount = (Account) tempArg;
                System.out.println("acccount name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }
        }
    }

}























