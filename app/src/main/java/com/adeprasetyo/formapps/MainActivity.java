package com.adeprasetyo.formapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    final public static String EXTRA_NAME = "extra_name";
    final public static String EXTRA_EMAIL = "extra_email";
    final public static String EXTRA_PHONE = "extra_phone";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputName = (EditText)  findViewById(R.id.idInputName);
        EditText inputEmail = (EditText)  findViewById(R.id.idInputEmail);
        EditText inputPhone = (EditText)  findViewById(R.id.idInputPhone);
        EditText inputPassword = (EditText)  findViewById(R.id.idInputPwd);

        Button btnSave = (Button) findViewById(R.id.idButtonSave);
        btnSave.setOnClickListener(v ->{
            Intent LoginIntent = new Intent(MainActivity.this, DashboardActivity.class);
            LoginIntent.putExtra(EXTRA_NAME, inputName.getText().toString());
            LoginIntent.putExtra(EXTRA_EMAIL, inputEmail.getText().toString());
            LoginIntent.putExtra(EXTRA_PHONE, inputPhone.getText().toString());
            startActivity(LoginIntent);
        });

    }
}