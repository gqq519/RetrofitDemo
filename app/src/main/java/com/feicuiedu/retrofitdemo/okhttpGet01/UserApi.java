package com.feicuiedu.retrofitdemo.okhttpGet01;

import okhttp3.Call;

/**
 * Created by gqq on 2016/12/5.
 */

public interface UserApi {
    // 作用：就是帮我们管理请求

    String URL_GET = "https://api.github.com/search/repositories?q=language:java&page=1";

    /**
     * OkHttp进行GET请求
     * @param url GET请求的地址
     * @return
     */
    Call getData(String url);

}
