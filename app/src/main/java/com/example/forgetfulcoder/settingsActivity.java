package com.example.forgetfulcoder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class settingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ImageView back = (ImageView)findViewById(R.id.backBtn);
        back.setOnClickListener(view -> finish());

        Button login = (Button)findViewById(R.id.loginBtn);
        login.setOnClickListener(view -> {
            Intent intent = new Intent(settingsActivity.this, Login.class);
            startActivity(intent);
        });

        Button register = (Button)findViewById(R.id.registerBtn);
        register.setOnClickListener(view -> {
            Intent intent = new Intent(settingsActivity.this, Register.class);
            startActivity(intent);
        });

    }
}