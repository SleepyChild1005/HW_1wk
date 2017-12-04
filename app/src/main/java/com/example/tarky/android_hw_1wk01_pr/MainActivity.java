package com.example.tarky.android_hw_1wk01_pr;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String before_str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar acB = getSupportActionBar();

        if (acB != null){
            acB.hide();
        }

        before_str = null;

        final EditText password = (EditText)findViewById(R.id.password);
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("TAG", "before char : " + charSequence);
                before_str = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("TAG", "ontext char : " + charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d("TAG", "editable : " + editable.toString());
                if(editable.toString().length() >= 9) {
                    password.setText(before_str);
                    password.setSelection(8);
                }
            }
        });
    }

}