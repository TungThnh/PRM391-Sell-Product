package com.prm.prm391_sellproduct.tung.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.prm.prm391_sellproduct.R;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;

import adapter.ProductAdapter;
import adapter.ProductAdapter1;
import api.ApiClient;
import model.TestProductGet;
import response.Items;
import response.ProductResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminActivity extends AppCompatActivity {

    ProductResponse productResponse;
    private ListView lvProduct;
    private RecyclerView rvProduct;
    ProductAdapter productAdapter;
    ArrayList<ProductResponse> productResponseArrayList;
    private ArrayList<Items> itemsArrayList;
    Button btnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        itemsArrayList = new ArrayList<>();
        rvProduct = findViewById(R.id.listProduct);
        btnView = findViewById(R.id.btnView);
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<TestProductGet> testProduct = ApiClient.getService().getAllProductNew();
                testProduct.enqueue(new Callback<TestProductGet>() {
                    @Override
                    public void onResponse(Call<TestProductGet> call, Response<TestProductGet> response) {
                        Log.e("TAG:Admin",  "onResponse: code : " + response.code());
                        ArrayList<TestProductGet.items> getItem = response.body().getItems();
                        for(TestProductGet.items item : getItem){
                            Log.e("TAG: Toi luc lay roi - -", "onResponse: description" + item.getDescription());
                            itemsArrayList.add(new Items(item.getCode(),item.getName(),item.getRecord_status(), item.getPrice(),item.getQuantity()));
                        }

                        ProductAdapter1 productAdapter1 = new ProductAdapter1(itemsArrayList);
                        rvProduct.setAdapter(productAdapter1);
                        rvProduct.setLayoutManager(new LinearLayoutManager(AdminActivity.this));
                    }

                    @Override
                    public void onFailure(Call<TestProductGet> call, Throwable t) {
                        Log.e("TAG:Admin --- ", "onFailure: "+t.getMessage());
                    }
                });
            }
        });
        //test get
        Intent intent = getIntent();
        if(intent.getExtras() != null){
            productResponse = (ProductResponse) intent.getSerializableExtra("dataProduct");

            Log.e("TAG", "Da vo duoc AdminActivity roi nha ====>");
        }

//        getAllProduct();
    }

    private void setProductAdapter(ProductResponse[] productResponseSet) {
        productResponseArrayList = new ArrayList<>();
        Collections.addAll(productResponseArrayList, productResponseSet);
        lvProduct = findViewById(R.id.listProduct);
        productAdapter = new ProductAdapter(productResponseArrayList, lvProduct.getId(), AdminActivity.this);
        productAdapter.notifyDataSetChanged();
        lvProduct.setAdapter(productAdapter);
    }

    private void getAllProduct(){
        Call<ProductResponse[]> productRespone = ApiClient.getService().getAllProduct();
        productRespone.enqueue(new Callback<ProductResponse[]>() {
            @Override
            public void onResponse(Call<ProductResponse[]> call, Response<ProductResponse[]> response) {
                if(response.isSuccessful()) {
                    ProductResponse[] productResponses = response.body();
                    if (productResponses == null || productResponses.length == 0) {
                        setProductAdapter(productResponses);
                        Toast.makeText(AdminActivity.this,"Không có dữ liệu", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    setProductAdapter(productResponses);
                    Toast.makeText(AdminActivity.this,"Lấy được rồi", Toast.LENGTH_SHORT).show();
                }else{
                    String meassageToast = "An error occurred please try again later";
                    Toast.makeText(AdminActivity.this,meassageToast, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ProductResponse[]> call, Throwable t) {
                String meassageToast = t.getLocalizedMessage();
                Toast.makeText(AdminActivity.this,meassageToast, Toast.LENGTH_SHORT).show();
            }
        });


    }

    //    private Trainee getTraineeFromLayout() {
//        String name = txtTen.getText().toString();
//        String email = txtEmail.getText().toString();
//        String phone = txtSDT.getText().toString();
//        String gender = txtGioiTinh.getText().toString();
//        return new Trainee(name, email, phone, gender);
//    }


}