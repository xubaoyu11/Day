package com.example.day8;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.day8.base.BaseActivity;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;


public class MainActivity extends BaseActivity {


    private android.widget.TextView text;
    private com.stx.xhb.xbanner.XBanner xb;
    private android.widget.ListView listview;

    @Override
    protected int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        text = (TextView) findViewById(R.id.text);
        xb = (XBanner) findViewById(R.id.xb);
        listview = (ListView) findViewById(R.id.listview);
    }

    @Override
    protected void initList() {

    }

    @Override
    protected void initData() {
        listview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gson gson = new Gson();
                
            }
        });
    }
}
