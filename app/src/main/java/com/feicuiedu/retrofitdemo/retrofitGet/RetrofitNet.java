package com.feicuiedu.retrofitdemo.retrofitGet;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gqq on 2016/12/6.
 */

public class RetrofitNet {

    private static RetrofitNet mRetrofitNet;
    public final UserRetrofitApi mUserRetrofitApi;

    private RetrofitNet() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        // Retrofit初始化
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")// Retrofit必须要添加的baseUrl
                .client(okHttpClient)// 给Retrofit设置OKHttpClient，暂时只是为了使用拦截器
                .addConverterFactory(GsonConverterFactory.create())// 添加Gson转换器
                .build();

        // 实现接口请求
        mUserRetrofitApi = retrofit.create(UserRetrofitApi.class);
    }
    public static synchronized RetrofitNet getInstance(){
        if (mRetrofitNet==null){
            mRetrofitNet = new RetrofitNet();
        }
        return mRetrofitNet;
    }
}
