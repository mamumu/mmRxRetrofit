package com.mumu.mmrxretrofit.retrofit;


import android.support.annotation.NonNull;


import com.mumu.mmrxretrofit.ApiUrl;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit封装
 */
public class RetrofitUtils {
    private static final String TAG = "RetrofitUtils";
    private static ApiUrl mApiUrl;
    /**
     * 单例模式
     */
    public static ApiUrl getApiUrl() {
        if (mApiUrl == null) {
            synchronized (RetrofitUtils.class) {
                if (mApiUrl == null) {
                    mApiUrl = new RetrofitUtils().getRetrofit();
                }
            }
        }
        return mApiUrl;
    }
    private RetrofitUtils(){}

    public ApiUrl getRetrofit() {
        // 初始化Retrofit
//        ApiUrl apiUrl = initRetrofit(initOkHttp()) .create(ApiUrl.class);
        OkHttp3Utils okHttp3Utils = new OkHttp3Utils();
        ApiUrl apiUrl = initRetrofit(okHttp3Utils.getOkHttpClient()) .create(ApiUrl.class);
        return apiUrl;
    }

    /**
     * 初始化Retrofit
     */
    @NonNull
    private Retrofit initRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                    .client(client)
                    .baseUrl(BaseURL.BaseUrl)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
    }

    /**
     * 初始化okhttp
     */
    @NonNull
    private OkHttpClient initOkHttp() {
        return new OkHttpClient().newBuilder()
                    .readTimeout(BaseURL.DEFAULT_TIME, TimeUnit.SECONDS)//设置读取超时时间
                    .connectTimeout(BaseURL.DEFAULT_TIME, TimeUnit.SECONDS)//设置请求超时时间
                    .writeTimeout(BaseURL.DEFAULT_TIME,TimeUnit.SECONDS)//设置写入超时时间
                    .addInterceptor(new LogInterceptor())//添加打印拦截器
                    .retryOnConnectionFailure(false)//设置出现错误进行重新连接。
                    .build();
    }
}

