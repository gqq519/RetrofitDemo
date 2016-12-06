package com.feicuiedu.retrofitdemo.retrofitGet;

import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by gqq on 2016/12/6.
 */
// 通过注解构建请求
public interface UserRetrofitApi {
    /**
     * Retrofit使用：需要创建一个接口，构建请求，通过Retrofit的Create方法
     */

//    Request request = new Request.Builder()
//            .url(url)
//            .get()
//            .build();

    @GET("https://api.github.com/search/repositories?q=language:java&page=1")
    Call<ResponseBody> getData();

}
