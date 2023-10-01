package com.example.forgetfulcoder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.provider.ContactsContract;
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

import org.w3c.dom.Text;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    public class User {

        public String email;
        public String password;

        public User(String Email,String Password) {
            this.email = Email;
            this.password = Password;
        }
    }

    public static Boolean ValidateEmail(String email) {
        String PatternRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(PatternRegex);
        if (email == null) {
            return false;
        }

        Boolean matches = pat.matcher(email).matches();
        return matches;
    }

    public static Boolean ValidatePassword(String password) {
        String PatternRegex = "[\\s+]";
        Pattern pat = Pattern.compile(PatternRegex);
        if (password == null || password == "") {
            return false;
        }

        Boolean matches = pat.matcher(password).matches();
        return matches;
    }

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
        setContentView(R.layout.activity_register);

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://forgetful-coder-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference Ref = database.getReference("/UserData");

        ImageView back = (ImageView)findViewById(R.id.backBtn);
        TextView registerbutton = (Button)findViewById(R.id.registerBtn);

        registerbutton.setOnClickListener(view -> {
            EditText Username = (EditText)findViewById(R.id.usernameReg);
            EditText Email = (EditText)findViewById(R.id.emailReg);
            EditText Password = (EditText)findViewById(R.id.passwordReg);
            EditText ConPassword = (EditText)findViewById(R.id.passwordConReg);

            String username = Username.getText().toString();
            String email = Email.getText().toString();
            String password = Password.getText().toString();
            String confirmpass = ConPassword.getText().toString();

            Boolean EmailValid = ValidateEmail(email);
            Boolean PasswordValid = ValidatePassword(password);

            if (EmailValid && username != null && PasswordValid && confirmpass.equals(password)) {

                Ref.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (!task.isSuccessful()) {
                            Log.e("firebase", "Error getting data", task.getException());
                        } else {

                            Object value = task.getResult().child(username).getValue();

                            if (value == null) {
                                for (DataSnapshot dsp : task.getResult().getChildren()) {
                                    Map<String, Object> datas = (Map<String, Object>) dsp.getValue();
                                    if (email.equals(datas.get("email"))) {
                                        Notify("This email is already in use");
                                        return;
                                    }
                                }

                                User user = new User(email, password);

                                Ref.child(username).setValue(user);

                                Intent i = new Intent(Register.this, Login.class);
                                startActivity(i);
                            } else {
                                Notify("This username is already in use");
                            }
                        }
                    }
                });
            } else if (!EmailValid) {
                Notify("Invalid email");
                return;
            } else if (username == null) {
                Notify("Invalid username");
                return;
            } else if (!PasswordValid) {
                Notify("Invalid password");
                return;
            } else if (!confirmpass.equals(password)) {
                Notify("Passwords do not match");
                return;
            }
        });

        back.setOnClickListener(view -> finish());
    }
}