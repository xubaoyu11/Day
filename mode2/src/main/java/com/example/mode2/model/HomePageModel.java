package com.example.mode2.model;

import com.example.mode2.contract.HomePageContract;
import com.example.mode2.util.NetUtil;

import java.util.Map;

/**
 * @ProjectName: My Application4
 * @Package: com.example.mode2.model
 * @ClassName: HomePageModel
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/2/25 20:44
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/25 20:44
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class HomePageModel implements HomePageContract.IModel {
    @Override
    public void userRegAndLog(String url, Map<String, String> map, final CallBacks callBacks) {
        NetUtil.getNetUtil().doGet(url, map, new NetUtil.CallBack() {
            @Override
            public void onCg(String json) {
                callBacks.userRegAndLogCg(json);
            }

            @Override
            public void onSb(String msg) {
                callBacks.userRegAndLodSb(msg);
            }
        });
    }
}
