package com.example.forgetfulcoder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class Compiler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compiler);

        ImageView back = (ImageView)findViewById(R.id.backBtn);
        back.setOnClickListener(view -> finish());


        TextView output = (TextView)findViewById(R.id.userOutput);
        TextView descriptionOut = (TextView)findViewById(R.id.descriptionText);
        EditText codearea = (EditText)findViewById(R.id.codearea);
        String initialText;
        Button run = (Button)findViewById(R.id.run_btn);
        Button resetButton = (Button)findViewById(R.id.reset_btn);

        Intent intent = getIntent();
        String description = intent.getStringExtra("description");
        String task = intent.getStringExtra("task");
        String comment = intent.getStringExtra("comment");

        descriptionOut.setText(description);
        codearea.setText(comment);
        initialText = codearea.getText().toString();



        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }

        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Python py = Python.getInstance();
                PyObject pyobj = py.getModule("test");
                PyObject obj = pyobj.callAttr(task ,codearea.getText().toString());
                output.setText(obj.toString());
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                codearea.setText(initialText);
                output.setText("");
            }
        });

        TextView nummeration = (TextView)findViewById(R.id.numeration);

        codearea.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                int lines = codearea.getLineCount();
                if (lines < 10){
                    lines = 10;
                }
                StringBuilder linesText = new StringBuilder();
                for (int j = 1; j <= lines; j++) {
                    if (j != lines) {
                        linesText.append(j).append('\n');
                    } else {
                        linesText.append(j);
                    }
                }
                nummeration.setText(linesText.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}