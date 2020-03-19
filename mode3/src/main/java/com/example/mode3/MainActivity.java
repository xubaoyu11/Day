package com.example.mode3;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mode3.base.BaseActivity;
import com.stx.xhb.xbanner.XBanner;


public class MainActivity extends BaseActivity {


    private android.widget.ImageView image;
    private android.widget.TextView text;
    private com.stx.xhb.xbanner.XBanner xb;
    private android.widget.ListView listview;

    @Override
    protected int initLayoutid() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        image = (ImageView) findViewById(R.id.image);
        text = (TextView) findViewById(R.id.text);
        xb = (XBanner) findViewById(R.id.xb);
        listview = (ListView) findViewById(R.id.listview);
    }

    @Override
    protected void initList() {

    }

    @Override
    protected void initData() {
        final String path = "http://blog.zhaoliang5156.cn/api/shop/jingdong.json";
//        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Gson gson = new Gson();
//                UserBean userBean = gson.fromJson(path, UserBean.class);
//                List<UserBean.DataBean.VerticalListDataBean> verticalListData = userBean.getData().getVerticalListData();
//                UserAdapter userAdapter = new UserAdapter(verticalListData);
//                listview.setAdapter(userAdapter);
//            }
//        });
    }
}
