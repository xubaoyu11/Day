package com.example.day3.calear;

import com.example.day3.bean.Bean;

import java.util.List;

/**
 * @ClassName: IHomePageConlaer
 * @Description: 契约类
 * @CreateDate: 2020/2/24 13:22
 * @UpdateDate: 2020/2/24 13:22
 */
public interface IHomePageConlaer {

    interface IView{
        void onGetSuccess(String str);
        void onGetFilear(String str);
        void onBanner(List<Bean.ResultsBean.BannerBean> list);
        void onListView(List<Bean.ResultsBean.NewsistBean> list);

    }

    interface IPertenr{
        void getBanner(String url);
        void getList(String url);

    }
    interface IModel{
        void getBanner(String str, IHomeICllBack iCllBack);
        interface IHomeICllBack{
            void onGetSuccess(String str);
            void onGetFilear(String str);
            void onBanner(List<Bean.ResultsBean.BannerBean> list);
        }
        void getListBanner(String str, IHomeListICllBack listICllBack);
        interface IHomeListICllBack{
            void onGetSuccess(String str);
            void onGetFilear(String str);
            void onListView(List<Bean.ResultsBean.NewsistBean> list);
        }
    }
}
