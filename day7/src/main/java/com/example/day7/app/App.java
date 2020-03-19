package com.example.day7.app;

import android.app.Application;
import android.content.Context;

/**
 * @ProjectName: My Application4
 * @Package: com.example.day7.app
 * @ClassName: App
 * @Description: 04.创建一个app类，继承Application
 * 05.写一个静态成员变量，记录上下文
 * 06.在onCreate中通过getApplicationContext来给成员变量赋值
 * 07.编写一个静态方法，提供外部调用获取上下文
 * 108.在我们的manifest里面，application下，添加android:name=“该类的路径” ！！！！！
 *  *
 * @Author: deshuai
 * @CreateDate: 2020/2/27 21:50
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/27 21:50
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
    public static Context getAppContext(){
        return context;
    }
}
