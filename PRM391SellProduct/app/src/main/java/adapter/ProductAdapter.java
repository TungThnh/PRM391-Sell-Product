package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prm.prm391_sellproduct.R;

import java.util.ArrayList;

import response.ProductResponse;

public class ProductAdapter extends BaseAdapter {

    private ArrayList<ProductResponse> productResponseList;
    private int layout;
    Context context;

    public ProductAdapter(ArrayList<ProductResponse> productResponseList, int layout, Context context) {
        this.productResponseList = productResponseList;
        this.layout = layout;
        this.context = context;
    }



    public ProductAdapter(ArrayList<ProductResponse> productResponseList) {
        this.productResponseList = productResponseList;
    }

    @Override
    public int getCount() {
        if(productResponseList != null) {
            return productResponseList.size();
        }

        return 0;
    }

    @Override
    public Object getItem(int position) {
        return productResponseList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return productResponseList.get(position).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewProduct;
        if(view == null){
            viewProduct = View.inflate(viewGroup.getContext(), R.layout.adminrv_list_view_product,null);
        }else{
            viewProduct = view;
        }

        ProductResponse product = (ProductResponse) getItem(i);
        ((TextView) viewProduct.findViewById(R.id.txtADRVCode)).setText(String.format("Code = %d", product.getCode()));
        ((TextView) viewProduct.findViewById(R.id.txtADRVName)).setText(String.format("Name = %d", product.getName()));
        ((TextView) viewProduct.findViewById(R.id.txtADRVPrice)).setText(String.format("Price = %d", product.getPrice()));
        ((TextView) viewProduct.findViewById(R.id.txtADRVQuantity)).setText(String.format("Quantity = %s", product.getQuantity()));
        if(product.getRecord_status().equals("O")) {
            ((CheckBox) viewProduct.findViewById(R.id.cbADRVStatus)).setChecked(true);
        }else{
            ((CheckBox) viewProduct.findViewById(R.id.cbADRVStatus)).setChecked(false);
        }

        return viewProduct;
    }


    public class ProductViewHolder extends RecyclerView.ViewHolder{

        private TextView txtRVName, txtRVCode, txtRVQuantity, txtRVPrice;
        private CheckBox cbRVStatus;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            txtRVCode = itemView.findViewById(R.id.txtADRVCode);
            txtRVName = itemView.findViewById(R.id.txtADRVName);
            txtRVQuantity = itemView.findViewById(R.id.txtADRVQuantity);
            txtRVPrice = itemView.findViewById(R.id.txtADRVPrice);
            cbRVStatus = itemView.findViewById(R.id.cbADRVStatus);
        }


    }

}
