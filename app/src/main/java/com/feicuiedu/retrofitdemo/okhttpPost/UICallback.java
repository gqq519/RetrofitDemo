package com.feicuiedu.retrofitdemo.okhttpPost;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public abstract class UICallback implements Callback {

    // 获得主线程的Handler
    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public void onFailure(final Call call, final IOException e) {
        // 后台线程
        handler.post(new Runnable() {
            @Override
            public void run() {
                // 运行在主线程，可以在这里更新UI
                onFailureInUI(call, e);
            }
        });
    }

    @Override
    public void onResponse(final Call call, final Response response) throws IOException {
        // 后台线程
        handler.post(new Runnable() {
            @Override
            public void run() {
                // 运行在主线程，可以在这里更新UI
                onResponseInUI(call, response);
            }
        });
    }

    // 子类必须重写的两个方法，必须重写，所以定义成抽象方法。
    public abstract void onFailureInUI(Call call, IOException e);

    public abstract void onResponseInUI(Call call, Response response);
}
