package com.example.lauri.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Transactions extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner s1,s2,s3;
    Button b1,b2,b3;
    EditText ammountWithPay, recipient, transferAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);

        ArrayList<String> spinnerArray = Bank.getInstance().getAllAccounts();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,R.layout.support_simple_spinner_dropdown_item,spinnerArray);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
         s1 = (Spinner)findViewById(R.id.spinner5);
         s2 = (Spinner)findViewById(R.id.spinner6);
         s3 = (Spinner)findViewById(R.id.spinner7);
        s1.setAdapter(adapter);
        s2.setAdapter(adapter);
        s2.setOnItemSelectedListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> a, View v, int i, long l){
        String sp1 = String.valueOf(s2.getSelectedItem());
        Account acc = Bank.getInstance().findAccount(sp1);
        ArrayList<Integer> spinnerArray = acc.getAllCards();
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(
                this,R.layout.support_simple_spinner_dropdown_item,spinnerArray);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        s3.setAdapter(adapter);
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }

    public void withdrawal(View v){
        ammountWithPay = (EditText)findViewById(R.id.editText13);
        int withdrawAmmount = Integer.parseInt(ammountWithPay.getText().toString());
        int toastCheck = Bank.getInstance().withdrawal(s2.getSelectedItem().toString(),Integer.parseInt(s3.getSelectedItem().toString()), withdrawAmmount);
        if (toastCheck == 1){
            Toast.makeText(this,"Nosto onnistui", Toast.LENGTH_LONG).show();
        }else if (toastCheck == 3){
            Toast.makeText(this,"Noston suuruus ylitti tilin saldon. Nosto epäonnistui.", Toast.LENGTH_LONG).show();
        }else if (toastCheck == 2){
            Toast.makeText(this,"Noston suuruus ylitti kortin nostorajan. Nosto epäonnistui.", Toast.LENGTH_LONG).show();
        }
    }
    public void payment(View v){
        ammountWithPay = (EditText)findViewById(R.id.editText13);
        int withdrawAmmount = Integer.parseInt(ammountWithPay.getText().toString());
        int toastCheck = Bank.getInstance().payment(s2.getSelectedItem().toString(),Integer.parseInt(s3.getSelectedItem().toString()), withdrawAmmount);
        if (toastCheck == 1){
            Toast.makeText(this,"Maksu onnistui", Toast.LENGTH_LONG).show();
        }else if (toastCheck == 3){
            Toast.makeText(this,"Maksun suuruus ylitti tilin saldon. Maksu epäonnistui.", Toast.LENGTH_LONG).show();
        }else if (toastCheck == 2){
            Toast.makeText(this,"Maksun suuruus ylitti kortin maksurajan. Maksu epäonnistui.", Toast.LENGTH_LONG).show();
        }else if(toastCheck == 4){
            Toast.makeText(this,"Tililtä ei voi suorittaa maksua.", Toast.LENGTH_LONG).show();
        }
    }
    public void transfer(View v) {
        recipient = (EditText)findViewById(R.id.editText11);
        transferAmount = (EditText)findViewById(R.id.editText12);
        int toastCheck = Bank.getInstance().transfer(s1.getSelectedItem().toString(),recipient.getText().toString(),Integer.parseInt(transferAmount.getText().toString()));
        if (toastCheck == 1){
            Toast.makeText(this,"Siirto onnistui", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"Siirto epäonnistui.", Toast.LENGTH_LONG).show();
        }
    }
}
