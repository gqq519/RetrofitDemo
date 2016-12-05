package com.feicuiedu.retrofitdemo.okhttpGet01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.feicuiedu.retrofitdemo.R;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttpGet2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http_get);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_get)
    public void onClick() {
        // 去进行请求
        OkHttpNetClient.getInstance().getData(UserApi.URL_GET).enqueue(new Callback() {

            // 请求失败
            @Override
            public void onFailure(Call call, IOException e) {
                Log.w("TAG","请求失败了"+e.getMessage());
            }

            // 请求成功
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.w("TAG","请求成功"+response.body().contentLength());

                if (response.isSuccessful()&&response.code()==200){
                    String json = response.body().string();
//                    Gson gson = new Gson();
                    /**
                     * 利用Json解析得到相应的结果，比如实体类、集合
                     */
                }
            }
        });
    }
}
