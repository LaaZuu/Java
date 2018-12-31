package com.example.lauri.application;

public class AccountEntry {
    String type; // deposit/withdrawal/payment/transfer
    int amount;
    String accountFrom;
    String accountTo = "-1";

    public AccountEntry(String newType, int newAmount, String account){
        type = newType;
        amount = newAmount;
        if (type.equals("deposit")){
            accountTo = account;
        }else if (type.equals("withdrawal")){
            accountFrom = account;
        }else if (type.equals("payment")){
            accountFrom = account;
        }
    }
    public AccountEntry(String newType, int newAmount, String accFrom,String accTo){
        type = newType;
        amount = newAmount;
        accountFrom = accFrom;
        accountTo = accTo;
    }
    /*Parses information from AccountTEntry objects into readable form*/
    public String getInfo() {

        if (accountTo.equals("-1")) {
            String outString = ("Tapahtuma: "+ type + " määrä: " + amount + " Tili: "+ accountFrom);
            return outString;
        } else if (type == "deposit"){
            String outString = ("Tapahtuma: "+ type + " määrä: " + amount + " Tili: "+ accountTo);
            return outString;
        }else{
            String outString = "Tapahtuma: "+ type + " määrä: " + amount + " Lähtötili: "+accountFrom+" Vastaanottaja: "+accountTo ;
            return outString;
        }
    }
}
