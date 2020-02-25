package com.example.day3.prester;


import com.example.day3.bean.Bean;
import com.example.day3.calear.IHomePageConlaer;
import com.example.day3.model.IHomePageModel;

import java.util.List;

/**

 * @ClassName: IHomePagePerter
 * @Description: java类作用描述
 * @CreateDate: 2020/2/24 13:24
 * @UpdateDate: 2020/2/24 13:24
 */
public class IHomePagePerter implements IHomePageConlaer.IPertenr {
    IHomePageConlaer.IView mView;
    IHomePageModel mModel;
    //创建构造方法
    public IHomePagePerter(IHomePageConlaer.IView view) {
        mView=view;
        mModel=new IHomePageModel();
    }

    @Override
    public void getBanner(String url) {

        mModel.getBanner(url, new IHomePageConlaer.IModel.IHomeICllBack() {
            @Override
            public void onGetSuccess(String str) {
                mView.onGetSuccess(str);
            }

            @Override
            public void onGetFilear(String str) {
                mView.onGetFilear(str);
            }


            @Override
            public void onBanner(List<Bean.ResultsBean.BannerBean> list) {
                mView.onBanner(list);
            }
        });

    }

    @Override
    public void getList(String url) {
        mModel.getListBanner(url, new IHomePageConlaer.IModel.IHomeListICllBack() {
            @Override
            public void onGetSuccess(String str) {
              //  mView.onGetSuccess(str);
            }

            @Override
            public void onGetFilear(String str) {
              //  mView.onGetFilear(str);
            }

            @Override
            public void onListView(List<Bean.ResultsBean.NewsistBean> list) {

                mView.onListView(list);
            }
        });
    }
}
