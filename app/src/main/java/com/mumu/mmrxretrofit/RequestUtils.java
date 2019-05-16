package com.mumu.mmrxretrofit;

import com.mumu.mmrxretrofit.retrofit.BaseObserverToken;
import com.mumu.mmrxretrofit.retrofit.MyObserver;
import com.mumu.mmrxretrofit.retrofit.RetrofitUtils;
import com.mumu.mmrxretrofit.retrofit.RxHelper;
import com.trello.rxlifecycle2.components.RxActivity;

import java.util.HashMap;
import java.util.List;

public class RequestUtils {
    /**
     * Get 请求demo
     * @param context
     * @param observer
     */
    public static void getDemo(RxActivity context, HashMap map, MyObserver<List<Demo.RestbodyBean>> observer){
        RetrofitUtils.getApiUrl()
                .getDemo(map).compose(RxHelper.observableIO2Main(context))
                .subscribe(observer);
    }

    /**
     * Get 请求demo
     * @param context
     * @param observer
     */
    public static void getLogin(RxActivity context, String auth, String cc, LoginParms body, MyObserver<LoginEntity.RestbodyBean> observer){
        RetrofitUtils.getApiUrl()
                .getLogin(auth,cc,body).compose(RxHelper.observableIO2Main(context))
                .compose(context.bindToLifecycle())
                .subscribe(observer);
    }
    /**
     * Get 请求demo
     * @param context
     * @param observer
     */
    public static void getToken(RxActivity context, HashMap map, BaseObserverToken<TokenEntity> observer){
        RetrofitUtils.getApiUrl()
                .getToken(map).compose(RxHelper.observableIO2Main(context))
                .compose(context.bindToLifecycle())
                .subscribe(observer);
    }

}
