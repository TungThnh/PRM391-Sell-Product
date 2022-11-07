package com.prm.prm391_sellproduct.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.prm.prm391_sellproduct.R;
import com.prm.prm391_sellproduct.activity.LoginActivity;

import api.ApiClient;
import request.RegisterRequest;
import response.RegisterResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    Button btnSignup;
    EditText edUsername, edEmail,edPassword,edCpassword,edFullName;
    private TextView aHaveAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnSignup = findViewById(R.id.btnLogin);
        aHaveAccount = findViewById(R.id.ahaSign_in);
        edFullName = findViewById(R.id.editFullname);
        edUsername = findViewById(R.id.editUsername);
        edEmail = findViewById(R.id.editEmail);
        edPassword = findViewById(R.id.editPassword);
        edCpassword = findViewById(R.id.editcPassword);

        aHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(edFullName.getText().toString()) || TextUtils.isEmpty(edEmail.getText().toString())||TextUtils.isEmpty(edUsername.getText().toString())||TextUtils.isEmpty(edPassword.getText().toString())||TextUtils.isEmpty(edCpassword.getText().toString()) ){
                    String message = "All inputs required...";
                    Toast.makeText(RegisterActivity.this, message,Toast.LENGTH_LONG).show();
                }else {
                    RegisterRequest registerRequest = new RegisterRequest();
                    registerRequest.setUsername(edUsername.getText().toString());
                    registerRequest.setEmail(edEmail.getText().toString());
                    registerRequest.setPassword(edPassword.getText().toString());
                    registerRequest.setFull_name(edFullName.getText().toString());
                    registerUser(registerRequest);
                }

            }
        });



    }
    public void registerUser(RegisterRequest registerRequest  ){
        Call<RegisterResponse> registerResponseCall = ApiClient.getService().registerUser(registerRequest);
        registerResponseCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if(response.isSuccessful()){
                    String message = "Successful";
                    Toast.makeText(RegisterActivity.this, message,Toast.LENGTH_LONG).show();

                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    finish();

                }else {
                    String message = "An error occurred please try again later";
                    Toast.makeText(RegisterActivity.this, message,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(RegisterActivity.this, message,Toast.LENGTH_LONG).show();

            }
        });
    }
}