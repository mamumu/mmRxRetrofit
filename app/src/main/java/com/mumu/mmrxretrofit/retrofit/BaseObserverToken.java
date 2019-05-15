package com.mumu.mmrxretrofit.retrofit;

import com.mumu.mmrxretrofit.TokenEntity;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 数据返回统一处理  参考https://www.jianshu.com/p/ff619fea7e22
 * @param <T>
 */
public abstract class BaseObserverToken<T> implements Observer<TokenEntity> {
    private static final String TAG = "BaseObserver";
    @Override
    public void onNext(TokenEntity response) {
        //在这边对 基础数据 进行统一处理  举个例子：
            onSuccess(response);
    }

    @Override
    public void onError(Throwable e) {//服务器错误信息处理
        onFailure(e, RxExceptionUtil.exceptionHandler(e));
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    public abstract void onSuccess(TokenEntity result);

    public abstract void onFailure(Throwable e,String errorMsg);

}
