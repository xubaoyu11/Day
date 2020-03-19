package com.example.mode3.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.example.mode3.app.App;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @ProjectName: My Application4
 * @Package: com.example.mode3.util
 * @ClassName: NetUtil
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/3/2 13:27
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/2 13:27
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class NetUtil {
    private static final String TAG = "NetUtil";
    //单例模式
    public static NetUtil netUtil = new NetUtil();
    private NetUtil(){}

    public static NetUtil getNetUtil() {
        netUtil = new NetUtil();
        return netUtil;
    }
    //创建handler
    private Handler handler = new Handler();
    //判断
    public boolean Pd(){
        ConnectivityManager systemService = (ConnectivityManager) App.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = systemService.getActiveNetworkInfo();
        if (activeNetworkInfo!=null){
            boolean available = activeNetworkInfo.isAvailable();
            return available;
        }
        return false;
    }
    //json
    public void doGet(final String path, final CallBack callBack){
        boolean pd = Pd();
        if (!pd){
            Toast.makeText(App.context, "无网络", Toast.LENGTH_SHORT).show();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(path);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode==200){
                        InputStream inputStream = httpURLConnection.getInputStream();
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        StringBuffer buffer = new StringBuffer();
                        while ((len = inputStream.read(bytes))!=-1){
                            buffer.append(inputStream.read(bytes));
                        }
                        final String json = buffer.toString();
                        Log.i(TAG, "run: "+json);
                        inputStream.close();
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                if (callBack!=null){
                                    callBack.onCg(json);
                                }
                            }
                        });
                    }
                } catch (final Exception e) {
                    e.printStackTrace();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (callBack!=null){
                                callBack.onSb(e.toString());
                            }
                        }
                    });
                }
            }
        }).start();
    }

    private interface CallBack{
        void onCg(String json);
        void onSb(String msg);
    }
}
