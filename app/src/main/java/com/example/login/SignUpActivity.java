package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    EditText userEmailPhone, password, passwordMatch, userName;

    DBHelper RealNumDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_up);

        userEmailPhone =findViewById(R.id.input_email_phone);
        password = findViewById(R.id.input_password);
        passwordMatch = findViewById(R.id.input_renter_password);
        userName = findViewById(R.id.input_username);

        Button createAccount = ((Button) findViewById(R.id.buttonCreateAccount));
        Button moveToLogin = ((Button) findViewById(R.id.buttonMoveToLogin));

        RealNumDB = new DBHelper(this);

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uEP = userEmailPhone.getText().toString();
                String pw = password.getText().toString();
                String pwM = passwordMatch.getText().toString();
                String uN = userName.getText().toString();

                if(uEP.equals("")||pw.equals("")||pwM.equals("")||uN.equals("")){
                    Toast.makeText(SignUpActivity.this, "Please complete all sections",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    if(pw.equals(pwM)) {
                        Boolean checkUserEmailPhone = RealNumDB.checkUserEmailPhone(uEP);
                        if(!checkUserEmailPhone) {
                            Boolean insert = RealNumDB.insertData(uEP, pw, uN);
                            if(insert) {
                                Toast.makeText(SignUpActivity.this,
                                        "Welcome to RealNum " + uN, Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),
                                        WelcomeActivity.class);
                                startActivity(intent);
                            }
                            else {
                                    Toast.makeText(SignUpActivity.this,
                                            "Unable to create account", Toast.LENGTH_SHORT)
                                            .show();
                            }
                        }
                        else {
                            Toast.makeText(SignUpActivity.this,
                                    "Profile already exists. Please sign in",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(SignUpActivity.this, "Passwords do not match",
                                Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        moveToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}