package com.example.day3.model;

import android.util.Log;

import com.example.day3.bean.Bean;
import com.example.day3.calear.IHomePageConlaer;
import com.example.day3.utils.NewUtils;
import com.google.gson.Gson;

import java.util.List;

/**
 * @ProjectName: wutenglong20200224
 * @Package: com.bawei.wutenglong20200224.model
 * @ClassName: IHomePageModel
 * @Description: java类作用描述
 * @CreateDate: 2020/2/24 13:24
 * @UpdateDate: 2020/2/24 13:24
 */
public class IHomePageModel implements IHomePageConlaer.IModel {
    @Override
    public void getBanner(String str, final IHomeICllBack iCllBack) {
        //调用网络工具类
        NewUtils.getInstance().getJson(str, new NewUtils.ICllBack() {
            @Override
            public void isSuccess(String json) {
                Log.i("xxx",json);

                Gson gson = new Gson();
                Bean bean = gson.fromJson(json, Bean.class);
                List<Bean.ResultsBean.BannerBean> banner = bean.getResults().get(0).getBanner();
                iCllBack.onBanner(banner);

                iCllBack.onGetSuccess(json);

            }

            @Override
            public void isFilear(String json) {
                iCllBack.onGetFilear(json);
                Log.i("xxx",json);
            }
        });
    }

    //解析列表的
    @Override
    public void getListBanner(String str, final IHomeListICllBack listICllBack) {

        NewUtils.getInstance().getJson(str, new NewUtils.ICllBack() {
            @Override
            public void isSuccess(String json) {
                listICllBack.onGetSuccess(json);
                //解析json文件
                Gson gson = new Gson();
                Bean bean = gson.fromJson(json, Bean.class);
                List<Bean.ResultsBean.NewsistBean> newsist = bean.getResults().get(0).getNewsist();
                //调用契约类定义好的接口
                listICllBack.onListView(newsist);
            }

            @Override
            public void isFilear(String json) {
                listICllBack.onGetFilear(json);
            }
        });
    }
}
