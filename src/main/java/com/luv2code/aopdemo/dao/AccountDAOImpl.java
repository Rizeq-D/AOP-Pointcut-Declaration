package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;

    private String serviceCode;

    @Override
    public List<Account> findAccounts() {

        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        // for academic purposes.... simulate the exception.
        if (tripWire) {

            throw new RuntimeException("no soup for your mama");
        }
        List<Account> myAccount = new ArrayList<Account>();

        // create sample accounts.
        Account temp1 = new Account("medo", "gold");
        Account temp2 = new Account("lolo", "silver");
        Account temp3 = new Account("roro", "platinum");

        // add them to our list.
        myAccount.add(temp1);
        myAccount.add(temp2);
        myAccount.add(temp3);

        return myAccount;
    }

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {

        System.out.println(getClass() + ": doing some work for the DB, AOP");

    }
    @Override
    public void dancer() {

        System.out.println("Mososo");
    }

    public String getName() {
        System.out.println(getClass() + ": getting the name");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": Setting the name");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": getting the service");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": setting the service code");
        this.serviceCode = serviceCode;
    }
}



























