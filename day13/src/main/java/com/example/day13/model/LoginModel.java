package com.example.day13.model;

import com.example.day13.contract.ILoginContract;
import com.example.day13.util.VolleyUtil;

import java.util.Map;

/**
 * @ProjectName: My Application4
 * @Package: com.example.day13.model
 * @ClassName: LoginModel
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/3/12 19:57
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/12 19:57
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class LoginModel implements ILoginContract.ILoginMode {
    @Override
    public void doLogin(String url, Map<String, String> map, final ILoginCallBack callBack) {
        VolleyUtil.getInstance().doPost(url, map, new VolleyUtil.CallBack() {
            @Override
            public void onCg(String str) {
                if (callBack!=null){
                    callBack.onCg(str);
                }
            }

            @Override
            public void onSb(String str) {
                if (callBack!=null){
                    callBack.onSb(str);
                }
            }
        });
    }
}
