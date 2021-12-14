package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
  EditText emailPhone,password;
  DBHelper RealNumDB;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_login);

      emailPhone = (EditText) findViewById(R.id.emailPhone);
      password = (EditText) findViewById(R.id.password);

      Button createAccount = (Button)  findViewById(R.id.buttonCreateAccount);
      Button loginAccount = (Button) findViewById(R.id.buttonLogin);

      RealNumDB = new DBHelper(this);

      createAccount.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
              startActivity(intent);
          }
      });

      loginAccount.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String loginUser = emailPhone.getText().toString();
              String loginPassword = password.getText().toString();

              if(loginUser.equals("")||loginPassword.equals("")) {
                  Toast toast = Toast.makeText(LoginActivity.this,
                          "Email/Phone and password may not be blank",
                          Toast.LENGTH_SHORT);
                  toast.setGravity(Gravity.CENTER,0,0);
                  toast.show();
              }
              else {
                  Boolean checkPassword = RealNumDB.checkPassword(loginUser, loginPassword);
                  if(checkPassword) {
                      Toast toast = Toast.makeText(LoginActivity.this, "Welcome back",
                              Toast.LENGTH_SHORT);
                      toast.setGravity(Gravity.CENTER, 0,0);
                      toast.show();
                      Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
                      startActivity(intent);
                  }
                  else {
                      Toast.makeText( LoginActivity.this, "Username or Password is incorrect",
                              Toast.LENGTH_SHORT).show();
                  }
              }
          }
      });
  }
}