package com.example.weektest01.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weektest01.R;

/**
 * @ProjectName: My Application4
 * @Package: com.example.weektest01.base
 * @ClassName: BaseActivity
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/2/24 13:33
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/24 13:33
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int i = initLayoutId();
        setContentView(i);
        initView();
        initData();
    }
    protected abstract int initLayoutId();
    protected abstract void initView();
    protected abstract void initData();
}
