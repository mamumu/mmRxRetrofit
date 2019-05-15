package com.mumu.mmrxretrofit.retrofit;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.webkit.WebSettings;

import com.mumu.dialog.MMAlertDialog;
import com.mumu.mmrxretrofit.MainActivity;
import com.mumu.mmrxretrofit.base.App;
import com.mumu.mmrxretrofit.base.AppManager;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * https://github.com/r17171709/Retrofit2Demo
 * Created by zeng on 2017/2/7.
 */

public class OkHttp3Utils {
    private OkHttpClient mOkHttpClient;
    Activity activity = AppManager.topActivity();
    //用户类型
    @SuppressLint("HandlerLeak")
    private Handler updateHandler = new Handler() {
        @Override
        public void dispatchMessage(Message msg) {
            super.dispatchMessage(msg);
            if (msg.what == 401) {
                //401token失效
                if (activity != null && !activity.isDestroyed()) {
                    try {
//                        PreferenceHelper.write(PreferenceHelper.DEFAULT_FILE_NAME, AppConfig.PREFER_TOKEN_TAG, "");

                        MMAlertDialog.showDialog(activity,
                                "温馨提示",
                                "登录失效，请重新登录",
                                null,
                                "去登陆",
                                false,
                                null,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        activity.startActivity(new Intent(activity, MainActivity.class));
                                        dialog.dismiss();
                                    }
                                });
                    } catch (Exception es) {
                        es.printStackTrace();
                    }
                }
            }
        }
    };

    //设置缓存目录
    private File cacheDirectory = new File(App.getInstance().getApplicationContext().getCacheDir().getAbsolutePath(), "MyCache");
    private Cache cache = new Cache(cacheDirectory, 10 * 1024 * 1024);

    /**
     * 获取OkHttpClient对象
     *
     * @return
     */
    public OkHttpClient getOkHttpClient() {

        if (null == mOkHttpClient) {

            //同样okhttp3后也使用build设计模式
            mOkHttpClient = new OkHttpClient.Builder()
                    //添加拦截器
                    .addInterceptor(new MyIntercepter())
                    //设置一个自动管理cookies的管理器
                    .cookieJar(new CookiesManager())
                    //添加网络连接器
                    //.addNetworkInterceptor(new CookiesInterceptor(MyApplication.getInstance().getApplicationContext()))
                    //设置请求读写的超时时间
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
//                    .cache(cache)//设置缓存
                    .retryOnConnectionFailure(false)//自动重试
                    .build();
        }
        return mOkHttpClient;
    }

    /**
     * 拦截器
     */
    private class MyIntercepter implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();

            if (!isNetworkReachable(App.instance.getApplicationContext())) {
                updateHandler.sendEmptyMessage(300);
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)//无网络时只从缓存中读取
                        .build();
            }
            Request.Builder builder1 = request.newBuilder();
            Request build;
            String token = "";
            try {
//                token = PreferenceHelper.readString(PreferenceHelper.DEFAULT_FILE_NAME, AppConfig.PREFER_TOKEN_TAG, "");
            } catch (Exception e) {
                e.printStackTrace();
                token = "";
            }
            //401跳转到登录页面；402跳转到开户审核中界面；403跳转到开户界面
            build = builder1
//                    .removeHeader("User-Agent")
//                    .addHeader("User-Agent", getUserAgent())
                    .addHeader("Authorization", token)
//                    .addHeader("appVersion", SystemToolUtils.getAppVersionName(AppManager.topActivity()))
//                    .addHeader("bundleID", SystemToolUtils.getAppPackageName(AppManager.topActivity()))
//                    .addHeader("machineType", "2")
                    .build();

            Response response = chain.proceed(build);
            int code = response.code();
            HttpUrl url = response.request().url();
            if (code == 401) {
                //跳转到登录页面
                updateHandler.sendEmptyMessage(401);
            }
//            else if (code == 402) {
//                //跳转到开户审核中界面
//                updateHandler.sendEmptyMessage(402);
//            } else if (code == 403) {
//                //跳转到开户界面
//                updateHandler.sendEmptyMessage(403);
//            }
            return response;
        }
    }

    private static String getUserAgent() {
        String userAgent = "";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            try {
                userAgent = WebSettings.getDefaultUserAgent(App.getInstance().getApplicationContext());
            } catch (Exception e) {
                userAgent = System.getProperty("http.agent");
            }
        } else {
            userAgent = System.getProperty("http.agent");
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0, length = userAgent.length(); i < length; i++) {
            char c = userAgent.charAt(i);
            if (c <= '\u001f' || c >= '\u007f') {
                sb.append(String.format("\\u%04x", (int) c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 自动管理Cookies
     */
    private class CookiesManager implements CookieJar {
        private final PersistentCookieStore cookieStore = new PersistentCookieStore(App.getInstance().getApplicationContext());

        @Override
        public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
            if (cookies != null && cookies.size() > 0) {
                for (Cookie item : cookies) {
                    cookieStore.add(url, item);
                }
            }
        }

        @Override
        public List<Cookie> loadForRequest(HttpUrl url) {
            List<Cookie> cookies = cookieStore.get(url);
            return cookies;
        }
    }

    /**
     * 判断网络是否可用
     *
     * @param context Context对象
     */
    public Boolean isNetworkReachable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo current = cm.getActiveNetworkInfo();
        if (current == null) {
            return false;
        }
        return (current.isAvailable());
    }
}
