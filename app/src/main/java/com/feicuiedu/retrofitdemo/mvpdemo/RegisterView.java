package com.feicuiedu.retrofitdemo.mvpdemo;

/**
 * Created by Administrator on 2016/12/7 0007.
 */

public interface RegisterView{
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
