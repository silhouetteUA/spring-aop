package com.mycompany.aopdemo.dao;

import com.mycompany.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private String name;

    public void addAccount(Account account, boolean vipFlag)    {
        System.out.println(getClass() + ": Doing my DB work: adding an account");
    }

    public AccountDAO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
