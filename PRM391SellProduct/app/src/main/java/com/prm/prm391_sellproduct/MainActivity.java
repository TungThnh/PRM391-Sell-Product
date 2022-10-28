package com.prm.prm391_sellproduct;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import api.LoginResponse;

public class MainActivity extends AppCompatActivity {
LoginResponse loginResponse;
TextView username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.txtView);
        Intent intent = getIntent();
        if(intent.getExtras() != null){
            loginResponse = (LoginResponse) intent.getSerializableExtra("data");
            username.setText(loginResponse.getId_token());
            Log.e("TAG", "====>" + loginResponse.getResult());
        }
    }
}