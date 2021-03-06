package com.example.http_library.disposable;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.reactivex.disposables.Disposable;

public class ImpRequestManager implements RequestManager {

    //双检索单列
    public static volatile ImpRequestManager instance;
    //管理所有的订阅map
    public Map<String, Disposable> mMap = new HashMap<>();

    public ImpRequestManager() {
    }

    //双检索单列
    public static ImpRequestManager getInstance() {
        if (instance == null) {
            synchronized (ImpRequestManager.class) {
                if (instance == null) {
                    instance = new ImpRequestManager();
                }
            }
        }
        return instance;
    }

    //添加订阅
    @Override
    public void add(String tag, Disposable disposable) {
        if (!TextUtils.isEmpty(tag)) {
            mMap.put(tag, disposable);
        }
    }

    //移除订阅
    @Override
    public void remove(String tag) {
        if (!TextUtils.isEmpty(tag)) {
            if (mMap == null) {
                return;
            }
            mMap.remove(tag);
        }
    }

    //取消订阅
    @Override
    public void cancle(String tag) {
        if (!TextUtils.isEmpty(tag)) {
            if (!mMap.isEmpty()) {
                if (mMap.get(tag) != null) {
                    Disposable disposable = mMap.get(tag);
                    if (disposable.isDisposed()) {
                        disposable.dispose();
                    }
                }
            }
        }
    }

    //取消所有订阅
    @Override
    public void cancleAll() {
       Disposable disposable=null;
       if (!mMap.isEmpty()){
           Set<String> keySet = mMap.keySet();
           for (String key:keySet
                ) {
               if (mMap.get(key)!=null){
                   disposable=mMap.get(key);
               }
               if (disposable!=null&&disposable.isDisposed()){
                   disposable.dispose();
               }
           }
        mMap.clear();
       }
    }
    public boolean isdisposable(String tag){
        if (!mMap.isEmpty()&&mMap.get(tag)!=null){
          return   mMap.get(tag).isDisposed();
        }
        return  false;
    }
}
