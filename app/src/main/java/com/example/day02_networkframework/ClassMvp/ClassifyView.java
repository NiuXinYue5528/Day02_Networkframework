package com.example.day02_networkframework.ClassMvp;

import com.example.day02_networkframework.classtwo.ClassIfyBeanTwo;
import com.example.mvp_library.view.BaseView;

import java.util.List;

public interface ClassifyView extends BaseView {
    void onSuccess(List<ClassIfyBeanTwo> classIfyBeanTwo);
    void onFail(String error);
}
