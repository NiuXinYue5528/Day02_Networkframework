package com.example.day02_networkframework.ClassMvp;

import com.example.day02_networkframework.classtwo.ClassIfyBeanTwo;
import com.example.day02_networkframework.classtwo.ClassIfyParmsTwo;
import com.example.day02_networkframework.mvp.MainModel;
import com.example.mvp_library.model.ModelFractroy;
import com.example.mvp_library.presonter.BasePresontion;

import java.util.List;

public class ClassIfyPresonter extends BasePresontion<ClassifyView> implements ClassIfyModel.ClassIfyCallBack {


    @Override
    public void onSuccess(List<ClassIfyBeanTwo> classIfyBeanTwo) {
        mView.onSuccess(classIfyBeanTwo);
    }

    @Override
    public void onFail(String error) {
        mView.onFail(error);
    }

    public void setData(ClassIfyParmsTwo classIfyParmsTwo) {
        ModelFractroy.creatModel(ClassIfyModel.class).setData(this,classIfyParmsTwo);
    }
}
