package com.mumu.mmrxretrofit;

import android.os.Bundle;
import android.widget.TextView;

import com.mumu.mmrxretrofit.base.BaseActivity;
import com.mumu.mmrxretrofit.retrofit.BaseObserverToken;
import com.mumu.mmrxretrofit.retrofit.MyObserver;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tv1)
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        initView();
//        initView1();
        initView2();
    }

    private void initView2() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("username", "13555555555");
        map.put("password", "E10ADC3949BA59ABBE56E057F20F883E");
        map.put("client_id", "view");
        map.put("client_secret", "view");
        map.put("grant_type", "password");
        map.put("scope", "app");
        RequestUtils.getToken(this, map, new BaseObserverToken<TokenEntity>() {
            @Override
            public void onSuccess(TokenEntity result) {
                tv1.setText(result.getAccess_token()+"");
            }

            @Override
            public void onFailure(Throwable e, String errorMsg) {
                tv1.setText(errorMsg+"");
            }
        });
    }

    private void initView1() {
        HashMap<String, Object> map = new HashMap<String, Object>();

        RequestUtils.getLogin(this, map, new MyObserver<LoginEntity.RestbodyBean>(this) {
            @Override
            public void onSuccess(LoginEntity.RestbodyBean result, Object num) {
                tv1.setText(result.getName()+"");
            }

            @Override
            public void onFailure(Throwable e, String errorMsg) {

            }
        });
    }

    private void initView() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("start", 0);
        map.put("limit", 10);
        map.put("type", 1);
        map.put("status", 4);
        RequestUtils.getDemo(this, map, new MyObserver<List<Demo.RestbodyBean>>(this) {
            @Override
            public void onSuccess(List<Demo.RestbodyBean> result, Object num) {
                tv1.setText(result.get(0).getSponsorId()+"");
            }

            @Override
            public void onFailure(Throwable e, String errorMsg) {

            }
        });
    }
}
