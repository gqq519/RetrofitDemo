package com.feicuiedu.retrofitdemo.retrofitGet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.feicuiedu.retrofitdemo.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitGetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http_get);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_get)
    public void onClick() {
        // 去执行请求
        RetrofitNet.getInstance().mUserRetrofitApi.getData("language:java",1).enqueue(new Callback<ResponseBody>() {

            // 请求成功
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                // 可以做UI的更新
                Toast.makeText(RetrofitGetActivity.this, "onResponse："+response.code(), Toast.LENGTH_SHORT).show();
            }

            // 请求失败
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(RetrofitGetActivity.this, "onFailure:"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
