package com.prm.prm391_sellproduct.tung.activity;

import static com.prm.prm391_sellproduct.tung.activity.LoginActivity.getAuthClaimJWT;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.prm.prm391_sellproduct.R;

import response.LoginResponse;

public class MainActivity extends AppCompatActivity {
LoginResponse loginResponse;
TextView username, authUser;
String getPara = "auth";
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
            authUser.setText(getAuthClaimJWT(token,getPara));
            Log.e("TAG", "====>" + loginResponse.getResult());
        }
    }
}