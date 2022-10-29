package com.prm.prm391_sellproduct;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;
import com.prm.prm391_sellproduct.adapter.ProductTypeAdapter;
import com.prm.prm391_sellproduct.model.ModelProductType;
import com.prm.prm391_sellproduct.model.ProductType;
import com.prm.prm391_sellproduct.retrofit.APISell;
import com.prm.prm391_sellproduct.retrofit.RetrofitClient;
import com.prm.prm391_sellproduct.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerView;
    NavigationView navigationView;
    ListView listViewHome;
    ProductTypeAdapter productTypeAdapter;
    List<ProductType> listProductType;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    APISell apiSell;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiSell = RetrofitClient.getInstance(Utils.BASE_URL).create(APISell.class);
        AnhXa();
        if (isConnected(this)){
            Toast.makeText(getApplicationContext(),"Have Internet", Toast.LENGTH_LONG).show();
            getProductType();
        }else {
            Toast.makeText(getApplicationContext(),"No Internet", Toast.LENGTH_LONG).show();
        }
    }

    private void getProductType() {
        compositeDisposable.add(apiSell.getProductType()
                .subcribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subcribe(
                        modelProductType -> {
                            if (modelProductType.isSuccess()){
                                Toast.makeText(getApplicationContext(), modelProductType.getResult().get(0).getProductName(), Toast.LENGTH_LONG).show();
                            }
                        }
                ));

    }

    private void AnhXa(){
        toolbar = findViewById(R.id.toolbarHome);
        viewFlipper = findViewById(R.id.viewFliper);
        recyclerView = findViewById(R.id.recycleView);
        navigationView = findViewById(R.id.navigationView);
        listViewHome = findViewById(R.id.listViewHome);

        listProductType = new ArrayList<>();

        productTypeAdapter = new ProductTypeAdapter(listProductType, getApplicationContext());
        listViewHome.setAdapter(productTypeAdapter);
    }
    private boolean isConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        if (activeNetwork != null) {
            // connected to the internet
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                // connected to wifi
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                // connected to mobile data
            } return true;
        } else {
            // not connected to the internet
        }
        return false;
    }
}