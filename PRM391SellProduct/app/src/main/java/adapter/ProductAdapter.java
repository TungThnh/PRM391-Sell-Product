package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prm.prm391_sellproduct.R;

import java.util.ArrayList;
import java.util.List;

import response.ProductResponse;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{

    private ArrayList<ProductResponse> productResponseList;

    public ProductAdapter(ArrayList<ProductResponse> productResponseList) {
        this.productResponseList = productResponseList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.adminrv_list_view_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        ProductResponse productResponse = productResponseList.get(position);

        if(productResponse == null){
            return;
        }

        holder.txtRVCode.setText(productResponse.getCode());
        holder.txtRVName.setText(productResponse.getName());
        holder.txtRVQuantity.setText(String.valueOf(productResponse.getQuantity()));
        holder.txtRVPrice.setText(String.valueOf(productResponse.getPrice()));
        holder.cbRVStatus.setChecked(Boolean.parseBoolean(productResponse.getRecord_status()));
    }

    @Override
    public int getItemCount() {
        if(productResponseList != null) {
            return productResponseList.size();
        }
        return 0;
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
