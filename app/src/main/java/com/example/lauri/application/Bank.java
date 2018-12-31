package com.example.lauri.application;

import android.widget.Toast;

import java.util.ArrayList;

public class Bank {
    int accounts = 0;
    ArrayList<Account> account_list = new ArrayList();

    /*Adds an account to the list, takes in number, balance, type and pay boolean in that order*/
    public void addAccount(String n,int b,String t, boolean p) {
        account_list.add(new regAccount(n,b,t,p));
        accounts += 1;
        System.out.println("Account added.");
    }
    /*Returns a list of all the accounts' numbers*/
    public ArrayList<String> getAllAccounts() {
        System.out.println("Kaikki tilit:");
        ArrayList<String> accountNums = new ArrayList();
        if (account_list.isEmpty()) {
            return accountNums;
        }else {
            for (int i=0; i<accounts;i++) {
                String n = account_list.get(i).getNum();
                accountNums.add(n);
            }
            return accountNums;
        }
    }

    /*Takes in account number and deposit amount, adds deposit amount to given account. logs the transaction*/
    public void deposit(String x, int y) {
        Account g = findAccount(x);
        g.deposit(y);
        g.addEntry("deposit", y, g.getNum());
    }
    /*Takes in account number, card number and withdrawal amount, removes withdrawal amount from given account. logs the transaction when successful*/
    public int withdrawal(String x,int card, int y) {
        Account g = findAccount(x);
        Card c = g.findCard(card);
        if (c.getWithdrawalLimit()>y){
            System.out.println(g.getBalance());
            boolean moneyCheck = g.take(y);
            System.out.println(g.getBalance());
            if (!moneyCheck){
                return 3;
            }else {
                g.addEntry("withdrawal", y, g.getNum());
                return 1;
            }
        }else{
            System.out.println(c.getWithdrawalLimit());
            return 2;
        }
    }
    /*Takes in account number, card number and payment amount, removes payment amount from given account after checking if account allows it. logs the transaction when successful*/
    public int payment(String x,int card, int y) {
        Account g = findAccount(x);
        Card c = g.findCard(card);
        System.out.print(g.getPayBool());
        if (!g.getPayBool()){
            return 4;
        }

        if (c.getPaymentLimit()>y){
            System.out.println(g.getBalance());
            boolean moneyCheck = g.take(y);
            System.out.println(g.getBalance());
            if (!moneyCheck){
                return 3;
            }else {
                g.addEntry("payment", y, g.getNum());
                return 1;
            }
        }else{
            System.out.println(c.getPaymentLimit());
            return 2;
        }
    }
    /*Transfers money from one account to another, logs said transaction as entries in both accounts*/
    public int transfer(String from, String to, int amount){
        Account accFrom = findAccount(from);
        Account accTo = findAccount(to);
        boolean check = accFrom.take(amount);
        if (check){
            accTo.deposit(amount);
            accFrom.addEntry("transfer",amount,from,to);
            accTo.addEntry("transfer",amount,from,to);
            return 1;
        }else{
            return 2;
        }


    }
    /*Goes through bank and returns requested account*/
    public Account findAccount(String x) {
        Account g = new regAccount("",0,"",true);
        if (account_list.isEmpty()) {
            System.out.println("Pankissa ei ole tilejä.");
            return g;
        }else {
            for (int i=0;i<accounts;i++) {
                if (x.equals(account_list.get(i).getNum())){
                    g =  account_list.get(i);
                }
                else {
                    continue;
                }
            }
            return g;
        }
    }
    /*Singleton*/
    private static final Bank bank = new Bank();
    public static Bank getInstance() { return bank;}
}

