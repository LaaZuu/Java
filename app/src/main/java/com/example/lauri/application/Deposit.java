package com.example.lauri.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class Deposit extends AppCompatActivity {
    Spinner s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);

        ArrayList<String> spinnerArray = Bank.getInstance().getAllAccounts();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,R.layout.support_simple_spinner_dropdown_item,spinnerArray);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        s1 = (Spinner)findViewById(R.id.spinner8);
        s1.setAdapter(adapter);
    }
    public void deposit(View v){
        EditText dSum = (EditText)findViewById(R.id.editText10);
        Bank.getInstance().deposit(s1.getSelectedItem().toString(),Integer.parseInt(dSum.getText().toString()));

    }
    public void back(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
