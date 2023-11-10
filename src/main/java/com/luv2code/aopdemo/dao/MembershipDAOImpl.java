package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{
    @Override
    public boolean addSillyMember() {

        System.out.println(getClass() + ": MEMBERSHIP AOP");

        return true;

    }

    @Override
    public void goingToSleep() {

        System.out.println("going to sleep now");
    }
}
