package com.example.forgetfulcoder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class Compiler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compiler);

        TextView output = (TextView)findViewById(R.id.output);
        EditText codearea = (EditText)findViewById(R.id.codearea);
        String initialText;
        Button run = (Button)findViewById(R.id.run_btn);
        Button resetButton = (Button)findViewById(R.id.reset_btn);
        initialText = codearea.getText().toString();

        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }

        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Python py = Python.getInstance();
                PyObject pyobj = py.getModule("test");
                PyObject obj = pyobj.callAttr("VariablesFirst", codearea.getText().toString());
                output.setText(obj.toString());
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                codearea.setText(initialText);
            }
        });

        TextView nummeration = (TextView)findViewById(R.id.nummeration);

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
                String linesText = "";
                for (int j = 1; j <= lines; j++) {
                    if (j != lines) {
                        linesText = linesText + j + '\n';
                    } else {
                        linesText = linesText + j;
                    }
                }
                nummeration.setText(linesText);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}