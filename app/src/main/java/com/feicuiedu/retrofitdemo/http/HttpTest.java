package com.feicuiedu.retrofitdemo.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * Created by gqq on 2016/12/2.
 */

public class HttpTest {

    private void netTest() throws IOException {

        /**
         * 请求
         * 1. 有一个去执行请求的操作类Client类
         * 2. 构建一个请求
         * 3. 执行请求
         */

//        HttpClient httpClient = new DefaultHttpClient();
//
//        HttpGet httpGet = new HttpGet();
//        httpGet.setURI(URI.create("www.baidu.com....."));
//        httpGet.addHeader("Accept-type","json");
//        httpGet.addHeader("...","....");
//        //.........
//        // 请求体：GET请求不需要传入请求体
//        HttpResponse response = httpClient.execute(httpGet);
//        /**
//         * 响应
//         * 1. 拿到响应的消息
//         * 2. 分别拿到响应的数据
//         * 3. 数据展示等
//         */
//        response.getStatusLine().getStatusCode();// 响应码：200
//        Header[] allHeaders = response.getAllHeaders();
//        HttpEntity entity = response.getEntity();
//        InputStream content = entity.getContent();
    }
}
