package com.example.forgetfulcoder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class activity_chat_1_1uzd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat11uzd);
        Button compiler = (Button)findViewById(R.id.goToComp);
        ImageView back = (ImageView)findViewById(R.id.backBtn);


        compiler.setOnClickListener(view -> {
            Intent i = new Intent(activity_chat_1_1uzd.this, Compiler.class);
            i.putExtra("description", "The first thing any programmer\nshould do is type\"Hello World!\".\n\nTry to make this program.");
            i.putExtra("task", "ProgrammingBasicsFirst");
            startActivity(i);
        });
        back.setOnClickListener(view -> finish());
    }
}