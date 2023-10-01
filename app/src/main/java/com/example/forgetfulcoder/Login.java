package com.example.forgetfulcoder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

public class Login extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    public void Notify(String reason) {
        TextView ErrorMessage = (TextView) findViewById(R.id.errornotify);

        ErrorMessage.setText(reason);
        ErrorMessage.setVisibility(View.VISIBLE);
        ErrorMessage.postDelayed(new Runnable() {
            @Override
            public void run() {
                ErrorMessage.setVisibility(View.GONE);

            }
        }, 2 * 1000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://forgetful-coder-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference Ref = database.getReference("/UserData");

        Button LoginButton = (Button)findViewById(R.id.loginButton);
        Button toRegister = (Button)findViewById(R.id.toRegister);
        EditText Username = (EditText)findViewById(R.id.usernameLog);
        EditText Password = (EditText)findViewById(R.id.passwordLog);
        sharedPreferences = getSharedPreferences("ForgetfulCoder", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();


        if (sharedPreferences.getString("logged", "false").equals("true")) {
            Intent i = new Intent(Login.this, MainActivity.class);
            startActivity(i);
        }

        LoginButton.setOnClickListener(view -> {
            String username = Username.getText().toString();
            String password = Password.getText().toString();

            if (username != null && password != null) {
                Ref.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (!task.isSuccessful()) {
                            Log.e("firebase", "Error getting data", task.getException());
                        } else {
                            Object value = task.getResult().child(username).getValue();

                            if (value != null) {
                                Map<String, Object> datas = (Map<String, Object>) value;
                                if (password.equals(datas.get("password"))) {
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putString("logged", "true");
                                    editor.putString("name", username);
                                    editor.putString("email", datas.get("email").toString());
                                    editor.apply();

                                    Intent i = new Intent(Login.this, MainActivity.class);
                                    startActivity(i);
                                }
                            }
                        }
                    }
                });
            } else if (username == null) {
                Notify("Invalid username");
            } else if (password == null) {
                Notify("Invalid password");
            }
        });

        toRegister.setOnClickListener(view -> {
            Intent i = new Intent(Login.this, Register.class);
            startActivity(i);
        });
    }
}