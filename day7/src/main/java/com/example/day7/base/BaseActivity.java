package com.example.day7.base;

/**
 * @ProjectName: My Application4
 * @Package: com.example.day7.base
 * @ClassName: BaseActivity
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/2/27 22:39
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/27 22:39
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.BaseMenuPresenter;

public abstract class BaseActivity<P extends BaseMenuPresenter> extends AppCompatActivity implements IBaseView{
    P mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layout = getLayout();
        setContentView(layout);
        mPresenter = initPresenter();
        initView();
        initData();
    }
    public P getPresenter(){
        return mPresenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
           // mPresenter.detachView();
            mPresenter=null;
        }
    }
    public abstract P initPresenter();
    public abstract int getLayout();
    public abstract void initView();
    public abstract void initData();
}
