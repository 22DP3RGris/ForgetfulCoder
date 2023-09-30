package com.example.forgetfulcoder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.forgetfulcoder.category1.cat_1_level;
import com.example.forgetfulcoder.category2.cat_2_level;
import com.example.forgetfulcoder.category3.cat_3_level;

public class categories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        ImageView back = (ImageView)findViewById(R.id.backBtn);
        Button category1 = (Button)findViewById(R.id.cat1);
        Button category2 = (Button)findViewById(R.id.cat2);
        Button category3 = (Button)findViewById(R.id.cat3);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        category1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(categories.this, cat_1_level.class);
                startActivity(i);
            }
        });
        category2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(categories.this, cat_2_level.class);
                startActivity(i);
            }
        });
        category3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(categories.this, cat_3_level.class);
                startActivity(i);
            }
        });
    }
}