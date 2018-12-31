package com.example.lauri.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public User user = User.getInstance();
    public Bank bank = Bank.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EntryToJson json = new EntryToJson();


    }
    public void openAddAcc(View v) {
        Intent intent = new Intent(this, addAcc.class);
        startActivity(intent);
    }
    public void openEditAcc(View v) {
        Intent intent = new Intent(this, editAcc.class);
        startActivity(intent);
    }
    public void openInfo(View v) {
        Intent intent = new Intent(this, Info.class);
        startActivity(intent);
    }
    public void openAddCard(View v){
        Intent intent = new Intent(this, CardActivity.class);
        startActivity(intent);
    }
    public void openEditCard(View v){
        Intent intent = new Intent(this, EditCard.class);
        startActivity(intent);
    }
    public void openTransactions(View v){
        Intent intent = new Intent(this, Transactions.class);
        startActivity(intent);
    }
    public void openDeposit(View v){
        Intent intent = new Intent(this, Deposit.class);
        startActivity(intent);
    }
    public void openEntries(View v){
        Intent intent = new Intent(this, Entries.class);
        startActivity(intent);
    }
}
