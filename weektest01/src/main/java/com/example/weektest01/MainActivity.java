package com.example.weektest01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.weektest01.base.BaseActivity;
import com.example.weektest01.util.NetUtil;
import com.qy.xlistview.XListView;


public class MainActivity extends BaseActivity {


    private com.qy.xlistview.XListView xlistview;
    private androidx.viewpager.widget.ViewPager vp;

    @Override
    protected int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        xlistview = (XListView) findViewById(R.id.xlistview);
        vp = (ViewPager) findViewById(R.id.vp);
    }

    @Override
    protected void initData() {
        NetUtil netUtil = new NetUtil();
        

    }
}
