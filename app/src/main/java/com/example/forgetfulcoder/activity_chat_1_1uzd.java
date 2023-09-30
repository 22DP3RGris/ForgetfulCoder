package com.example.forgetfulcoder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class activity_chat_1_1uzd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat11uzd);
        Button compiler = (Button)findViewById(R.id.goToComp);

        compiler.setOnClickListener(view -> {
            Intent i = new Intent(activity_chat_1_1uzd.this, Compiler.class);
            startActivity(i);
        });
    }
}