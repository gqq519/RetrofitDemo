package com.feicuiedu.retrofitdemo.okhttpPost;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import com.feicuiedu.retrofitdemo.R;
import com.feicuiedu.retrofitdemo.okhttpGet01.OkHttpNetClient;
import com.feicuiedu.retrofitdemo.okhttpGet01.UserApi;
import com.google.gson.Gson;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class OkHttpPostActivity extends AppCompatActivity {

    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.et_password)
    EditText mEtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http_post);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_register)
    public void onClick() {
        // 去进行请求：根据用户名和密码进行注册
        /**
         * 1. 构建注册请求
         *      1. 创建一个实体类，通过Gson将实体类转换成json字符串：原因就是需要传入的json字符串
         * 2. 进行请求
         *
         */
        User user = new User(mEtName.getText().toString(),mEtPassword.getText().toString());

        OkHttpNetClient.getInstance().register(UserApi.URL_POST,user).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG","请求失败"+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("TAG","请求成功"+response.body().string());
                if (response.isSuccessful()&&response.code()==200){
                    String json = response.body().string();
                    // 进行了解析，拿到响应的实体类
                    /**
                     * 想要进行UI的更新：
                     * 1. Handler:自己试着实现一下，自定义一个CallBack,提供两个方法（可以运行在主线程）
                     * 2. 别人封装写好的：Retrofit
                     */
                }
                if (response == null) {

                }
            }
        });
    }
}
