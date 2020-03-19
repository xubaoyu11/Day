package com.example.day6.prester;

import com.example.day6.bean.Bean;
import com.example.day6.conlaer.IHomePageConlaer;
import com.example.day6.model.IHomePageModel;

import java.util.List;

/**
 * @ProjectName: My Application4
 * @Package: com.example.day6.prester
 * @ClassName: IHomePagePerter
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/2/26 20:55
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/26 20:55
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class IHomePagePerter implements IHomePageConlaer.IPertenr {
    IHomePageConlaer.IView iView;
    IHomePageModel model;


    //创建构造方法
    public IHomePagePerter(IHomePageConlaer.IView view){
        iView = view;
        model = new IHomePageModel();
    }
    @Override
    public void getBanner(String url) {
        model.getBanner(url, new IHomePageConlaer.IModel.IHomeICllBack() {
            @Override
            public void onGetCg(String str) {
                iView.onGetCg(str);
            }

            @Override
            public void onGetSb(String str) {
                iView.onGetSb(str);
            }

            @Override
            public void onBanner(List<Bean.ResultsBean.BannerBean> list) {
                iView.onBanner(list);
            }
        });
    }

    @Override
    public void getList(String url) {
        model.getListBanner(url, new IHomePageConlaer.IModel.IHomeListICllBack() {
            @Override
            public void onGetCg(String str) {

            }

            @Override
            public void onGetSb(String str) {

            }

            @Override
            public void onListView(List<Bean.ResultsBean.NewsistBean> list) {
                iView.onListView(list);
            }
        });
    }
}
