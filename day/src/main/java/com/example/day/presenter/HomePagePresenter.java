package com.example.day.presenter;

import com.example.day.contract.IHomePageContract;
import com.example.day.model.HomePageModel;

/**
 * @ProjectName: My Application4
 * @Package: com.example.day.presenter
 * @ClassName: HomePagePresenter
 * @Description: 通常情况下，一个页面对应一个Presenter
 * 这一个Presenter里面包含当前页面下所有的接口
 *  实现契约类中p层接口，重写方法
 * @Author: deshuai
 * @CreateDate: 2020/2/21 20:55
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/21 20:55
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class HomePagePresenter implements IHomePageContract.IPresenter {
    //这里我们需要把传入的v层保存成成员变量
    IHomePageContract.iView mView;
    private final HomePageModel homePageMode;

    public HomePagePresenter(IHomePageContract.iView view){
        mView = view;
        homePageMode = new HomePageModel();
    }
    @Override
    public void getBanner(String url) {
        homePageMode.getBanner(url, new IHomePageContract.IModel.IModelGetListCallback() {
            @Override
            public void onGetListSuccess(String str) {
                mView.onGetBannerCg(str);
            }

            @Override
            public void onGetListFailure(String str) {
                mView.onGetBannerSb(str);
            }
        });
    }

    @Override
    public void getList(String url) {
        homePageMode.getList(url, new IHomePageContract.IModel.IModelCallBack() {
            @Override
            public void onGetBannerSuccess(String str) {
                mView.onGetListCg(str);
            }

            @Override
            public void onGetBannerFailure(String str) {
                mView.onGetListSb(str);
            }
        });
    }
}
