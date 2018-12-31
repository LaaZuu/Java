package com.example.lauri.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;

public class editAcc extends AppCompatActivity {
    Spinner s1;
    CheckBox canPayBool;
    RadioGroup typeGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_acc_test);

        ArrayList<String> spinnerArray = Bank.getInstance().getAllAccounts();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,R.layout.support_simple_spinner_dropdown_item,spinnerArray);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        s1 = (Spinner)findViewById(R.id.spinner4);
        s1.setAdapter(adapter);


    }
    /*Takes information from gui and edits account information accordingly*/
    public void editAcc(View v){
        Account acc = Bank.getInstance().findAccount(String.valueOf(s1.getSelectedItem()));
        canPayBool = (CheckBox)findViewById(R.id.checkBox3);
        System.out.println(acc.getPayBool());
        if (canPayBool.isChecked()){
            acc.setCanPay(true);
        }else {
            acc.setCanPay(false);
        }
        System.out.println(acc.getPayBool());
        typeGroup = (RadioGroup)findViewById(R.id.radioGroup2);
        System.out.println(acc.getType());
        switch (typeGroup.getCheckedRadioButtonId()){
            case R.id.radioButton3:
                acc.setType("Käyttö");
                break;
            case R.id.radioButton4:
                acc.setType("Säästö");
                break;
        }
        System.out.println(acc.getType());

    }
    public void back(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
