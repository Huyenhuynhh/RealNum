package com.example.login;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.login.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityWelcomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}