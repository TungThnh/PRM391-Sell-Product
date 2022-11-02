package com.prm.prm391_sellproduct.tung.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.prm.prm391_sellproduct.R;

import api.ApiClient;
import request.AddProductRequest;
import response.AddNewProductResponse;
import response.LoginResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddProductActivity extends AppCompatActivity {

    TextInputEditText inputName, inputCode,
            inputDes, inputUnit, inputPrice, inputQuantity;
    Button btnThem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        binding();

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(inputName.getText().toString()) || TextUtils.isEmpty(inputCode.getText().toString())
                        || TextUtils.isEmpty(inputDes.getText().toString()) || TextUtils.isEmpty(inputPrice.getText().toString())
                        || TextUtils.isEmpty(inputUnit.getText().toString()) || TextUtils.isEmpty(inputQuantity.getText().toString())){
                    String messageToast = "All inputs required ..";
                    Toast.makeText(AddProductActivity.this,messageToast, Toast.LENGTH_LONG).show();
                }else{
                    AddProductRequest addProductRequest = new AddProductRequest();

                    addProductRequest.setName(inputName.getText().toString());
                    addProductRequest.setCode(inputCode.getText().toString());
                    addProductRequest.setDescription(inputDes.getText().toString());
                    addProductRequest.setPrice(Float.parseFloat(inputPrice.getText().toString()));
                    addProductRequest.setUnit(inputUnit.getText().toString());
                    addProductRequest.setQuantity(Float.parseFloat(inputQuantity.getText().toString()));

                    addNewProduct(addProductRequest);
                }
            }
        });
    }

    private void addNewProduct(AddProductRequest addProductRequest){
        Call<AddNewProductResponse> newProductResponseCall = ApiClient.getService().addProduct(addProductRequest);
        newProductResponseCall.enqueue(new Callback<AddNewProductResponse>() {
            @Override
            public void onResponse(Call<AddNewProductResponse> call, Response<AddNewProductResponse> response) {
                if(response.isSuccessful()){
                    AddNewProductResponse newProductResponse= response.body();
                    startActivity(new Intent(AddProductActivity.this, AdminActivity.class).putExtra("data", newProductResponse));
                    finish();

                }else{
                    String meassageToast = "An error occurred please try again later";
                    Toast.makeText(AddProductActivity.this,meassageToast, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AddNewProductResponse> call, Throwable t) {
                String meassageToast = t.getLocalizedMessage();
                Toast.makeText(AddProductActivity.this,meassageToast, Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void binding() {
        inputName = findViewById(R.id.txtAddName);
        inputCode = findViewById(R.id.txtAddCode);
        inputDes = findViewById(R.id.txtAddDescription);
        inputPrice = findViewById(R.id.txtAddPrice);
        inputUnit = findViewById(R.id.txtAddUnit);
        inputQuantity = findViewById(R.id.txtAddQuantity);
        btnThem = findViewById(R.id.btnThem);
    }
}