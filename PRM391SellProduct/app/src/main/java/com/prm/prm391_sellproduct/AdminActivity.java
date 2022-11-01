package com.prm.prm391_sellproduct;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


import api.ApiClient;
import api.LoginResponse;
import api.UserService;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class AdminActivity extends AppCompatActivity {
    LoginResponse loginResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Intent intent = getIntent();
        if(intent.getExtras() != null){
            loginResponse = (LoginResponse) intent.getSerializableExtra("data");

            Log.e("TAG", "Da vo duoc AdminActivity roi nha ====>" + loginResponse.getResult());
        }
    }


}