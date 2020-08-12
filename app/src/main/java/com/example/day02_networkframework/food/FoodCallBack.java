package com.example.day02_networkframework.food;

import com.example.http_library.callback.BaseCallBack;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public abstract class FoodCallBack<T> extends BaseCallBack<T> {
    Food food;
    @Override
    protected T onconver(String result) {
        T t=null;
       food = new Gson().fromJson(result, Food.class);
        JsonElement data = food.getData();
        int ret = food.getRet();
        switch (ret){
            case -1:
                onError("", ret);
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
        if (food!=null){
            return food.getRet()==1;
        }
        return false;
    }
}
