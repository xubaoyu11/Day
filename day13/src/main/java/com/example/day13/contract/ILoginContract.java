package com.example.day13.contract;

import com.example.day13.base.BaseView;

import java.util.Map;

/**
 * @ProjectName: My Application4
 * @Package: com.example.day13.contract
 * @ClassName: ILoginContract
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/3/12 19:48
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/12 19:48
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface ILoginContract {
    //V层
    interface  ILoginView extends BaseView{
        void onCg(String str);
        void onSb(String str);
    }
    //P层
    interface ILoginPresenter{
        void doLogin(String url, Map<String,String>map);
    }
    //M层
    interface ILoginMode{
        void doLogin(String url, Map<String,String>map, ILoginCallBack callBack);
        interface ILoginCallBack{
            void onCg(String str);
            void onSb(String str);
        }
    }
}
