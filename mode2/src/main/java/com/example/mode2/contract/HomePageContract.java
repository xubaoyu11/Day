package com.example.mode2.contract;

import java.util.Map;

/**
 * @ProjectName: My Application4
 * @Package: com.example.mode2.contract
 * @ClassName: HomePageContract
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/2/25 20:27
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/25 20:27
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface HomePageContract {
    //m层接口
    interface IModel{
        //获取数据的方法
        void userRegAndLog(String url, Map<String,String>map,CallBacks callBacks);
            interface CallBacks{
                void userRegAndLogCg(String json);
                void userRegAndLodSb(String msg);
        }
    }
    //v层接口
    interface IView{
        //返回数据
        void userRegAndlogCg(String json);
        void userRegAndLogSb(String msg);
    }
    //p层接口
    interface IPersenter{
        void userRegAndLog(String url,Map<String,String> map);
    }
}
