package com.example.lauri.application;


import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class EntryToJson {
    public EntryToJson(){
        AccountEntry entry;
        Account acc;
        String fileName;
        ArrayList<AccountEntry> entryList;
        ArrayList<String> accList = Bank.getInstance().getAllAccounts();
        for (int i = 0; i<accList.size();i++) {
            acc = Bank.getInstance().findAccount(accList.get(i));
            entryList = acc.getEntryObjects();
            fileName = acc.getNum()+".json";


            Gson gson = new GsonBuilder().create();
            System.out.println(gson.toJson(entryList));


        }

    }
}
