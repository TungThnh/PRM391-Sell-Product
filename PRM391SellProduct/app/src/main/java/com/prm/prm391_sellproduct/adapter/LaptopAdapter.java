package com.prm.prm391_sellproduct.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prm.prm391_sellproduct.R;
import com.prm.prm391_sellproduct.model.NewProduct;

import java.util.List;

public class LaptopAdapter extends RecyclerView.Adapter<LaptopAdapter.MyViewHolder> {
    Context context;
    List<NewProduct> array;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_laptop,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        NewProduct newProduct = array.get(position);
        holder.productName.setText(newProduct.getProductName());
    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView productName, price, decribe;
        ImageView img;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            productName = itemView.findViewById(R.id.itemlaptop_productName);
            price = itemView.findViewById(R.id.itemlaptop_price);
            decribe = itemView.findViewById(R.id.itemlaptop_decibe);
            img = itemView.findViewById(R.id.itemlaptop_img);

        }

    }
}
