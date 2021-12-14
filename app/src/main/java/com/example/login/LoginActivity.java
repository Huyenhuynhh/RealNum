package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
  EditText emailPhone,password;
  Button createAccount, loginAccount;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      emailPhone = (EditText) findViewById(R.id.emailPhone);
      password=findViewById(R.id.password);

  }

  public void createAccount(View view) {
      startActivity(new Intent(MainActivity.this,SignUpActivity.class));
    }

    public void loginAccount(View view) {
      if(!(emailPhone.getText().toString().equals("")&&password.getText().toString().equals(""))){
          startActivity(new Intent(MainActivity.this,WelcomeActivity.class));
      }

    }
}