package com.example.http_library.client;

import android.text.TextUtils;

import com.example.http_library.HttpGlobalConfig;
import com.example.http_library.HttpManager;
import com.example.http_library.callback.BaseCallBack;
import com.example.http_library.server.ApiService;
import com.google.gson.JsonElement;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.FragmentEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Retrofit;

public class HttpClient {
    //请求方式
    Method method;
    //请求参数
    Map<String, Object> paramser;
    //请求头信息
    Map<String, Object> header;
    //rxjava绑定生命周期
    LifecycleProvider lifecycleProvider;
    //activity具体的绑定生命周期
    ActivityEvent activityEvent;
    //fragment具体绑定生命周期
    FragmentEvent fragmentEvent;
    String baseUrl;
    //拼接url
    String apiUrl;
    //是否是json上传
    boolean isJson;
    //json字符串
    String jsonBody;
    //超时时间
    long time;
    //时间单位
    TimeUnit timeUnit;

    //回调接口
    BaseCallBack baseCallBack;
    //订阅标识
    String tag;



    //get set方法
    public Method get() {
        return Method.GET;
    }

    //初始化变量
    public HttpClient(Builder builder) {
        this.method=builder.method;
        this.activityEvent=builder.activityEvent;
        this.fragmentEvent=builder.fragmentEvent;
        this.apiUrl=builder.apiUrl;
        this.header=builder.header;
        this.isJson=builder.isJson;
        this.jsonBody=builder.jsonBody;
        this.lifecycleProvider=builder.lifecycleProvider;
        this.time=builder.time;
        this.timeUnit=builder.timeUnit;
        this.tag=builder.tag;
        this.paramser=builder.paramser;
        this.baseUrl=builder.baseUrl;
    }

    public void request(BaseCallBack baseCallBack){
        if (baseCallBack==null){
            new RuntimeException("no have callback,must do Observer");
        }
        this.baseCallBack=baseCallBack;
        doRequest();
    }

    private void doRequest() {
        //组装obserable，并且根据请求方法返回对应的obserable，去处理异常结果的回调
        if (TextUtils.isEmpty(tag)){
            tag=System.currentTimeMillis()+"";//当前线程
        }
        baseCallBack.setTag(tag);
        //添加参数信息
        addPramaers();
        //添加头信息
        addHeaders();
        //创建JsonElement
       // Observable<JsonElement> observable=createObservabler();
        Observable observable=createObservabler();
        HttpObserver httpObserver = new HttpObserver.Builder(observable)
                .setActivityEvent(activityEvent)
                .setFragmentEvent(fragmentEvent)
                .setBaseObserver(baseCallBack)
                .build();
        httpObserver.observable().subscribe(baseCallBack);

    }

    private Observable createObservabler() {

        Observable observable=null;

        boolean hasBodyString = !TextUtils.isEmpty(jsonBody);
        RequestBody requestBody = null;
        if (hasBodyString) {
            //jsonapplication/:json  body:text/plain;charset=utf-8  文本
            String mediaType = isJson ? "application/json; charset=utf-8" : "text/plain;charset=utf-8";
            requestBody = RequestBody.create(okhttp3.MediaType.parse(mediaType), jsonBody);
        }
        //默认请求post
        if (method==null){
            method=Method.POST;
       }
        if (HttpGlobalConfig.getInstance().getBaseUrl()!=null){
            this.baseUrl=HttpGlobalConfig.getInstance().getBaseUrl();
        }
        if (HttpGlobalConfig.getInstance().getTimeUnit()!=null){
            this.timeUnit=HttpGlobalConfig.getInstance().getTimeUnit();
        }
        if (HttpGlobalConfig.getInstance().getTimeout()!=0){
            this.time=HttpGlobalConfig.getInstance().getTimeout();
        }
        if (this.time==0){
            this.time=HttpConstant.TIME_OUT;
        }
        if (this.timeUnit==null){
            this.timeUnit=HttpConstant.TIME_UNIT;
        }
        ApiService apiService = HttpManager.getInstance().getRetrofit(baseUrl, time, timeUnit).create(ApiService.class);
        switch (method){
            case POST:
                if (isJson){
                    observable=apiService.postJson(apiUrl, requestBody, header);
                }else {
                    observable=apiService.post(apiUrl, paramser, header);
                }
                break;
            case GET:
                observable=apiService.get(apiUrl, paramser, header);
                break;
            case DELETE:
                observable=apiService.delete(apiUrl, paramser, header);
                break;
            case PUT:
                observable=apiService.put(apiUrl, paramser, header);
                break;

        }
        return observable;
    }

