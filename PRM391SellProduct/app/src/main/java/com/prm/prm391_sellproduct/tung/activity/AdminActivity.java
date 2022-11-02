package com.prm.prm391_sellproduct.tung.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import com.prm.prm391_sellproduct.R;

import response.AddNewProductResponse;
import response.LoginResponse;

public class AdminActivity extends AppCompatActivity {
    AddNewProductResponse addNewProductResponse;
    String name;
    TextView txTestName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        txTestName = findViewById(R.id.txtTestViewName);

        Intent intent = getIntent();
        if(intent.getExtras() != null){
            addNewProductResponse = (AddNewProductResponse) intent.getSerializableExtra("data");
            String testGetName;
            testGetName = addNewProductResponse.getName();
            txTestName.setText(testGetName);
            Log.e("TAG", "Da vo duoc AdminActivity roi nha ====>");
        }
    }


}