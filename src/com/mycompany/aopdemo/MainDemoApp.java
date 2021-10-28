package com.mycompany.aopdemo;

import com.mycompany.aopdemo.dao.AccountDAO;
import com.mycompany.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        System.out.println("Setting accountDAO name, calling setter");
        accountDAO.setName("Nikolay");
        System.out.println("setter complete");
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        Account account = new Account();
        account.setName("Nikolay2");
        account.setLevel("Gold");
        accountDAO.addAccount(account, true);
        System.out.println("\nCalling membership method:");
        membershipDAO.addAccount();
        System.out.println("\nCalling other membership method:");
        membershipDAO.addSillyMember();
        System.out.println("\nCalling other membership method:");
        membershipDAO.addSomeShit();
        context.close();


    }
}
