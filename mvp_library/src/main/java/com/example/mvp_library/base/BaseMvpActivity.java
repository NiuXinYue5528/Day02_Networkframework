package com.example.mvp_library.base;

import com.example.mvp_library.presonter.BasePresontion;
import com.example.mvp_library.view.BaseView;

public abstract class BaseMvpActivity<V extends BaseView,P extends BasePresontion<V>> extends BaseActivity{

    public P mPresonter;


    @Override
    protected void initEvent() {
        mPresonter=initPresonter();
        if (mPresonter!=null){
            mPresonter.attacthView((V) this);
            initListData();
        }
    }

    protected abstract void initListData();

    protected abstract P initPresonter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresonter!=null){
            mPresonter.destoryView();
            mPresonter=null;
        }
    }
}
