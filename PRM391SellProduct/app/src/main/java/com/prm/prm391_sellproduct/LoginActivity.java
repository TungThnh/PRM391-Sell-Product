package com.prm.prm391_sellproduct;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.HttpURLConnection;

import api.ApiClient;
import api.LoginRequest;
import api.LoginResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtUsername, edtPassword;
    private Button btnSignIn;

    private final String REQUIRE = "Require";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        edtUsername = findViewById(R.id.editUsername);
        edtPassword = findViewById(R.id.editPassword);
        btnSignIn = findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(edtUsername.getText().toString()) || TextUtils.isEmpty(edtPassword.getText().toString())){
                    String messageToast = "All inputs required ..";
                    Toast.makeText(LoginActivity.this,messageToast, Toast.LENGTH_LONG).show();
                }else{
                    LoginRequest loginRequest = new LoginRequest();

                    loginRequest.setUsername(edtUsername.getText().toString());
                    loginRequest.setPassword(edtPassword.getText().toString());
                    loginAccount(loginRequest);
                }
            }
        });
    }

    public void loginAccount(LoginRequest loginRequest){
        Call<LoginResponse> loginResponseCall = ApiClient.getService().loginUser(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    LoginResponse loginResponse = response.body();
                    startActivity(new Intent(LoginActivity.this,MainActivity.class).putExtra("data", loginResponse));
                    finish();

                }else{
                    String meassageToast = "An error occurred please try again later";
                    Toast.makeText(LoginActivity.this,meassageToast, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                String meassageToast = t.getLocalizedMessage();
                Toast.makeText(LoginActivity.this,meassageToast, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onClick(View view) {

    }
}