    private void addHeaders() {
        if (header==null){
            header=new HashMap<>();
        }
        if (HttpGlobalConfig.getInstance().getBaseHeardes()!=null){
            header.putAll(HttpGlobalConfig.getInstance().getBaseHeardes());
        }
    }

    //添加公共的请求参数
    private void addPramaers() {
        if (paramser==null){
            paramser=new HashMap<>();
        }
        //添加公共的请求参数
        if (HttpGlobalConfig.getInstance().getBaseParams()!=null){
            paramser.putAll(HttpGlobalConfig.getInstance().getBaseParams());
        }

    }

    public static  class Builder {
        //请求方式
        Method method;
        //请求参数
        Map<String, Object> paramser;
        //请求头信息
        Map<String, Object> header;
        //rxjava绑定生命周期
        LifecycleProvider lifecycleProvider;
        //activity具体的绑定生命周期
        ActivityEvent activityEvent;
        //fragment具体绑定生命周期
        FragmentEvent fragmentEvent;
        String baseUrl;
        //拼接url
        String apiUrl;
        //是否是json上传
        boolean isJson;
        //json字符串
        String jsonBody;
        //超时时间
        long time;
        //时间单位
        TimeUnit timeUnit;
        String tag;

        public Builder setTag(String tag) {
            this.tag = tag;
            return this;
        }

        public Builder() {
        }

        public Builder post() {
            this.method=Method.POST;
            return this;
        }

        public Builder delete() {
            this.method=Method.DELETE;
            return this;
        }

        public Builder put() {
            this.method=Method.PUT;
            return this;
        }
        public Builder get() {
            this.method=Method.GET;
            return this;
        }
        public Map<String, Object> getParamser() {
            return paramser;
        }
        //设置参数的拼接
        public Builder setParamser(Map<String, Object> paramser) {
            this.paramser = paramser;
            return this;
        }

        public Map<String, Object> getHeaders() {
            return header;
        }
        //请求头的拼接
        public Builder setHeader(Map<String, Object> headers) {
            this.header = headers;
            return this;
        }

        public LifecycleProvider getLifecycleProvider() {
            return lifecycleProvider;
        }
        //用于绑定Rxjava的生命周期
        public Builder setLifecycleProvider(LifecycleProvider lifecycleProvider) {
            this.lifecycleProvider = lifecycleProvider;
            return this;
        }

        public ActivityEvent getActivityEvent() {
            return activityEvent;
        }

        public Builder setActivityEvent(ActivityEvent activityEvent) {
            this.activityEvent = activityEvent;
            return this;
        }

        public FragmentEvent getFragmentEvent() {
            return fragmentEvent;
        }

        public Builder setFragmentEvent(FragmentEvent fragmentEvent) {
            this.fragmentEvent = fragmentEvent;
            return this;
        }

        public String getBaseUrl() {
            return baseUrl;
        }

        public Builder setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }



        public Builder setApiUrl(String apiUrl) {
            this.apiUrl = apiUrl;
            return this;
        }

        public long getTime() {
            return time;
        }

        public Builder setTime(long time) {
            this.time = time;
            return this;
        }

        public TimeUnit getTimeUnit() {
            return timeUnit;
        }

        public Builder setTimeUnit(TimeUnit timeUnit) {
            this.timeUnit = timeUnit;
            return this;
        }
        public Builder setJsonBody(String jsonBody,boolean isJson) {
            this.jsonBody = jsonBody;
            this.isJson=isJson;
            return this;
        }



        public HttpClient build(){
            return new HttpClient(this);
        }


    }

}
