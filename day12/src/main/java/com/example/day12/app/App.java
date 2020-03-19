package com.example.day12.app;

import android.app.Application;
import android.content.Context;

/**
 * @ProjectName: My Application4
 * @Package: com.example.day12.app
 * @ClassName: App
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/3/9 13:19
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/9 13:19
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class App extends Application {
    private  Context context;

    public  Context getContext() {
        context = this;
        return context;
    }
}
