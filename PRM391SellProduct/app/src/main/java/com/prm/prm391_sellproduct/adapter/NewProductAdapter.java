package com.prm.prm391_sellproduct.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.bumptech.glide.Glide;
import com.prm.prm391_sellproduct.R;
import com.prm.prm391_sellproduct.model.NewProduct;

import java.util.List;

public class NewProductAdapter extends RecyclerView.Adapter<NewProductAdapter.MyViewHolder> {
    Context context;
    List<NewProduct> array;

    public NewProductAdapter(Context context, List<NewProduct> array) {
        this.context = context;
        this.array = array;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_laptop,parent,false);

        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        NewProduct newProduct = array.get(position);
        holder.txtProductName.setText(newProduct.getProductName());
        holder.txtPrice.setText(newProduct.getProductPrice());
//        Glide.with(context).load(newProduct.getImage()).into(holder.imgProduct);
    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtProductName, txtPrice, txtDecribe;
        ImageView imgProduct;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            txtPrice  = itemView.findViewById(R.id.itemlaptop_price);
            txtProductName  = itemView.findViewById(R.id.itemlaptop_productName);
            imgProduct  = itemView.findViewById(R.id.itemlaptop_price);
        }
    }
}
