package com.prm.prm391_sellproduct.tung.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;


import com.prm.prm391_sellproduct.R;


import java.util.ArrayList;

import adapter.ProductAdapter;
import api.ApiClient;
import response.ProductResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminActivity extends AppCompatActivity {

    ProductResponse productResponse;
    TextView txTestName;
    private RecyclerView rvAdList;
    ArrayList<Long> productId;
    ArrayList<ProductResponse> productResponseArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        txTestName = findViewById(R.id.txtTestViewName);
        rvAdList = findViewById(R.id.rvAdList);

        getAllProduct();

        ProductAdapter productAdapter = new ProductAdapter(productResponseArrayList);
        ArrayAdapter<Long> adapter = new ArrayAdapter<>(AdminActivity.this, R.layout.adminrv_list_view_product, productId);
        rvAdList.setAdapter(productAdapter);
        rvAdList.setLayoutManager(new LinearLayoutManager(AdminActivity.this));


        //test get
        Intent intent = getIntent();
        if(intent.getExtras() != null){
            productResponse = (ProductResponse) intent.getSerializableExtra("dataProduct");

            txTestName.setText(productResponse.getName());
            Log.e("TAG", "Da vo duoc AdminActivity roi nha ====>");
        }
    }

    private void getAllProduct(){
        productId = new ArrayList<>();
        productResponseArrayList = new ArrayList<>();
        Call<ProductResponse[]> productRespone = ApiClient.getService().getAllProduct();
        productRespone.enqueue(new Callback<ProductResponse[]>() {
            @Override
            public void onResponse(Call<ProductResponse[]> call, Response<ProductResponse[]> response) {
                if(response.isSuccessful()) {
                    ProductResponse[] productResponses = response.body();
                    if (productResponses == null) {
                        return;
                    }
                    for (ProductResponse productResponse23 : productResponses) {
                        productResponseArrayList.add(new ProductResponse(productResponse23));
                    }
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


}