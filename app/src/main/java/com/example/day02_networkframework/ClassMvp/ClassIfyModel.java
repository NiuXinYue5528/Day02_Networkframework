package com.example.day02_networkframework.ClassMvp;

import com.example.day02_networkframework.callback.ClassIfyCallBack;
import com.example.day02_networkframework.classtwo.ClassIfyBeanTwo;
import com.example.day02_networkframework.classtwo.ClassIfyParmsTwo;
import com.example.http_library.client.HttpClient;
import com.example.http_library.utils.JsonUtils;
import com.example.mvp_library.model.BaseModel;
import com.google.gson.JsonElement;

import java.util.List;

public class ClassIfyModel implements BaseModel  {
    interface ClassIfyCallBack{
        void onSuccess(List<ClassIfyBeanTwo> classIfyBeanTwo);
        void onFail(String error);
    }
    public void setData(ClassIfyCallBack classIfyCallBack, ClassIfyParmsTwo classIfyParmsTwo) {

        new HttpClient.Builder()
                .setApiUrl("goods/getGoodsList")
                .setJsonBody(JsonUtils.classToJson(classIfyParmsTwo), true)
                .post()
                .build()
                .request(new com.example.day02_networkframework.callback.ClassIfyCallBack<List<ClassIfyBeanTwo>>() {
                    @Override
                    public void onError(String message, int code) {
                        onError(message, code);
                    }

                    @Override
                    public void cancle() {
                    }

                    @Override
                    public void onSuccess(List<ClassIfyBeanTwo> classIfyBeanTwo) {
                        classIfyCallBack.onSuccess(classIfyBeanTwo);
                    }

                    @Override
                    public List<ClassIfyBeanTwo> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result, ClassIfyBeanTwo.class);
                    }
                });

    }


}
