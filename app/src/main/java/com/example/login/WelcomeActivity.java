package com.example.login;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        final Button trackingButton = (Button) findViewById(R.id.button_tracking);

        trackingButton.setOnClickListener(v -> Navigation.findNavController(WelcomeActivity.this,R.id.nav_controller_view_tag)
                .navigate(R.id.action_welcomeActivity_to_trackingActivity));

    }
}