package com.example.day6.conlaer;

import com.example.day6.bean.Bean;

import java.util.List;

/**
 * @ProjectName: My Application4
 * @Package: com.example.day6.conlaer
 * @ClassName: IHomePageConlaer
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/2/26 19:49
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/26 19:49
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface IHomePageConlaer {
    interface IView{
        void onGetCg(String str);
        void onGetSb(String str);
        void onBanner(List<Bean.ResultsBean.BannerBean> list);
        void onListView(List<Bean.ResultsBean.NewsistBean> list);
    }
    interface IPertenr{
        void getBanner(String url);
        void getList(String url);
    }
    interface IModel{
        void getBanner(String str,IHomeICllBack iHomeICllBack);
        interface IHomeICllBack{
            void onGetCg(String str);
            void onGetSb(String str);
            void onBanner(List<Bean.ResultsBean.BannerBean> list);
        }
        void getListBanner(String str,IHomeListICllBack iHomeListICllBack);
        interface IHomeListICllBack{
            void onGetCg(String str);
            void onGetSb(String str);
            void onListView(List<Bean.ResultsBean.NewsistBean> list);
        }
    }
}
