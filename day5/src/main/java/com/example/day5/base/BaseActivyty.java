package com.example.day5.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/*时间：2020/02/25
* 作者：续宝玉
* 功能：抽调Aactivity的基类，绑定以及解绑视图*/
public abstract class BaseActivyty <P extends BasePresenter> extends AppCompatActivity implements IBaseView{
    public P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        presenter=initPresenter();
        //绑定view
        if (presenter!=null)
        {
            presenter.attach(this);
        }
        initView();
        initData();

        initListener();
    }

    protected abstract int layoutId();

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P initPresenter();
    //解绑视图
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null)
        {
            presenter.dettach();
        }
    }
}
