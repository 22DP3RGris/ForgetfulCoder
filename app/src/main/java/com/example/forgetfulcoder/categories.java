package com.example.forgetfulcoder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;


public class categories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        ImageView back = (ImageView)findViewById(R.id.backBtn);

        back.setOnClickListener(view -> finish());
    }
}