package com.example.day5;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.day5.base.BaseActivyty;
import com.example.day5.base.BasePresenter;
import com.example.day5.contract.IHomeContract;
import com.example.day5.entity.ZhuceEntity;
import com.example.day5.presenter.HomePresenter;
import com.google.gson.Gson;

import java.net.URLEncoder;

public class SecondActivity extends BaseActivyty implements IHomeContract.IView {
    private EditText ed_phone,ed_pass;
    private String shouji,mima,path;
    private Button but;
    private HomePresenter homePresenter;
    @Override
    protected int layoutId() {
        return R.layout.activity_second;
    }

    @Override
    protected void initListener() {
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            shouji=ed_phone.getText().toString();
            mima=ed_pass.getText().toString();
            path="http://mobile.bwstudent.com/small/user/v1/register?phone="+ URLEncoder.encode(shouji)+"&pwd="+URLEncoder.encode(mima);
            Toast.makeText(SecondActivity.this, ""+path, Toast.LENGTH_SHORT).show();
            homePresenter.getZhuce(path);
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        but=findViewById(R.id.but);
        ed_phone=findViewById(R.id.ed_phone);
        ed_pass=findViewById(R.id.ed_pass);
        homePresenter=new HomePresenter(this);
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    public void success(String response) {
        Toast.makeText(this, ""+response, Toast.LENGTH_SHORT).show();
        ZhuceEntity zhuceEntity = new Gson().fromJson(response, ZhuceEntity.class);
        String message = zhuceEntity.getMessage();
        if (message.equals("注册成功"))
        {
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            Intent it=new Intent(SecondActivity.this, MainActivity.class);
            startActivity(it);
        }
    }

    @Override
    public void failur(Throwable throwable) {
        Toast.makeText(this, ""+throwable, Toast.LENGTH_SHORT).show();
    }
}
