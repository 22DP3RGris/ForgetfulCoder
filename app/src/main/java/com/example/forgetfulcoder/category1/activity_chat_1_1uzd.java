package com.example.forgetfulcoder.category1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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

        ShowAfterDelay(Text2, 2);
        ShowAfterDelay(Text3, 3);
        ShowAfterDelay(Text4, 5);
        ShowAfterDelay(Text5, 6);
        ShowAfterDelay(Text6, 7);
        ShowAfterDelay(Text7, 9);
        ShowAfterDelay(Text8, 11);
        ShowAfterDelay(Text9, 13);
        ShowAfterDelay(Text10, 15);
        ShowAfterDelay(Text11, 17);
        ShowAfterDelay(compiler, 18);

        compiler.setOnClickListener(view -> {
            Intent i = new Intent(activity_chat_1_1uzd.this, Compiler.class);
            i.putExtra("description", "The first thing any programmer\nshould create program that outputs \"Hello World!\".\n\nTry to make this program.");
            i.putExtra("task", "ProgrammingBasicsFirst");
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