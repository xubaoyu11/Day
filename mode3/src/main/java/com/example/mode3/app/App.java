package com.example.mode3.app;

import android.app.Application;
import android.content.Context;

/**
 * @ProjectName: My Application4
 * @Package: com.example.mode3.app
 * @ClassName: App
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/3/2 13:24
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/2 13:24
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class App extends Application {
    public static Context context;

    public Context getContext() {
        context = this;
        return context;
    }
}
