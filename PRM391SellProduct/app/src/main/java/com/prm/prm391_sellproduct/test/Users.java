package com.prm.prm391_sellproduct.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prm.prm391_sellproduct.R;

import java.util.ArrayList;

public class Users extends RecyclerView.Adapter<Users.UserView> {
    private ArrayList<DBHelper> arrayList;
    public Users(ArrayList<DBHelper> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public UserView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.test_rv_view,parent,false);
        return new UserView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserView holder, int position) {
        String user =String.valueOf(arrayList.get(position).getUserName());
        String id =String.valueOf(arrayList.get(position).getEmail());
        String title =arrayList.get(position).getNumber();
        holder.textUser.setText(user);
        holder.textTitle.setText(title);
        holder.textId.setText(id);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class UserView extends RecyclerView.ViewHolder{
        TextView textUser;
        TextView textId;
        TextView textTitle;

        public UserView(@NonNull View itemView) {

            super(itemView);
            textUser = (TextView) itemView.findViewById(R.id.textUser);
            textId = (TextView) itemView.findViewById(R.id.textId);
            textTitle = (TextView) itemView.findViewById(R.id.textTitle);
        }
    }
}