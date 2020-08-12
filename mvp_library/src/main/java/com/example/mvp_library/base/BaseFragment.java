package com.example.mvp_library.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;


import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends RxFragment {
    public Activity activity1;
    public Context context;
    private View rootView;
    private Unbinder unbinder;

    //绑定在fragment上
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        activity1= (Activity) context;
        this.context=activity;
    }

    //创建view视图

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if(rootView==null){
            rootView=inflater.inflate(initLayoutId(),null);
        }
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    //view视图创建完成
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract int initLayoutId();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (rootView!=null){
            ((ViewGroup)rootView.getParent()).removeView(rootView);
        }
        if (unbinder!=null){
            unbinder.unbind();
            unbinder=null;
        }
    }
}
