package com.example.day13.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @ProjectName: My Application4
 * @Package: com.example.day13.base
 * @ClassName: BaseActivity
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/3/12 21:05
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/12 21:05
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public abstract class BaseActivity <P extends BasePresenter> extends AppCompatActivity {
   P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        initView();
        mPresenter = initPresenter();
        initData();
    }
    public P getmPresenter(){
        return mPresenter;
    }

    protected abstract int initLayout();
    protected abstract void initView();
    protected abstract P initPresenter();
    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.detachView();
            mPresenter = null;
        }
    }
}
