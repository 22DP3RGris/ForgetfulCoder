package com.example.forgetfulcoder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.forgetfulcoder.category1.category1Activity;
import com.example.forgetfulcoder.category2.category2Activity;
import com.example.forgetfulcoder.category3.category3Activity;

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
                Intent i = new Intent(categories.this, category1Activity.class);
                startActivity(i);
            }
        });
        category2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(categories.this, category2Activity.class);
                startActivity(i);
            }
        });
        category3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(categories.this, category3Activity.class);
                startActivity(i);
            }
        });
    }
}