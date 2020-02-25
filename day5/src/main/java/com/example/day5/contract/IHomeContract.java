package com.example.day5.contract;


import com.example.day5.base.BaseModel;
import com.example.day5.base.IBaseView;

public interface IHomeContract {
    interface IModel extends BaseModel {
        void getZhuce(String url, IModelCallback iModelCallback);
        void getLogin(String url, IModelCallback iModelCallback);
        void getRecycle(String url, IModelCallback iModelCallback);
        interface IModelCallback{
            void success(String response);
            void failur(Throwable throwable);
        }
    }
    interface IView extends IBaseView {
        void success(String response);
        void failur(Throwable throwable);
    }
    interface IPresenter{
        void getZhuce(String url);
        void getLogin(String url);
        void getRecycle(String url);
    }
}
