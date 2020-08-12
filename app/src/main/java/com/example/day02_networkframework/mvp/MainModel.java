package com.example.day02_networkframework.mvp;

import android.util.Log;

import com.example.day02_networkframework.ClassBean.ClassBeans;
import com.example.day02_networkframework.Demo;
import com.example.day02_networkframework.callback.ClassIfyCallBack;
import com.example.day02_networkframework.callback.HttpCallBack;
import com.example.day02_networkframework.demo.DemosBean;
import com.example.day02_networkframework.food.FoodBean;
import com.example.http_library.client.HttpClient;
import com.example.http_library.utils.JsonUtils;
import com.example.http_library.utils.LogUtils;
import com.example.mvp_library.model.BaseModel;
import com.google.gson.JsonElement;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.HashMap;
import java.util.List;

public class MainModel implements BaseModel {
    interface CallBack1{
        // void showDemo(List<Demo> demos);
        void showDeom(Demo demo);
        void showClassIfy(List<ClassBeans> classBeans);
    }

    public void setClassIfy(CallBack1 callBack1, LifecycleProvider lifecy) {
        new HttpClient.Builder()
                .setBaseUrl("http://169.254.1.54:8080/kotlin/category/")
                .setApiUrl("getCategory")
                .setLifecycleProvider(lifecy)
                .post()
                .build()
                .request(new ClassIfyCallBack<List<ClassBeans>>() {
                    @Override
                    public void onError(String message, int code) {
                        LogUtils.e(message);
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(List<ClassBeans> classBeans) {
                        callBack1.showClassIfy(classBeans);
                    }

                    @Override
                    public List<ClassBeans> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result, ClassBeans.class);
                    }
                });

    }


    public void getData(CallBack1 callBack1, LifecycleProvider lifecycleProvider) {
        new HttpClient.Builder()
                .setApiUrl("article/list/0/json")
                .get()
                .setLifecycleProvider(lifecycleProvider)
                .build()

                /*.request(new HttpCallBack<List<Demo>>() {
                    @Override
                    public void onError(String message, int code) {
                        Log.e("111", "onError: "+message );
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(List<Demo> demos) {
                        callBack1.showDemo(demos);
                    }

                    @Override
                    public List<Demo> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result, Demo.class);
                       // return JsonUtils.jsonToClass(result, Demo.class);
                    }
                });*/

                .request(new HttpCallBack<Demo>() {
                    @Override
                    public void onError(String message, int code) {
                        LogUtils.e(message);
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(Demo demo) {
                        LogUtils.e(demo.toString());
                        callBack1.showDeom(demo);
                    }

                    @Override
                    public Demo convert(JsonElement result) {
                        return JsonUtils.jsonToClass(result, Demo.class);
                    }
                });

    }
}
