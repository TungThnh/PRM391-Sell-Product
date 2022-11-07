package com.prm.prm391_sellproduct.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.nex3z.notificationbadge.NotificationBadge;
import com.prm.prm391_sellproduct.R;
import com.prm.prm391_sellproduct.model.Cart;
import com.prm.prm391_sellproduct.model.NewProduct;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    TextView productName, price , decribe;
    Button btnAdd;
    ImageView imgProduct;
    Spinner spinner;
    Toolbar toolbar;
    ArrayList<Cart> arrayCart;
    NewProduct newProduct;
    NotificationBadge badge;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_details);
        initView();
        ActionToolBar();
        initData();
        initControl();
    }

    private void initControl() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart();
            }
        });
    }

    private void addToCart() {
        if (arrayCart.size() > 0){
            boolean flag = false;
            int amount = Integer.parseInt(spinner.getSelectedItem().toString());
            for (int i = 0; i < arrayCart.size();i++){
                if (arrayCart.get(i).getId() == newProduct.getId()){
                    arrayCart.get(i).setAmount(amount + arrayCart.get(i).getAmount());
                    long price = Long.parseLong(newProduct.getPrice())*arrayCart.get(i).getAmount();
                    arrayCart.get(i).setPrice(price);
                    flag = true;
                    Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_LONG).show();
                }
            }
            if (flag == false){
                long price = Long.parseLong(newProduct.getPrice()) * amount;
                Cart cart = new Cart();
                cart.setPrice(price);
                cart.setAmount(amount);
                cart.setId(newProduct.getId());
                cart.setImPro(newProduct.getImgProduct());
                arrayCart.add(cart);
            }
        }else{
            int amount = Integer.parseInt(spinner.getSelectedItem().toString());
            long price = Long.parseLong(newProduct.getPrice()) * amount;
            Cart cart = new Cart();
            cart.setPrice(price);
            cart.setAmount(amount);
            cart.setId(newProduct.getId());
            cart.setImPro(newProduct.getImgProduct());
            arrayCart.add(cart);
        }
        badge.setText(String.valueOf(arrayCart.size()));
    }


    private void initData() {
        NewProduct newProduct = (NewProduct) getIntent().getSerializableExtra("Details");
        productName.setText(newProduct.getName());
        decribe.setText(newProduct.getDescription());
        Glide.with(getApplicationContext()).load(newProduct.getImgProduct()).into(imgProduct);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        price.setText("Giá: " +decimalFormat.format(Double.parseDouble(newProduct.getPrice()))+ "Đ");

    }

    private void initView(){
        productName = findViewById(R.id.txtProductName);
        price = findViewById(R.id.txtPrice);
        decribe = findViewById(R.id.txtDeciption);
        btnAdd = findViewById(R.id.btnAddtocart);
        spinner = findViewById(R.id.spinner);
        imgProduct = findViewById(R.id.imgDetails);
        toolbar = findViewById(R.id.toolbar);
        badge = findViewById(R.id.menu_amount);
        if (arrayCart != null){
            badge.setText(String.valueOf(arrayCart.size()));
        }
    }

    private void ActionToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
