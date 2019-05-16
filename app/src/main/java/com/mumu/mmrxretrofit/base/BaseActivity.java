package com.mumu.mmrxretrofit.base;

import android.os.Bundle;

import com.trello.rxlifecycle2.components.RxActivity;

public class BaseActivity extends RxActivity {
    @Override
    protected void onCreate(@androidx.annotation.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager(this).addActivity(this);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager(this).finishActivity(this);
    }

}
