package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    EditText email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        password=findViewById(R.id.tpassword);
        email=findViewById(R.id.temail);
    }

    public void createAccount(View view) {
        if(!(email.getText().toString().equals("")&&password.getText().toString().equals(""))){
            startActivity(new Intent(SignUpActivity.this,WelcomeActivity.class));
        }
    }

    public void moveToLoginScreen(View view) {
        startActivity(new Intent(SignUpActivity.this,MainActivity.class));
    }
}