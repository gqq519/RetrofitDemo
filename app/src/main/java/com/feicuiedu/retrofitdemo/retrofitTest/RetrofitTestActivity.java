package com.feicuiedu.retrofitdemo.retrofitTest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.feicuiedu.retrofitdemo.R;
import com.feicuiedu.retrofitdemo.retrofitGet.RetrofitNet;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_test);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_mult)
    public void onClick() {
        // 去进行多部分请求

        MultUser user = new MultUser("yt59856b15cf394e7b84a7d48447d16098","xc62","555","123456","0F8EC12223174657B2E842076D54C361");

        RetrofitNet.getInstance().mUserRetrofitApi.getMult(user).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(RetrofitTestActivity.this, "onResponse:"+response.code(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(RetrofitTestActivity.this, "onFailure:"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
