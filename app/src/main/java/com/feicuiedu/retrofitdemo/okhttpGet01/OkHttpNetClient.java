package com.feicuiedu.retrofitdemo.okhttpGet01;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by gqq on 2016/12/5.
 */

public class OkHttpNetClient implements UserApi{

    /**
     * 使用OkHttp进行请求
     * 1. 将OKHttpClient单例
     * 2. 构建请求：
     *      1. 创建一个接口：UserApi,目的:就是为了统一管理一下请求
     *      2. 类实现了这个接口：实现里面的方法，完成请求的构建
     * 3. Activity里面：去进行了请求，得到响应（更新UI）
     */

    /**
     * 对这个类进行单例，类的构造方法里面进行OkhttpClient的初始化
     */
    private static OkHttpNetClient mOkHttpNetClient;// 懒汉式单例
    private final OkHttpClient mOkHttpClient;

    private OkHttpNetClient(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
    }

    // 保证懒汉式线程安全
    public static synchronized OkHttpNetClient getInstance(){
        if (mOkHttpNetClient==null){
            mOkHttpNetClient = new OkHttpNetClient();
        }
        return mOkHttpNetClient;
    }

    @Override
    public Call getData(String url) {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        return mOkHttpClient.newCall(request);
    }
}
