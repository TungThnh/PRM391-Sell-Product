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

import model.TestProductGet;
import response.Items;

public class ProductAdapter1 extends RecyclerView.Adapter<ProductAdapter1.ViewHolder> {

    private ArrayList<Items> testProduct;
    String cbStatus;

    public ProductAdapter1(ArrayList<Items> testProduct) {
        this.testProduct = testProduct;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View inflate = layoutInflater.inflate(R.layout.adminrv_list_view_product, null);
        ViewHolder viewHolder = new ViewHolder(inflate);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Items testProductGet = testProduct.get(position);
        holder.txtRVCode.setText(testProductGet.getCode());
        holder.txtRVName.setText(testProductGet.getName());
        holder.txtRVPrice.setText(testProductGet.getPrice());
        holder.txtRVQuantity.setText(String.valueOf(testProductGet.getQuantity()));
        cbStatus = testProductGet.getRecord_status();
        holder.cbRVStatus.setChecked(true);

    }

    @Override
    public int getItemCount() {
        return testProduct.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtRVName, txtRVCode, txtRVQuantity, txtRVPrice;
        private CheckBox cbRVStatus;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtRVCode = itemView.findViewById(R.id.txtADRVCode);
            txtRVName = itemView.findViewById(R.id.txtADRVName);
            txtRVQuantity = itemView.findViewById(R.id.txtADRVQuantity);
            txtRVPrice = itemView.findViewById(R.id.txtADRVPrice);
            cbRVStatus = itemView.findViewById(R.id.cbADRVStatus);
        }

    }
}
