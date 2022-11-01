package com.prm.prm391_sellproduct;

import static com.prm.prm391_sellproduct.LoginActivity.getAuthClaimJWT;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import api.LoginResponse;

public class MainActivity extends AppCompatActivity {
LoginResponse loginResponse;
TextView username, authUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.txtView);
        authUser = findViewById(R.id.txtViewAuth);
        String token;
        Intent intent = getIntent();
        if(intent.getExtras() != null){
            loginResponse = (LoginResponse) intent.getSerializableExtra("data");
            token = loginResponse.getId_token();
            username.setText(token);
            authUser.setText(getAuthClaimJWT(token));
            Log.e("TAG", "====>" + loginResponse.getResult());
        }
    }
}