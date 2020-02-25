package com.example.day5.presenter;

import com.example.day5.base.BasePresenter;
import com.example.day5.contract.IHomeContract;
import com.example.day5.model.HomeModel;

public class HomePresenter extends BasePresenter<HomeModel, IHomeContract.IView> implements IHomeContract.IPresenter {
    private HomeModel homeModel;
    private IHomeContract.IView iView;

    public HomePresenter( IHomeContract.IView iView) {
        this.iView = iView;
    }

    @Override
    protected HomeModel initModel() {
        return new HomeModel();
    }

    @Override
    public void getZhuce(String url) {

        initModel().getZhuce(url, new IHomeContract.IModel.IModelCallback() {
            @Override
            public void success(String response) {
                iView.success(response);
            }

            @Override
            public void failur(Throwable throwable) {
                iView.failur(throwable);
            }
        });
    }

    @Override
    public void getLogin(String url) {
        initModel().getLogin(url, new IHomeContract.IModel.IModelCallback() {
            @Override
            public void success(String response) {
                iView.success(response);
            }

            @Override
            public void failur(Throwable throwable) {
                iView.failur(throwable);
            }
        });
    }

    @Override
    public void getRecycle(String url) {
        initModel().getRecycle(url, new IHomeContract.IModel.IModelCallback() {
            @Override
            public void success(String response) {
                iView.success(response);
            }

            @Override
            public void failur(Throwable throwable) {
                iView.failur(throwable);
            }
        });
    }
}
