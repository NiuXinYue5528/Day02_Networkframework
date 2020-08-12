package com.example.day02_networkframework.mvp;

import com.example.day02_networkframework.ClassBean.ClassBeans;
import com.example.day02_networkframework.Demo;
import com.example.day02_networkframework.demo.DemosBean;
import com.example.mvp_library.model.ModelFractroy;
import com.example.mvp_library.presonter.BasePresontion;

import java.util.List;

public class MainPresontion extends BasePresontion<MainView> implements MainModel.CallBack1 {
  /*  @Override
    public void showDemo(List<Demo> demo) {
        mView.showDemo(demo);
    }*/

    public void getData() {
        ModelFractroy.creatModel(MainModel.class).getData(this,getLifecy());
    }


    @Override
    public void showDeom(Demo demo) {
        mView.showDemo(demo);
    }

    @Override
    public void showClassIfy(List<ClassBeans> classBeans) {
        mView.showClassIfy(classBeans);
    }

    public void setClassIfy() {
        ModelFractroy.creatModel(MainModel.class).setClassIfy(this,getLifecy());
    }
}
