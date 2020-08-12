package com.example.day02_networkframework;

import android.app.Application;

import com.example.http_library.HttpGlobalConfig;
import com.example.http_library.client.HttpConstant;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.commonsdk.UMConfigure;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;

public class ShopApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        HttpGlobalConfig.getInstance()
//                .setBaseUrl("https://www.wanandroid.com/")
               // .setBaseUrl("https://www.qubaobei.com/ios/")
                //.setBaseUrl("http://169.254.39.119:8080/kotlin/")
                . setBaseUrl("http://169.254.1.54:8080/kotlin/")
                .setTimeout(HttpConstant.TIME_OUT)
                .setShowLog(true)
                .setTimeUnit(HttpConstant.TIME_UNIT)
                .initReady(this);
        UMConfigure.init(this, "5f2bf687d30932215475ac7e", "Umeng11", UMConfigure.DEVICE_TYPE_PHONE, "");
        UMConfigure.setLogEnabled(true);
        tengXunBug();
        lyzerPro();


    }

    private void lyzerPro() {
        //出现内存泄漏报一个通知
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for
            // heap analysis.
            // You should not init your app in this process.
            return;
        }

        LeakCanary.install(this);
    }

    private void tengXunBug() {
        CrashReport.initCrashReport(getApplicationContext(), "085de4cfc8", false);
      // CrashReport.testJavaCrash();//测试crash   //直接蹦
    }
}
