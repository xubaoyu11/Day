package com.example.mode2.persenter;

import com.example.mode2.contract.HomePageContract;
import com.example.mode2.model.HomePageModel;

import java.util.Map;

/**
 * @ProjectName: My Application4
 * @Package: com.example.mode2.persenter
 * @ClassName: HomePagePersenter
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/2/25 20:42
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/25 20:42
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class HomePagePersenter implements HomePageContract.IPersenter {
    private HomePageContract.IView iView;
    private HomePageModel homePageModel;
    public HomePagePersenter(HomePageContract.IView view){
        iView = view;
        homePageModel = new HomePageModel();
    }
    @Override
    public void userRegAndLog(String url, Map<String, String> map) {
        homePageModel.userRegAndLog(url, map, new HomePageContract.IModel.CallBacks() {
            @Override
            public void userRegAndLogCg(String json) {
                iView.userRegAndlogCg(json);
            }

            @Override
            public void userRegAndLodSb(String msg) {
                iView.userRegAndLogSb(msg);
            }
        });
    }
}
