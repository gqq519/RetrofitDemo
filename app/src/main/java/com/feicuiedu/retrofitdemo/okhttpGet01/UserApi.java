package com.feicuiedu.retrofitdemo.okhttpGet01;

import com.feicuiedu.retrofitdemo.okhttpPost.User;

import okhttp3.Call;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

/**
 * Created by gqq on 2016/12/5.
 */

public interface UserApi {
    // 作用：就是帮我们管理请求

    String URL_GET = "https://api.github.com/search/repositories?q=language:java&page=1";

    String URL_POST = "http://admin.syfeicuiedu.com/Handler/UserHandler.ashx?action=register";

    /**
     * OkHttp进行GET请求
     * @param url GET请求的地址
     * @return
     */
    Call getData(String url);

    /**
     * 进行Okhttp 的POST请求
     * @param url
     * @return
     */
    Call register(String url, User user);

//    @GET("www.baidu.com")
//    Call<ResponseBody> getA();

}
