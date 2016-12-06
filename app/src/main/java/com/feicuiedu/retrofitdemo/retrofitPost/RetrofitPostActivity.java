package com.feicuiedu.retrofitdemo.retrofitPost;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.feicuiedu.retrofitdemo.R;
import com.feicuiedu.retrofitdemo.okhttpPost.User;
import com.feicuiedu.retrofitdemo.retrofitGet.RetrofitNet;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitPostActivity extends AppCompatActivity {

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
        // 去进行注册的请求
        User user = new User(mEtName.getText().toString(), mEtPassword.getText().toString());

        RetrofitNet.getInstance().mUserRetrofitApi.register(user).enqueue(new Callback<UserResult>() {
            @Override
            public void onResponse(Call<UserResult> call, Response<UserResult> response) {
                if (response.isSuccessful()) {
                    UserResult userResult = response.body();
                    if (userResult != null) {
                        Toast.makeText(RetrofitPostActivity.this, "请求成功" + userResult.getErrmsg(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<UserResult> call, Throwable t) {
                Toast.makeText(RetrofitPostActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
