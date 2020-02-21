package com.example.day.contract;

/**
 * @ProjectName: My Application4
 * @Package: com.example.day.contract
 * @ClassName: IHomePageContract
 * @Description:契约类，作用是用来管理所有的接口
 *  他把我们V层，P层和M层所需要实现的所有接口统一管理
 *  然后，由我们具体的V层（某个Activity或者某个Fragment）实现其中的V层接口
 *  由我们具体的P层,实现其中的P层接口
 *  由我们具体的M层,实现其中的M层接口
 *  注意：契约类实际上是一个接口，使用interface而不是class!!!!!!!!!!!!!!
 * @Author: deshuai
 * @CreateDate: 2020/2/21 20:31
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/21 20:31
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface IHomePageContract {
    //定义获取成功和失败的方法
    interface iView{
        void onGetBannerCg(String str);
        void onGetBannerSb(String str);

        void onGetListCg(String str);
        void onGetListSb(String str);
    }
    //定义获取数据的方法
    interface IPresenter{
        void getBanner(String url);
        void getList(String url);
    }
    //回调网络数据
    interface IModel{
        void getList(String url,IModelCallBack callBack);
        void getBanner(String url,IModelGetListCallback callback);

        interface  IModelCallBack{
            void onGetBannerSuccess(String str);
            void onGetBannerFailure(String str);
        }
        interface IModelGetListCallback{
            void onGetListSuccess(String str);
            void onGetListFailure(String str);
        }
    }


}
