package com.feicuiedu.retrofitdemo.mvpdemo;

import android.widget.Toast;

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

    private RegisterView registerView;

    /**
     * 在业务实现中会进行视图的更新：比如弹吐丝、ListView展示数据、跳转页面、展示进度条、对话框。。。
     * 1. 分析的在业务实现过程视图的变化
     *      怎么实现视图的操作呢？？在Activity里面写视图视图实现的方法
     *      1. 直接在业务类里面直接调用；强烈不推荐
     *      2. 接口回调
     */
    private interface RegisterView{
        /**
         * 1. 显示进度
         * 2. 隐藏进度
         * 3. 弹吐司
         * 4. 跳转页面
         */
        void showProgress();
        void hideProgress();
        void showMessage(String msg);
        void navigationToMain();
    }

    // 对外提供一个方法，完成网络请求实现
    public void register(User user) {

        registerView.showProgress();

        RetrofitNet.getInstance().mUserRetrofitApi.register(user).enqueue(new Callback<UserResult>() {

            @Override
            public void onResponse(Call<UserResult> call, Response<UserResult> response) {

                registerView.hideProgress();

                if (response.isSuccessful()) {
                    UserResult result = response.body();
                    if (result == null) {
                        // 弹个吐丝，说明：请求数据发生了未知的错误
                        registerView.showMessage("发生了未知的错误！！！！");
                        return;
                    }
                    if (result.getCode() == 1) {
                        // 真正的注册成功了
                        // 弹个吐丝，跳转页面

                        registerView.showMessage("注册成功");

                        registerView.navigationToMain();
                    }
                }
                registerView.showMessage("");
            }

            @Override
            public void onFailure(Call<UserResult> call, Throwable t) {
                // 弹个土司说明请求失败了
                registerView.showMessage("请求失败"+t.getMessage());
            }
        });
    }
}
