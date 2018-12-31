package com.example.lauri.application;

public class Card {
    private int withdrawalLimit;
    private int paymentLimit;
    private boolean area;
    private int cardNum;

    public Card(int newWithdrawal, int newPayment, boolean areaLimitless, int newCardNum){
        withdrawalLimit = newWithdrawal;
        paymentLimit = newPayment;
        area = areaLimitless;
        cardNum = newCardNum;
    }
    public int getWithdrawalLimit() {return withdrawalLimit;}
    public int getPaymentLimit() {return paymentLimit;}
    public boolean getAreaLimitless() {return area;}
    public int getCardNum() {return cardNum;}
    public void setWithdrawalLimit(int newLimit){
        withdrawalLimit = newLimit;
    }
    public void setPaymentLimit(int newLimit) {
        paymentLimit = newLimit;
    }
    public void setAreaLimitless(boolean newAreaLimitless){
        area = newAreaLimitless;
    }
}
