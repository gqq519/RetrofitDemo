package com.feicuiedu.retrofitdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.feicuiedu.retrofitdemo.okHttpGet.OkHttpGetActivity;
import com.feicuiedu.retrofitdemo.okhttpGet01.OkHttpGet2Activity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.okhttpGET, R.id.okhttpPOST,R.id.okhttpGET1})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.okhttpGET:
                startActivity(new Intent(MainActivity.this, OkHttpGetActivity.class));
                break;
            case R.id.okhttpGET1:
                startActivity(new Intent(MainActivity.this, OkHttpGet2Activity.class));
                break;
            case R.id.okhttpPOST:
                break;
        }
    }
}
