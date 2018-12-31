package com.example.lauri.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class EditCard extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner s1,s2;
    EditText withdrawalLimit;
    EditText paymentLimit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_card);
        ArrayList<String> spinnerArray = Bank.getInstance().getAllAccounts();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,R.layout.support_simple_spinner_dropdown_item,spinnerArray);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        s1 = (Spinner)findViewById(R.id.spinner2);
        s2 = (Spinner)findViewById(R.id.spinner3);
        s1.setAdapter(adapter);
        s1.setOnItemSelectedListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> a, View v, int i, long l){
        String sp1 = String.valueOf(s1.getSelectedItem());
        Account acc = Bank.getInstance().findAccount(sp1);
        ArrayList<Integer> spinnerArray = acc.getAllCards();
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(
                this,R.layout.support_simple_spinner_dropdown_item,spinnerArray);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        s2.setAdapter(adapter);
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }

    public void editCard(View v) {
         withdrawalLimit= (EditText)findViewById(R.id.editText8);
         paymentLimit= (EditText)findViewById(R.id.editText8);

        Account acc = Bank.getInstance().findAccount(String.valueOf(s1.getSelectedItem()));
        Card card = acc.findCard(Integer.parseInt(String.valueOf(s2.getSelectedItem())));
        card.setPaymentLimit(Integer.parseInt(paymentLimit.getText().toString()));
        card.setWithdrawalLimit(Integer.parseInt(withdrawalLimit.getText().toString()));
    }

    public void back(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
