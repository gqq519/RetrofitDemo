package com.feicuiedu.retrofitdemo.mvpdemo;

import com.feicuiedu.retrofitdemo.okhttpPost.User;
import com.feicuiedu.retrofitdemo.retrofitGet.RetrofitNet;
import com.feicuiedu.retrofitdemo.retrofitPost.UserResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/12/7 0007.
 */
// 目的：业务类
public class RegisterPresenter {

    // 对外提供一个方法，完成网络请求实现
    public void register(User user) {

        RetrofitNet.getInstance().mUserRetrofitApi.register(user).enqueue(new Callback<UserResult>() {

            @Override
            public void onResponse(Call<UserResult> call, Response<UserResult> response) {
                if (response.isSuccessful()) {
                    UserResult result = response.body();
                    if (result == null) {
                        // 弹个吐丝，说明：请求数据发生了未知的错误
                        return;
                    }
                    if (result.getCode() == 1) {
                        // 真正的注册成功了
                        // 弹个吐丝，跳转页面
                    }
                }
            }

            @Override
            public void onFailure(Call<UserResult> call, Throwable t) {
                // 弹个土司说明请求失败了
            }
        });
    }
}
