package com.example.day13.base;

import android.app.Application;
import android.content.Context;

/**
 * @ProjectName: My Application4
 * @Package: com.example.day13.base
 * @ClassName: App
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/3/12 19:22
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/12 19:22
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class App extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
