package com.feicuiedu.retrofitdemo.okHttpGet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.feicuiedu.retrofitdemo.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpGetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http_get);
        Button button = (Button) findViewById(R.id.btn_get);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**
                 * 使用OkHttp进行请求
                 * 1. 添加依赖：Okhttp3
                 * 2. 初始化OkhttpClient:建议单例
                 * 3. 构建请求：GET请求，POST请求
                 * 4. 执行请求：同步请求和异步回调
                 */
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder()
                        .get()
                        .url("http://www.baidu.com")
                        .header("X-Type","json")
                        .header("X-abc","abc")
                        .build();

                okHttpClient.newCall(request).enqueue(new Callback() {

                    // 请求失败
                    @Override
                    public void onFailure(Call call, IOException e) {
                        // 注意：这是后台线程，不能做UI的操作
                        Log.d("OkHttp","onFailure 连接失败 " + e.getMessage());
                    }

                    // 请求成功
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        // 注意：这是后台线程，不能做UI的操作
                        Log.d("OkHttp","onResponse 得到响应,响应码：" + response.code()+"响应信息："+response.body().string());
                    }
                });
            }
        });
    }
}
