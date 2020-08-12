package com.example.mvp_library.model;

import java.util.HashMap;
import java.util.Map;

public class ModelFractroy {
    //存储model类的集合
    private static Map<String,BaseModel> mMap=new HashMap<>();

    //反射
    public static <M extends BaseModel> M creatModel(Class<M> mClass){
        if (mMap.get(mClass)!=null){
           return (M) mMap.get(mClass);
        }
        M mModel=null;
        try {
            //通过反射创建对象，你的子类的model必须要有无参构造
            mModel= mClass.newInstance();
            if (mModel!=null){
                mMap.put(mClass.getName(), mModel);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return mModel;
    }

}
