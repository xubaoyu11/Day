package com.example.day8.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @ProjectName: My Application4
 * @Package: com.example.day8.base
 * @ClassName: BaseActivity
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/2/28 16:52
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/28 16:52
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
        initList();
        initData();
    }
    protected abstract int initLayoutId();
    protected abstract void initView();
    protected abstract void initList();
    protected abstract void initData();
}
