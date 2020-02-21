package com.example.day.model;

import com.example.day.contract.IHomePageContract;
import com.example.day.util.NetUtil;

/**
 * @ProjectName: My Application4
 * @Package: com.example.day.model
 * @ClassName: HomePageModel
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/2/21 20:59
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/21 20:59
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class HomePageModel implements IHomePageContract.IModel {
    @Override
    public void getList(String url, final IModelCallBack callBack) {
        NetUtil.getNetUtil().getJson(url, new NetUtil.CallBack() {
            @Override
            public void onCg(String json) {
                callBack.onGetBannerSuccess(json);
            }

            @Override
            public void onSb(String msg) {
                callBack.onGetBannerFailure(msg);
            }
        });
    }

    @Override
    public void getBanner(String url, final IModelGetListCallback callback) {
        NetUtil.getNetUtil().getJson(url, new NetUtil.CallBack() {
            @Override
            public void onCg(String json) {
                callback.onGetListSuccess(json);
            }

            @Override
            public void onSb(String msg) {
                callback.onGetListFailure(msg);
            }
        });
    }
}
