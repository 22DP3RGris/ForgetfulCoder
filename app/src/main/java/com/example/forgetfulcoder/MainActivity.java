package com.example.forgetfulcoder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button learn = (Button)findViewById(R.id.Learn_button);
        Button leaderboard = (Button)findViewById(R.id.Leaderboard_button);
        Button settings = (Button)findViewById(R.id.Settings_button);
        Button about = (Button)findViewById(R.id.About_button);
        learn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, categories.class);
                startActivity(i);
            }
        });
        leaderboard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, leaderboardActivity.class);
                startActivity(i);
            }
        });
        settings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, settingsActivity.class);
                startActivity(i);
            }
        });
        about.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, aboutActivity.class);
                startActivity(i);
            }
        });
    }
}