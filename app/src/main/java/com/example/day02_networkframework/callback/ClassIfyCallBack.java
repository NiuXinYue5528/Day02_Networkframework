package com.example.day02_networkframework.callback;

import com.example.day02_networkframework.ClassBean.Classify;
import com.example.http_library.callback.BaseCallBack;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public abstract class ClassIfyCallBack<T> extends BaseCallBack<T> {
    Classify classify;
    @Override
    protected T onconver(String result) {
        T t=null;
        classify = new Gson().fromJson(result, Classify.class);
        JsonElement data = classify.getData();
        String message = classify.getMessage();
        int status = classify.getStatus();
        switch (status) {
            case -1:
                onError(message, status);
                break;
            case 0:
                if (isCodeSuccess()){
                    t=convert(data);
                }
                break;
        }
        return t;
    }

    @Override
    public boolean isCodeSuccess() {
        if (classify!=null){
            return classify.getStatus()==0;
        }
        return false;
    }
}
