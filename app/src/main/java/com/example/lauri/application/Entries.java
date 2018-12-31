package com.example.lauri.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class Entries extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {
    Spinner s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entries);

        ArrayList<String> spinnerArray = Bank.getInstance().getAllAccounts();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,R.layout.support_simple_spinner_dropdown_item,spinnerArray);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        s1 = (Spinner)findViewById(R.id.spinner9);
        s1.setAdapter(adapter);
        s1.setOnItemSelectedListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> a, View v, int i, long l){
        String sp1 = String.valueOf(s1.getSelectedItem());
        Account acc = Bank.getInstance().findAccount(sp1);
        ListView entryView = (ListView)findViewById(R.id.listview);
        ArrayList<String> viewArray = acc.getAllEntries();
        ArrayAdapter<String> arrayAdapter =  new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, viewArray);
        entryView.setAdapter(arrayAdapter);


    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }
}
