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
import com.example.forgetfulcoder.category1.activity_chat_1_2uzd;

public class activity_chat_2_1uzd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat21uzd);

        Button compiler = (Button)findViewById(R.id.goToComp);
        ImageView back = (ImageView)findViewById(R.id.backBtn);
        TextView Text1 = (TextView)findViewById(R.id.message1);
        TextView Text2 = (TextView)findViewById(R.id.message2);
        TextView Text3 = (TextView)findViewById(R.id.message3);
        TextView Text4 = (TextView)findViewById(R.id.message4);
        TextView Text5 = (TextView)findViewById(R.id.message5);
        TextView Text6 = (TextView)findViewById(R.id.message6);
        TextView Text7 = (TextView)findViewById(R.id.message7);

        Text4.setText("The Python programming language has the following comparison operators:\\n\\nEqual to (==)\\n\\nNot equal to (!=)\\n\\ngreater than (>)\\n\\nless than (<)\\n\\nGreater than or equal to (>=)\\n\\nLess than or equal to (<=)");

        ShowAfterDelay(Text2, 2);
        ShowAfterDelay(Text3, 3);
        ShowAfterDelay(Text4, 5);
        ShowAfterDelay(Text5, 6);
        ShowAfterDelay(Text6, 7);
        ShowAfterDelay(Text7, 9);

        ShowAfterDelay(compiler, 11);

        compiler.setOnClickListener(view -> {
            Intent i = new Intent(activity_chat_2_1uzd.this, Compiler.class);
            i.putExtra("description", "Now let\'s try something more complicated.\n\nTry to make program, where you have to insert a comparison operator between x and 5 so that the result value is True. (x = 7)");
            i.putExtra("task", "IfStatementsFirst");
            i.putExtra("comment", "def firstComparison(x):\n    \n   # Remember x value is 7\n    \n     result = (x 5)\n    return result");
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