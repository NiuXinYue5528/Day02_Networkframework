package com.example.day02_networkframework.mvp;

import com.example.day02_networkframework.ClassBean.ClassBeans;
import com.example.day02_networkframework.Demo;
import com.example.day02_networkframework.demo.DemosBean;
import com.example.mvp_library.view.BaseView;

import java.util.List;

public interface MainView extends BaseView {
    //void showDemo(List<Demo> demo);
    void showDemo(Demo demo);

    void showClassIfy(List<ClassBeans> beans);
}
