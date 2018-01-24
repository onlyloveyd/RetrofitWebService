package com.gs.retrofitwebservice;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * 文 件 名: App
 * 创 建 人: 易冬
 * 创建日期: 2018/1/24 21:33
 * 邮   箱: onlyloveyd@gmail.com
 * 博   客: https://onlyloveyd.cn
 * 描   述：
 */
public class App extends Application{

    @Override public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...
    }
}
