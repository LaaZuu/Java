package com.example.lauri.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class addAcc extends AppCompatActivity {

    EditText num;
    EditText balance;
    CheckBox payBool;
    RadioGroup typeGroup;
    String accType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_acc);
    }
    public void back(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void addAccount(View v){
        num = (EditText)findViewById(R.id.editText);
        String accNum = num.getText().toString();
        balance = (EditText)findViewById(R.id.editText2);
        int accBalance = Integer.parseInt(balance.getText().toString());
        payBool = (CheckBox)findViewById(R.id.checkBox);
        boolean accPayBool;
        if (payBool.isChecked()) {
             accPayBool = true;
        }else{
            accPayBool = false;
        }
        typeGroup = (RadioGroup)findViewById(R.id.radioGroup);
        switch (typeGroup.getCheckedRadioButtonId()){
            case R.id.radioButton6:
                accType = "Käyttö";
                break;
            case R.id.radioButton7:
                accType = "Säästö";
                break;
        }


        Bank.getInstance().addAccount(accNum,accBalance,accType,accPayBool);

    }
}
