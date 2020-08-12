package com.example.http_library.client;

import com.example.http_library.Exception.ExceptionEngine;
import com.example.http_library.callback.BaseObserver;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.FragmentEvent;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class HttpObserver {
    //rxjava绑定生命周期
    LifecycleProvider lifecycleProvider;
    //activity具体的绑定生命周期
    ActivityEvent activityEvent;
    //fragment具体绑定生命周期
    FragmentEvent fragmentEvent;
    Observable observable;
    BaseObserver baseObserver;

    public HttpObserver(Builder builder) {
        this.observable=builder.observable;
        this.activityEvent=builder.activityEvent;
        this.baseObserver=builder.baseObserver;
        this.fragmentEvent=builder.fragmentEvent;
        this.lifecycleProvider=builder.lifecycleProvider;
    }

    //错误信息的分类回调
    private Observable onErrorResumeNext(){
        return bindlifecycle().onErrorResumeNext(new Function<Throwable, ObservableSource>() {
            @Override
            public ObservableSource apply(Throwable throwable) throws Exception {
                //所有异常错误
                return Observable.error(ExceptionEngine.handleException(throwable));
            }
        });
    }
    //监听取消订阅的操作
    private Observable doOnDispose(){
        if (baseObserver!=null){
            return onErrorResumeNext().doOnDispose(new Action() {
                @Override
                public void run() throws Exception {
                    baseObserver.canclend();
                }
            });
        }
        return observable;
    }
    //设置线程切换
    public Observable observable(){
        return doOnDispose().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //初始化返回值
    public Observable map() {
        return observable.map(new Function<JsonElement,Object>() {
            @Override
            public Object apply(JsonElement o) throws Exception {
                return new Gson().toJson(o);
            }
        });

    }
    //Rxjava的生命周期的绑定
    private Observable bindlifecycle() {
        Observable observable = map();
        if (lifecycleProvider != null) {
            if (activityEvent != null || fragmentEvent != null) {
                //两个同时存在,以 activity 为准
                if (activityEvent != null && fragmentEvent != null) {
                    return map().compose(lifecycleProvider.bindUntilEvent(activityEvent));
                }
                if (activityEvent != null) {
                    return map().compose(lifecycleProvider.bindUntilEvent(activityEvent));
                }
                if (fragmentEvent != null) {
                    return map().compose(lifecycleProvider.bindUntilEvent(fragmentEvent));
                }
            } else {
                return map().compose(lifecycleProvider.bindToLifecycle());
            }
        }
        return observable;
    }

    public static Builder createBuilder(Observable observable){
        return new Builder(observable);
    }
    public static final class  Builder{
        //rxjava绑定生命周期
        LifecycleProvider lifecycleProvider;
        //activity具体的绑定生命周期
        ActivityEvent activityEvent;
        //fragment具体绑定生命周期
        FragmentEvent fragmentEvent;
        Observable observable;
        BaseObserver baseObserver;

        public Builder setLifecycleProvider(LifecycleProvider lifecycleProvider) {
            this.lifecycleProvider = lifecycleProvider;
            return this;
        }

        public Builder setActivityEvent(ActivityEvent activityEvent) {
            this.activityEvent = activityEvent;
            return this;
        }

        public Builder setFragmentEvent(FragmentEvent fragmentEvent) {
            this.fragmentEvent = fragmentEvent;
            return this;
        }

        public Builder setObservable(Observable observable) {
            this.observable = observable;
            return this;
        }

        public Builder setBaseObserver(BaseObserver baseObserver) {
            this.baseObserver = baseObserver;
            return this;
        }

        public Builder(Observable observable) {
            this.observable = observable;
        }
        public HttpObserver build(){
            return new HttpObserver(this);
        }
    }







}

