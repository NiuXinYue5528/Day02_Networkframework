package com.example.day02_networkframework.Wanandroid;

import android.util.Log;

import com.example.http_library.callback.BaseCallBack;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public abstract class PlayCallBack<T> extends BaseCallBack<T> {
    PlayAndroid playAndroid;
    @Override
    protected T onconver(String result) {
        T t=null;
        playAndroid = new Gson().fromJson(result, PlayAndroid.class);
        JsonElement data = playAndroid.getData();
      //  Log.e("111", "onconver: "+data.toString() );
        int errorCode = playAndroid.getErrorCode();
        String errorMsg = playAndroid.getErrorMsg();
       switch (errorCode){
           case -1:
               onError(errorMsg, errorCode);
               break;
               default:
                   if (isCodeSuccess()){
                       t=convert(data);
                   }
                   break;
       }
        return t;
    }

    @Override
    public boolean isCodeSuccess() {
        return false;
    }
}
