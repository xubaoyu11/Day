package com.bawei.wutenglong20200224.prester;

import com.bawei.wutenglong20200224.bean.Bean;
import com.bawei.wutenglong20200224.calear.IHomePageConlaer;
import com.bawei.wutenglong20200224.model.IHomePageModel;

import java.util.List;

/**
 * @ProjectName: wutenglong20200224
 * @Package: com.bawei.wutenglong20200224.prester
 * @ClassName: IHomePagePerter
 * @Description: java类作用描述
 * @CreateDate: 2020/2/24 13:24
 * @UpdateUser: 武腾龙
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
