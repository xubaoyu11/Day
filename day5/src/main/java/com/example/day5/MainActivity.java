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

public class MainActivity extends BaseActivyty implements IHomeContract.IView {
    private EditText edit_phone,edit_pass;
    private Button login,zhuce;
    private String phone,pass;
    private String url="";
    private HomePresenter homePresenter;
    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initListener() {
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(MainActivity.this, SecondActivity.class);
                startActivity(it);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone=edit_phone.getText().toString();
                pass=edit_pass.getText().toString();
                url="http://mobile.bwstudent.com/small/user/v1/login?phone="+ URLEncoder.encode(phone) +"&pwd="+URLEncoder.encode(pass);
                homePresenter.getLogin(url);
            }
        });
    }

    @Override
    protected void initData() {
        edit_phone=findViewById(R.id.edit_phone);
        edit_pass=findViewById(R.id.edit_pass);
        login=findViewById(R.id.login);
        zhuce=findViewById(R.id.zhuce);
        homePresenter=new HomePresenter(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    public void success(String response) {
        ZhuceEntity zhuceEntity = new Gson().fromJson(response, ZhuceEntity.class);
        String message = zhuceEntity.getMessage();
        Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
        if (message.equals("登录成功"))
        {
            Intent it=new Intent(MainActivity.this, LoginActivity.class);
            startActivity(it);
        }

    }

    @Override
    public void failur(Throwable throwable) {
        Toast.makeText(this, "错误", Toast.LENGTH_SHORT).show();
    }
}
