package com.example.day02_networkframework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day02_networkframework.R;
import com.example.day02_networkframework.classtwo.ClassIfyBeanTwo;

import java.util.ArrayList;

public class ClassIfyAdapterThree extends RecyclerView.Adapter<ClassIfyAdapterThree.ViewHolder> {
    private Context context;
    private ArrayList<ClassIfyBeanTwo> list;

    public ClassIfyAdapterThree(Context context, ArrayList<ClassIfyBeanTwo> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_rv_three, null);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
    }
}
