package com.example.forgetfulcoder.category2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.forgetfulcoder.Compiler;
import com.example.forgetfulcoder.R;

public class activity_chat_2_3_uzd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat23_uzd);

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



        Text9.setText("There are some shortcuts for logical operators in math for example 10<x<20 witch is the same as to write 10 < x and x < 20, but dont worry about this now if you don`t understand. We will look at this in another level:)");

        compiler.setOnClickListener(view -> {
            Intent i = new Intent(activity_chat_2_3_uzd.this, Compiler.class);
            i.putExtra("description", "Now let\'s try something more complicated.\n\nTry to make a program that compares the value of (x) with 100 and depending on the comparison the (result) value will be\n(x is bigger than 100) or \n(x is less or equals 100)");
            i.putExtra("task", "IfStatementsSecond");
            i.putExtra("comment", "def firstIfStatement(x):\n    \n    if x ? ?:\n        result = ?\n    else:\n        result = ?\n    \n    return result");
            startActivity(i);
        });
        back.setOnClickListener(view -> finish());
    }

    public void ShowAfterDelay(TextView Obj, int miliseconds) {
        Obj.postDelayed(new Runnable() {
            @Override
            public void run() {
                Obj.setVisibility(View.VISIBLE);
            }
        }, miliseconds * 1000);
    }
}