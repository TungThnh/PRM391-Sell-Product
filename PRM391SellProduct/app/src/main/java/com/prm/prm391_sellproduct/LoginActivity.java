package com.prm.prm391_sellproduct;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editUsername, editPassword;
    private Button btnLogin;

    private final String REQUIRE = "Require";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Binding();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(editUsername.getText().toString()) || TextUtils.isEmpty(editPassword.getText().toString())){
                    String messageToast = "All inputs required ..";
                    Toast.makeText(LoginActivity.this,messageToast, Toast.LENGTH_SHORT).show();
                }else{
                    LoginRequest loginRequest = new LoginRequest();

                    loginRequest.setUsername(editUsername.getText().toString());
                    loginRequest.setPassword(editPassword.getText().toString());

                    loginUser(loginRequest);
                }
            }
        });
    }

    public void loginUser(LoginRequest loginRequest){
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

    public void  Binding(){
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.btnSignIn);
        btnLogin.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {


    }
}