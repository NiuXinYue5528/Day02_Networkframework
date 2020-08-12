package com.example.day02_networkframework.callback;


import com.example.http_library.callback.BaseCallBack;
import com.example.day02_networkframework.demo.Response;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public abstract class HttpCallBack<T> extends BaseCallBack<T> {
    Response response;
    @Override
    protected T onconver(String result) {
        T t=null;
        response = new Gson().fromJson(result, Response.class);
        JsonElement data = response.getData();
        int errorCode = response.getErrorCode();
        String errorMsg = response.getErrorMsg();
        switch (errorCode) {
            case -1:
                onError(errorMsg,errorCode);
                break;
            default:
                if (isCodeSuccess()) {
                    t=convert(data);
                }
        }
        return t;
    }


    @Override
    public boolean isCodeSuccess() {
        if (response != null) {
            return response.getErrorCode() == 0;
        }
        return false;
    }

}
