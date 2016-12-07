package com.feicuiedu.retrofitdemo.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.feicuiedu.retrofitdemo.R;
import com.feicuiedu.retrofitdemo.okhttpPost.User;
import com.feicuiedu.retrofitdemo.retrofitGet.RetrofitNet;
import com.feicuiedu.retrofitdemo.retrofitPost.UserResult;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MvpTestActivity extends AppCompatActivity {

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_password)
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http_post);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_register)
    public void onClick() {

        /**
         * 下面这个是网络请求，耗时的操作：业务逻辑
         * 1. 将网络请求分离出去，降低耦合度，减轻Activity的负担
         */
        User user = new User(etName.getText().toString(),etPassword.getText().toString());
        new RegisterPresenter().register(user);
    }
}
