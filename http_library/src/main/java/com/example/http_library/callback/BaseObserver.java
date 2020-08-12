package com.example.http_library.callback;

import android.text.TextUtils;

import com.example.http_library.Exception.ApiException;
import com.example.http_library.Exception.ExceptionEngine;
import com.example.http_library.HttpGlobalConfig;
import com.example.http_library.disposable.ImpRequestManager;
import com.example.http_library.utils.ThreadUtils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public abstract class BaseObserver implements Observer{
    String tag;
    @Override
    public void onSubscribe(Disposable d) {
        if(!TextUtils.isEmpty(tag)){
            ImpRequestManager.getInstance().add(tag,d);
        }
    }

    @Override
    public void onNext(Object t) {
        if(!TextUtils.isEmpty(tag)){
            ImpRequestManager.getInstance().remove(tag);
        }
       // onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        if(e instanceof ApiException){
            ApiException apiException= (ApiException) e;
            onError(apiException.getMsg(),apiException.getCode());
        }else{
            onError("未知异常", ExceptionEngine.UN_KNOWN_ERROR);
        }
        if(!TextUtils.isEmpty(tag)){
            ImpRequestManager.getInstance().remove(tag);
        }
    }

    @Override
    public void onComplete() {
        if(!ImpRequestManager.getInstance().isdisposable(tag)){
            ImpRequestManager.getInstance().cancle(tag);
        }
    }

    //回调错错误信息
     public abstract void onError(String message, int code);

    // public abstract void onSuccess(Object t);

        public abstract void cancle();


    //网络请求取消
    public void canclend(){
        if(!ThreadUtils.isMainThread()){
            HttpGlobalConfig.getInstance().getHandler().post(new Runnable() {
                @Override
                public void run() {
                   cancle();
                }
            });
        }
    }
    //标识订阅
    public void setTag(String tag) {
        this.tag = tag;
    }
}
