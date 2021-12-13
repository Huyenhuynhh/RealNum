package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    EditText userEmailPhone;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        password=findViewById(R.id.input_password);
        userEmailPhone =findViewById(R.id.input_email_phone);
    }

    public void createAccount(View view) {
        if(!(userEmailPhone.getText().toString().equals("")&&password.getText().toString().equals(""))){
            startActivity(new Intent(SignUpActivity.this,WelcomeActivity.class));
        }
    }

    public void moveToLoginScreen(View view) {
        startActivity(new Intent(SignUpActivity.this,MainActivity.class));
    }
}