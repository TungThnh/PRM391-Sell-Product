package com.prm.prm391_sellproduct.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prm.prm391_sellproduct.R;

import java.util.ArrayList;

import com.prm.prm391_sellproduct.response.ProductResponeMain;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{

    private ArrayList<ProductResponeMain> productResponseList;


    public ProductAdapter(ArrayList<ProductResponeMain> productResponseList) {
        this.productResponseList = productResponseList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View inflate = layoutInflater.inflate(R.layout.customer_rv_product, null);
        ViewHolder viewHolder = new ProductAdapter.ViewHolder(inflate);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductResponeMain productResponeMain = productResponseList.get(position);

        holder.txtProName.setText(productResponeMain.getName());
        holder.txtProPrice.setText(productResponeMain.getPrice());

    }

    @Override
    public int getItemCount() {
        return productResponseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        Button btnAddToCart;
        ImageView imgPicture;
        TextView txtProName, txtProPrice;

//        private CheckBox cbRVStatus;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtProName = itemView.findViewById(R.id.txtProductName);
            txtProPrice = itemView.findViewById(R.id.txtPrice);
            btnAddToCart = itemView.findViewById(R.id.btnAddtocart);
            imgPicture = itemView.findViewById(R.id.imgDetails);
        }

    }

}
