package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
  EditText email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        password=findViewById(R.id.password);
        email=findViewById(R.id.email);
    }

    public void createAccount(View view) {
        startActivity(new Intent(MainActivity.this,SignUpActivity.class));
    }

    public void loginAccount(View view) {
        if(!(email.getText().toString().equals("")&&password.getText().toString().equals(""))){
            startActivity(new Intent(MainActivity.this,WelcomeActivity.class));
        }

    }
}