package com.prm.prm391_sellproduct;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editUsername;
    private EditText editPassword;
    private TextView notAccountYet;
    private Button btnSignIn;

    private final String REQUIRE = "Require";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Binding();

    }

    public void  Binding(){
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        notAccountYet = findViewById(R.id.notAccountYet);
        btnSignIn = findViewById(R.id.btnSignIn);
        notAccountYet.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {


    }
}