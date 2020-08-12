package com.example.httplibrary;

import android.os.Looper;
import android.util.Log;

import com.example.httplibrary.utils.LogUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpManager {
    private static volatile HttpManager instance;
    //双检索单列
    public static HttpManager getInstance(){
        if (instance==null){
            synchronized (HttpManager.class){
                if (instance==null){
                    instance=new HttpManager();
                }
            }
        }
        return instance;
    }
    //无参构造
    public HttpManager(){}

    //封装retrofit
    public Retrofit getRetrofit(String baseUrl, long timeout, TimeUnit timeUnit){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .client(getBaseOkhttpClient(timeout,timeUnit))
                .build();
    }

    private OkHttpClient getBaseOkhttpClient(long timeout, TimeUnit timeUnit) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {

            }
        });
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response proceed = chain.proceed(request);
                return proceed;
            }
        };

        Interceptor[] interceptors={httpLoggingInterceptor,interceptor};


        return getClient(timeout,timeUnit,interceptors);
    }

    private OkHttpClient getClient(long timeout, TimeUnit timeUnit, Interceptor[] interceptors) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(timeout, timeUnit)//连接时间
                .writeTimeout(timeout, timeUnit)//写出时间
                .readTimeout(timeout, timeUnit);//读取时间
        for (Interceptor interceptor :interceptors) {
            builder.addInterceptor(interceptor);
        }
        ArrayList<Interceptor> interceptors1 = HttpGlobalConfig.getInstance().getInterceptors();
        if (interceptors1!=null){
            for (Interceptor interceptor :interceptors1) {
                builder.addInterceptor(interceptor);
            }
        }
        return builder.build() ;
    }
}
