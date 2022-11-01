package com.prm.prm391_sellproduct.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.prm.prm391_sellproduct.R;

public class DetailActivity extends AppCompatActivity {
    TextView productName, price , decribe;
    Button btnAdd;
    ImageView imgProduct;
    Spinner spinner;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_details);
        initView();
    }

    private void initView(){
        productName = findViewById(R.id.txtProductName);
        price = findViewById(R.id.txtPrice);
        decribe = findViewById(R.id.txtDecribe);
        btnAdd = findViewById(R.id.btnAddtocart);
        spinner = findViewById(R.id.spinner);
        imgProduct = findViewById(R.id.imgDetails);
        toolbar = findViewById(R.id.toolbar);
    }
}
