package com.example.day13.activity;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.day13.R;
import com.example.day13.base.BaseActivity;
import com.example.day13.base.BasePresenter;
import com.example.day13.bean.LoginBean;
import com.example.day13.contract.ILoginContract;
import com.example.day13.presenter.LoginPresenter;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends BaseActivity implements ILoginContract.ILoginView {
    private EditText mEt_phone,mEt_pwd;
    private Button mBtn_login;
    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

        mEt_phone = (EditText) findViewById(R.id.et_phone);
        mEt_pwd = (EditText) findViewById(R.id.et_pwd);
        mBtn_login = (Button) findViewById(R.id.btn_login);
        mBtn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BasePresenter basePresenter = getmPresenter();
                if (basePresenter instanceof LoginPresenter){
                    String phone=mEt_phone.getText().toString();
                    String pwd = mEt_pwd.getText().toString();
                    if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(pwd)){
                        return;
                    }
                    Map<String,String> map = new HashMap<>();
                    map.put("phone",phone);
                    map.put("pwd",pwd);
                    LoginPresenter loginPresenter = (LoginPresenter) basePresenter;
                    loginPresenter.doLogin("http://mobile.bwstudent.com/small/user/v1/login",
                            map);
                }
            }
        });
    }

    @Override
    protected BasePresenter initPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onCg(String str) {
        Gson gson = new Gson();
        LoginBean loginBean = gson.fromJson(str, LoginBean.class);
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo",MODE_PRIVATE);
        sharedPreferences
                .edit()
                .putString("userId",loginBean.getResult().getUserId())
                .putString("sessionId",loginBean.getResult().getSessionId())
                .commit();
    }

    @Override
    public void onSb(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
