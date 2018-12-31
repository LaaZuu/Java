package com.example.lauri.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Info extends AppCompatActivity {
    EditText nameField;
    EditText addressField;
    EditText phoneField;
    String name;
    String address;
    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        nameField = (EditText)findViewById(R.id.editText3);
        addressField = (EditText)findViewById(R.id.editText4);
        phoneField = (EditText)findViewById(R.id.editText5);
        name = User.getInstance().getName();
        address = User.getInstance().getAddress();
        phone = User.getInstance().getPhone();
        nameField.setText(name);
        addressField.setText(address);
        phoneField.setText(phone);
    }
    public void saveEdit(View v){
        User.getInstance().edit(nameField.getText().toString(),addressField.getText().toString(),phoneField.getText().toString());
    }
    public void back(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
