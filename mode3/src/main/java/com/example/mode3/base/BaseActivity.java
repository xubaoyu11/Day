package com.example.mode3.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @ProjectName: My Application4
 * @Package: com.example.mode3.base
 * @ClassName: BaseActivity
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/3/2 13:54
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/2 13:54
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int i = initLayoutid();
        setContentView(i);
        initView();
        initList();
        initData();
    }
    protected abstract int initLayoutid();
    protected abstract void initView();
    protected abstract void initList();
    protected abstract void initData();
}
