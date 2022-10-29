package com.prm.prm391_sellproduct.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.prm.prm391_sellproduct.R;
import com.prm.prm391_sellproduct.model.ProductType;

import java.util.List;

public class ProductTypeAdapter extends BaseAdapter {
    List<ProductType> arrayList;
    Context context;

    public ProductTypeAdapter(List<ProductType> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size() ;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public class ViewHolder{
        TextView txtProductName;
        ImageView imgProduct;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (view == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_product, null);
            viewHolder.txtProductName = view.findViewById(R.id.txtNameItem);
            viewHolder.txtProductName = view.findViewById(R.id.imgItem);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
            viewHolder .txtProductName.setText(arrayList.get(position).getProductName());
            Glide.with(context).load(arrayList.get(position).getProductImage()).into(viewHolder.imgProduct);
        }
        return view ;
    }
}
