package com.example.day6;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.day6.adapter.MyAdapter;
import com.example.day6.bean.Bean;
import com.example.day6.conlaer.IHomePageConlaer;
import com.example.day6.prester.IHomePagePerter;
import com.example.day6.util.NetUtil;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;


public class MainActivity extends AppCompatActivity implements IHomePageConlaer.IView {
    private static final String TAG = "MainActivity";

    private XBanner xb;
    private ListView lv;
    private IHomePagePerter iHomePagePerter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xb = findViewById(R.id.xb);
        lv = findViewById(R.id.lv);
        //实例化P层类
        iHomePagePerter = new IHomePagePerter(this);
        //设置接口
        iHomePagePerter.getBanner("http://blog.zhaoliang5156.cn/api/news/news_data.json");
        iHomePagePerter.getList("http://blog.zhaoliang5156.cn/api/news/news_data.json");
    }

    @Override
    public void onGetCg(String str) {
        Log.i(TAG,str);
    }

    @Override
    public void onGetSb(String str) {
        Log.i(TAG,str);
    }

    @Override
    public void onBanner(final List<Bean.ResultsBean.BannerBean> list) {
        boolean pd = NetUtil.getNetUtil().Pd(MainActivity.this);
        if (pd){
            //xbanner设置数据
            xb.setBannerData(list);
            //发送数据
            xb.loadImage(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    Bean.ResultsBean.BannerBean bannerBean = list.get(position);
                    String imageurl = bannerBean.getImageurl();
                    //使用glide依赖
                    Glide.with(MainActivity.this).load(imageurl).into((ImageView) view);
                }
            });
        }else {
            Toast.makeText(this, "网络异常", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onListView(List<Bean.ResultsBean.NewsistBean> list) {
        //创建适配器
        MyAdapter myAdapter = new MyAdapter(MainActivity.this, list);
        //调用适配器
        lv.setAdapter(myAdapter);
    }

}
