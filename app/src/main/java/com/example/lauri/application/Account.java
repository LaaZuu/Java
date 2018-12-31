package com.example.lauri.application;

import android.text.method.Touch;
import android.widget.Toast;

import java.util.ArrayList;

abstract class Account {
    protected String num;
    protected int balance;
    protected String type;
    protected boolean canPay;
    ArrayList<Card> cardList = new ArrayList();
    ArrayList<AccountEntry> entryList = new ArrayList();
    private int cards = 0;

    /*Takes money from the account*/
    protected boolean take(int x) {
        if (x < balance) {
            balance -= x;
            return true;
        }else {
            return false;
        }
    }
    /*Adds a card to the account, w: withdrawal limit, p: payment limit a: area boolean */
    public void addCard(int w,int p, boolean a){
        cards +=1;
        cardList.add(new Card(w,p,a,cards));

    }
    public void addEntry(String type, int amount, String account){
        entryList.add(new AccountEntry(type,amount,account));
    }
    public void addEntry(String type, int amount, String accFrom, String accTo){
        entryList.add(new AccountEntry(type, amount, accFrom, accTo));
    }
    /*Returns accounts card id numbers in a list*/
    public ArrayList<Integer> getAllCards() {
        ArrayList<Integer> cardNums = new ArrayList();
        if (cardList.isEmpty()) {
            return cardNums;
        }else {
            for (int i=0; i<cards;i++) {
                int n = cardList.get(i).getCardNum();
                cardNums.add(n);
            }
            return cardNums;
        }
    }
    /*Returns all account entries in a readable form*/
    public ArrayList<String> getAllEntries() {
        ArrayList<String> accountEntries = new ArrayList();
        if (entryList.isEmpty()) {
            return accountEntries;
        }else {
            for (int i=0; i<entryList.size();i++) {
                String n = entryList.get(i).getInfo();
                accountEntries.add(n);
            }
            return accountEntries;
        }
    }
    /* Returns a list of AccountEntry objects for json reasons*/
    public ArrayList<AccountEntry> getEntryObjects(){
        ArrayList<AccountEntry> accountEntries = new ArrayList();
        if (entryList.isEmpty()) {
            return accountEntries;
        }else {
            for (int i=0; i<entryList.size();i++) {
                AccountEntry n = entryList.get(i);
                accountEntries.add(n);
            }
            return accountEntries;
        }
    }
    /*Searches for card by id and returns the object, if not found returns empty card*/
    public Card findCard(int x) {
        Card card;
        if (cardList.isEmpty()) {
            card = new Card(0,0,false,0);
            return card;
        }else {
            for (int i=0;i<cards;i++) {
                if (x == cardList.get(i).getCardNum()){
                    card =  cardList.get(i);
                    return card;
                }
                else {
                    continue;
                }
            }

        }
        return new Card(0,0,false,0);
    }
    /*Adds money to the account*/
    protected void deposit(int x) {
        balance += x;
    }
    protected int getBalance() {
        return balance;
    }
    protected String getNum() {
        return num;
    }
    protected String getType() {
        return type;
    }
    protected boolean getPayBool() {
        return canPay;
    }
    protected void setType(String newType) {
        type = newType;
    }
    protected void setCanPay(boolean newCanPay){
        canPay = newCanPay;
    }

}
class regAccount extends Account{
    public regAccount(String n,int b, String t, boolean p) {
        num = n;
        balance = b;
        type = t;
        canPay =  p;
    }
}//