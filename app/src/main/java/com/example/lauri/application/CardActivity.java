package com.example.lauri.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class CardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        ArrayList<String> spinnerArray = Bank.getInstance().getAllAccounts();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,R.layout.support_simple_spinner_dropdown_item,spinnerArray);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        Spinner sItems = (Spinner)findViewById(R.id.spinner);
        sItems.setAdapter(adapter);
    }
    /*Adds a card to the account that is selected from the dropdown list*/
    public void addCard(View v){
        Spinner s = (Spinner)findViewById(R.id.spinner);
        EditText withdrawalLimit = (EditText)findViewById(R.id.editText6);
        EditText paymentLimit = (EditText)findViewById(R.id.editText7);
        CheckBox areaLimitless = (CheckBox)findViewById(R.id.checkBox2);
        Account a = Bank.getInstance().findAccount(s.getSelectedItem().toString());
        a.addCard(Integer.parseInt(withdrawalLimit.getText().toString()),Integer.parseInt(paymentLimit.getText().toString()), areaLimitless.isChecked());
    }
    //Back to main menu
    public void back(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
