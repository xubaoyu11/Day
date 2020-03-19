package com.example.day13.presenter;

import com.example.day13.base.BasePresenter;
import com.example.day13.base.BaseView;
import com.example.day13.contract.ILoginContract;
import com.example.day13.model.LoginModel;

import java.util.Map;

/**
 * @ProjectName: My Application4
 * @Package: com.example.day13.presenter
 * @ClassName: LoginPresenter
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/3/12 19:56
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/12 19:56
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class LoginPresenter extends BasePresenter implements ILoginContract.ILoginPresenter{
    private LoginModel model;
    public LoginPresenter(BaseView baseView) {
        super(baseView);
    }

    @Override
    protected void initModel() {
        model = new LoginModel();
    }

    @Override
    public void doLogin(String url, Map<String, String> map) {
        model.doLogin(url, map, new ILoginContract.ILoginMode.ILoginCallBack() {
            @Override
            public void onCg(String str) {
                BaseView baseView = getView();
                if (baseView instanceof  ILoginContract.ILoginView){
                    ILoginContract.ILoginView loginView = (ILoginContract.ILoginView) baseView;
                    loginView.onCg(str);
                }
            }

            @Override
            public void onSb(String str) {
                BaseView baseView = getView();
                if (baseView instanceof  ILoginContract.ILoginView){
                    ILoginContract.ILoginView loginView = (ILoginContract.ILoginView) baseView;
                    loginView.onSb(str);
                }
            }
        });
    }
}
