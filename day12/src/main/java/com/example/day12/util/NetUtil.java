package com.example.day12.util;

/**
 * @ProjectName: My Application4
 * @Package: com.example.day12.util
 * @ClassName: NetUtil
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/3/9 13:21
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/9 13:21
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class NetUtil {
    private static final String TAG = "NetUtil";
    //单例模式
    private static NetUtil netUtil = new NetUtil() ;

    public static NetUtil getNetUtil() {
        netUtil = new NetUtil();
        return NetUtil.netUtil;
    }

}
