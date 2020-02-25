package com.example.mode2.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @ProjectName: My Application4
 * @Package: com.example.mode2.base
 * @ClassName: BaseActivity
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/2/25 20:35
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/25 20:35
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int i = initLayoutId();
        setContentView(i);
        initView();
        initLister();
        initData();
    }
    public abstract int initLayoutId();
    public abstract void initView();
    public abstract void initLister();
    public abstract void initData();
}
