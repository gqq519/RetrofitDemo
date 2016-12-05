package com.feicuiedu.retrofitdemo.okhttpGet01;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by gqq on 2016/12/5.
 */

public class OkHttpNetClient {

    /**
     * 使用OkHttp进行请求
     * 1. 将OKHttpClient单例
     */

    /**
     * 对这个类进行单例，类的构造方法里面进行OkhttpClient的初始化
     */
    private static OkHttpNetClient mOkHttpNetClient;

    private OkHttpNetClient(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
    }

    public static synchronized OkHttpNetClient getInstance(){
        if (mOkHttpNetClient==null){
            mOkHttpNetClient = new OkHttpNetClient();
        }
        return mOkHttpNetClient;
    }
}
