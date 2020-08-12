package com.example.day02_networkframework.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day02_networkframework.ClassBean.ClassBeans;
import com.example.day02_networkframework.R;

import java.util.ArrayList;

public class ClassIfyAdapter extends RecyclerView.Adapter<ClassIfyAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ClassBeans> list;
    private  OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public ClassIfyAdapter(Context context, ArrayList<ClassBeans> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.rv_class, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_name.setText(list.get(position).getCategoryName());
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClick!=null){
                    onItemClick.onClick(position);
                }
            }
        });
        //        如果下标和传回来的下标相等 那么确定是点击的条目 把背景设置一下颜色
        if (position == getmPosition()) {
          //  holder.itemView.setBackgroundColor(Color.LTGRAY);
                holder.tv_name.setTextColor(Color.BLUE);
        }else{
//            否则的话就全白色初始化背景
            //holder.itemView.setBackgroundColor(Color.WHITE);
            holder.tv_name.setTextColor(Color.BLACK);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_name;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
        }

    }

    public interface OnItemClick{
        void onClick(int position);
    }

    private  int mPosition=-1;

    public int getmPosition() {
        return mPosition;
    }

    public void setmPosition(int mPosition) {
        this.mPosition = mPosition;
    }


}
