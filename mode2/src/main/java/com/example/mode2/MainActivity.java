package com.example.mode2;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mode2.base.BaseActivity;
import com.example.mode2.bean.UserBean;
import com.example.mode2.contract.HomePageContract;
import com.example.mode2.persenter.HomePagePersenter;
import com.google.gson.Gson;

import java.util.HashMap;

public class MainActivity extends BaseActivity implements HomePageContract.IView{
    private static final String TAG = "MainActivity";
    private android.widget.EditText wdYhm;
    private android.widget.EditText wdMm;
    private android.widget.Button btZc;
    private android.widget.Button btDl;
    private HomePagePersenter homePagePersenter;

    @Override
    public int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        homePagePersenter = new HomePagePersenter((HomePageContract.IView) this);
        wdYhm = (EditText) findViewById(R.id.wd_yhm);
        wdMm = (EditText) findViewById(R.id.wd_mm);
        btZc = (Button) findViewById(R.id.bt_zc);
        btDl = (Button) findViewById(R.id.bt_dl);
    }

    @Override
    public void initLister() {
        btZc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://mobile.bwstudent.com/small/user/v1/register";
                //获取用户输入的账号密码
                String phone = wdYhm.getText().toString();
                String pwd = wdMm.getText().toString();
                //存入Map集合
                HashMap<String, String> map = new HashMap<>();
                map.put("phone",phone);
                map.put("pwd",pwd);
                //调用网络工具类
                homePagePersenter.userRegAndLog(url,map);
            }
        });
        btDl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://mobile.bwstudent.com/small/user/v1/login";
                //获取用户输入的账号密码
                String phone = wdYhm.getText().toString();
                String pwd = wdMm.getText().toString();
                //存入map集合
                HashMap<String, String> map = new HashMap<>();
                map.put("phone",phone);
                map.put("pwd",pwd);
                //调用网络工具类
                homePagePersenter.userRegAndLog(url,map);
            }
        });
    }

    @Override
    public void initData() {

    }


    @Override
    public void userRegAndlogCg(String json) {
        Gson gson = new Gson();
        UserBean userBean = gson.fromJson(json, UserBean.class);
        String message = userBean.getMessage();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void userRegAndLogSb(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
