package com.example.forgetfulcoder.category1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.forgetfulcoder.R;

public class cat_1_level extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat1_level);
        ImageView back = (ImageView)findViewById(R.id.backBtn);
        Button lvl1 = (Button)findViewById(R.id.cat1Level1);

        lvl1.setOnClickListener(view -> {Intent i = new Intent(cat_1_level.this, activity_chat_1_1uzd.class); startActivity(i);});
        
        back.setOnClickListener(view -> finish());

    }
}