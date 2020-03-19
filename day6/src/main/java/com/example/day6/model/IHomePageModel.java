package com.example.day6.model;

import android.util.Log;

import com.example.day6.bean.Bean;
import com.example.day6.conlaer.IHomePageConlaer;
import com.example.day6.util.NetUtil;
import com.google.gson.Gson;

import java.util.List;

/**
 * @ProjectName: My Application4
 * @Package: com.example.day6.model
 * @ClassName: IHomePageModel
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/2/26 20:57
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/26 20:57
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class IHomePageModel implements IHomePageConlaer.IModel {
    private static final String TAG = "IHomePageModel";
    @Override
    public void getBanner(String str, final IHomeICllBack iHomeICllBack) {
        //调用网络工具类
        NetUtil.getNetUtil().doGet(str, new NetUtil.Callback() {
            @Override
            public void onCg(String json) {
                Log.i(TAG, "onCg: "+json);
                Gson gson = new Gson();
                Bean bean = gson.fromJson(json, Bean.class);
                List<Bean.ResultsBean.BannerBean> banner = bean.getResults().get(0).getBanner();
                iHomeICllBack.onBanner(banner);
                iHomeICllBack.onGetCg(json);
            }

            @Override
            public void onSb(String msg) {
                iHomeICllBack.onGetSb(msg);
                Log.i(TAG, "onSb: "+msg);
            }
        });
    }

    @Override
    public void getListBanner(String str, final IHomeListICllBack iHomeListICllBack) {
        NetUtil.getNetUtil().doGet(str, new NetUtil.Callback() {
            @Override
            public void onCg(String json) {
                iHomeListICllBack.onGetCg(json);
                Gson gson = new Gson();
                Bean bean = gson.fromJson(json, Bean.class);
                List<Bean.ResultsBean.NewsistBean> newsist = bean.getResults().get(0).getNewsist();
                iHomeListICllBack.onListView(newsist);
            }

            @Override
            public void onSb(String msg) {
                iHomeListICllBack.onGetSb(msg);
            }
        });
    }
}
