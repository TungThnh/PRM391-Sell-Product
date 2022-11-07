package com.prm.prm391_sellproduct.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.prm.prm391_sellproduct.R;

import response.LoginResponse;

public class UserActivity extends AppCompatActivity {
    LoginResponse loginResponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


        Intent intent = getIntent();
        if(intent.getExtras() != null){
            loginResponse = (LoginResponse) intent.getSerializableExtra("data");

            Log.e("TAG", "Da vo duoc UserActivity roi nha ====>" + loginResponse.getResult());
        }
    }
}