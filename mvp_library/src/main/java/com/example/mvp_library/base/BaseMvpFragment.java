package com.example.mvp_library.base;

import com.example.mvp_library.base.BaseFragment;
import com.example.mvp_library.presonter.BasePresontion;
import com.example.mvp_library.view.BaseView;

public abstract class BaseMvpFragment<V extends BaseView,P extends BasePresontion<V>> extends BaseFragment {
   public P mPresonter;

    @Override
    protected void initData() {
        mPresonter=initPresonter();
        if (mPresonter!=null){
            mPresonter.attacthView((V) this);
            initListData();
        }
    }

    protected abstract void initListData();

    protected abstract P initPresonter();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresonter!=null){
            mPresonter.destoryView();
            mPresonter=null;
        }
    }
}
