package com.mumu.mmrxretrofit.base;

import android.app.Application;

public class App extends Application {
    public static App instance;

    public static App getInstance() {
        return instance;
    }

    public static App getContext() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.instance = (App) getApplicationContext();
        registerActivityLifecycleCallbacks(new MyLifecycleHandler());
    }
}
