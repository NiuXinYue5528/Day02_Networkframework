package com.example.day02_networkframework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day02_networkframework.R;
import com.example.day02_networkframework.computerbean.ComputerBean;

import java.util.ArrayList;

public class ClassAdapterTwo extends RecyclerView.Adapter<ClassAdapterTwo.ViewHolder> {
    private Context context;
    private ArrayList<ComputerBean> computerBeans;
    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public ClassAdapterTwo(Context context, ArrayList<ComputerBean> computerBeans) {
        this.context = context;
        this.computerBeans = computerBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_computer, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(computerBeans.get(position).getCategoryIcon()).into(holder.iv_img);
        holder.tv_phone.setText(computerBeans.get(position).getCategoryName());
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClick!=null){
                    onItemClick.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return computerBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_img;
        public TextView tv_phone;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_img = (ImageView) rootView.findViewById(R.id.iv_img);
            this.tv_phone = (TextView) rootView.findViewById(R.id.tv_phone);
        }
    }
    public interface OnItemClick{
        void onClick(int position);
    }
}
