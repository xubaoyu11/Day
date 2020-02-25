package com.example.day5.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day5.R;
import com.example.day5.entity.ShopEntity;

import java.util.List;

public class MyBaseAdapter extends RecyclerView.Adapter<MyBaseAdapter.MyViewHolder>
{
    private Context context;
    private List<ShopEntity.ResultBean>list;

    public MyBaseAdapter(Context context, List<ShopEntity.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.mylist,null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(list.get(position).getCommodityName());
        holder.price.setText(list.get(position).getPrice());
        Glide.with(context).load(list.get(position).getMasterPic()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                .into(holder.imageView);
    }



    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView name,price;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
            name=itemView.findViewById(R.id.name);
            price=itemView.findViewById(R.id.price);
        }
    }

    private RyItemClick ryItemClick;
    public void setRyItemClick(RyItemClick ryItemClick){
        this.ryItemClick=ryItemClick;
    }
    public interface RyItemClick{
        void onclick(String name);
    }
}
