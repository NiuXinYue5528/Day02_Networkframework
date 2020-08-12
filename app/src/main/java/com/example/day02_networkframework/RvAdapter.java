package com.example.day02_networkframework;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {
    private Context context;
    private ArrayList<String> list;

    private String images[] = {
    };

    public RvAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_rv_zhe, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String s = list.get(position);
        Glide.with(context).load(s).into(holder.iv_img1);
//        Glide.with(context).load(images[1]).into(holder.iv_img2);
//        Glide.with(context).load(images[2]).into(holder.iv_img3);
//        Glide.with(context).load(images[3]).into(holder.iv_img4);
//        Glide.with(context).load(images[4]).into(holder.iv_img5);
        holder.tv_money1.setText("￥123.00");
//        holder.tv_money2.setText(s);
//        holder.tv_money3.setText(s);
//        holder.tv_money4.setText(s);
//        holder.tv_money5.setText(s);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_img1;
//        public ImageView iv_img2;
//        public ImageView iv_img3;
//        public ImageView iv_img4;
//        public ImageView iv_img5;
        public TextView tv_money1;
//        public TextView tv_money2;
//        public TextView tv_money3;
//        public TextView tv_money4;
//        public TextView tv_money5;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_img1 = (ImageView) rootView.findViewById(R.id.iv_img1);
//            this.iv_img2 = (ImageView) rootView.findViewById(R.id.iv_img2);
//            this.iv_img3 = (ImageView) rootView.findViewById(R.id.iv_img3);
//            this.iv_img4 = (ImageView) rootView.findViewById(R.id.iv_img4);
//            this.iv_img5 = (ImageView) rootView.findViewById(R.id.iv_img5);
            this.tv_money1 = (TextView) rootView.findViewById(R.id.tv_money1);
//            this.tv_money2 = (TextView) rootView.findViewById(R.id.tv_money2);
//            this.tv_money3 = (TextView) rootView.findViewById(R.id.tv_money3);
//            this.tv_money4 = (TextView) rootView.findViewById(R.id.tv_money4);
//            this.tv_money5 = (TextView) rootView.findViewById(R.id.tv_money5);
        }


    }
}
