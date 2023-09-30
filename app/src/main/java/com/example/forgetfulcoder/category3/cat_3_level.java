package com.example.forgetfulcoder.category3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.forgetfulcoder.R;

public class cat_3_level extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat3_level);
        ImageView back = (ImageView)findViewById(R.id.backBtn);
        back.setOnClickListener(view -> finish());
    }
}