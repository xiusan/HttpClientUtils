package com.apple.http.sample;

import com.apple.http.common.BaseHttpClient;
import com.apple.http.common.BaseParams;
import com.apple.http.common.HttpCallback;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * post 请求数据
 * @author  hushaoping
 */
public class PostActivity extends AppCompatActivity implements HttpCallback,View.OnClickListener{

    TextView txt_content;
    BaseParams mParams;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);
        txt_content= (TextView)findViewById(R.id.txt_content);
        findViewById(R.id.txt_get).setOnClickListener(this);
        initData();
    }

    @Override
    public void onSuccess(String content, Object object, String reqType) {
        txt_content.setText(content+"type==="+reqType);
    }

    @Override
    public void onFailure(Throwable error, String content, String reqType) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txt_get:
                initData();
                break;
        }
    }
    /**
     * 请求数据
     */
    void initData(){
        initParameter();
        mParams.put("os", "2");
        mParams.put("device_id", "123871827312");
        mParams.put("version", "1.1");
        mParams.put("game", "dota");
        BaseHttpClient.getOkClient(getApplicationContext()).sendPostRequest("http://apphttpurl.com/v1", mParams, this);
    }
    /**
     * 初始化参数
     */
    protected  void initParameter(){
        if (mParams == null) {
            mParams = new BaseParams();
        }else {
            mParams.clear();
        }
    }
}
