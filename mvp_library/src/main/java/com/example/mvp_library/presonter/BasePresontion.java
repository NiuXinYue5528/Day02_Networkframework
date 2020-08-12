package com.example.mvp_library.presonter;

import com.example.mvp_library.view.BaseView;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.lang.ref.WeakReference;

public class BasePresontion<V extends BaseView> {

    public V mView;

    private WeakReference<V> weakReference;
    //绑定view
    public void attacthView(V view){
        weakReference=new WeakReference<V>(view);
        mView=weakReference.get();
    }
    //返回视图对象   LifecycleProvider(rxjava绑定生命周期)
    public LifecycleProvider getLifecy(){
        return (LifecycleProvider) mView;
    }
    //解绑
    public void destoryView(){
        if (weakReference!=null){
            weakReference.clear();//清空view
        }
    }

}
