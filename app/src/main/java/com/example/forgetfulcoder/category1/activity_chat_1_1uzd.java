package com.example.forgetfulcoder.category1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.forgetfulcoder.Compiler;
import com.example.forgetfulcoder.R;

public class activity_chat_1_1uzd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat11uzd);
        Button compiler = (Button)findViewById(R.id.goToComp);
        ImageView back = (ImageView)findViewById(R.id.backBtn);
        TextView Text1 = (TextView)findViewById(R.id.message1);
        TextView Text2 = (TextView)findViewById(R.id.message2);
        TextView Text3 = (TextView)findViewById(R.id.message3);
        TextView Text4 = (TextView)findViewById(R.id.message4);
        TextView Text5 = (TextView)findViewById(R.id.message5);
        TextView Text6 = (TextView)findViewById(R.id.message6);
        TextView Text7 = (TextView)findViewById(R.id.message7);
        TextView Text8 = (TextView)findViewById(R.id.message8);
        TextView Text9 = (TextView)findViewById(R.id.message9);
        TextView Text10 = (TextView)findViewById(R.id.message10);
        TextView Text11 = (TextView)findViewById(R.id.message11);

        Text2.setVisibility(View.VISIBLE);
        Text3.setVisibility(View.VISIBLE);
        Text4.setVisibility(View.VISIBLE);
        Text5.setVisibility(View.VISIBLE);
        Text6.setVisibility(View.VISIBLE);
        Text7.setVisibility(View.VISIBLE);
        Text8.setVisibility(View.VISIBLE);
        Text9.setVisibility(View.VISIBLE);
        Text10.setVisibility(View.VISIBLE);
        Text11.setVisibility(View.VISIBLE);
        compiler.setVisibility(View.VISIBLE);

        compiler.setOnClickListener(view -> {
            Intent i = new Intent(activity_chat_1_1uzd.this, Compiler.class);
            i.putExtra("description", "The first thing any programmer\nshould create program that outputs \"Hello World!\".\n\nTry to make this program.");
            i.putExtra("task", "ProgrammingBasicsFirst");
            startActivity(i);
        });
        back.setOnClickListener(view -> finish());
    }
}