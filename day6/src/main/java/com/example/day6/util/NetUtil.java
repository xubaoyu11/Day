package com.example.day6.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @ProjectName: My Application4
 * @Package: com.example.day6.util
 * @ClassName: NetUtil
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/2/26 16:53
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/26 16:53
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class NetUtil {
    private static final String TAG = "NetUtil";
    //单例模式
    public static NetUtil netUtil = new NetUtil();
    private NetUtil(){

    }

    public static NetUtil getNetUtil() {
        return netUtil;
    }
    //获取网络数据
    public void doGet(final String path, final Callback callback){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(path);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode==200){
                        InputStream inputStream = httpURLConnection.getInputStream();
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        StringBuffer buffer = new StringBuffer();
                        while ((len = inputStream.read(bytes))!=-1){
                            String s = new String(bytes, 0, len);
                            buffer.append(s);
                        }
                        //关流
                        inputStream.close();
                        final String json = buffer.toString();
                        Log.i(TAG, "run: "+json);
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                if (callback!=null){
                                    callback.onCg(json);
                                }
                            }
                        });
                    }else {
                        callback.onSb("加载失败");
                    }
                } catch (final Exception e) {
                    e.printStackTrace();
                     handler.post(new Runnable() {
                         @Override
                         public void run() {
                            callback.onSb(e.toString());
                         }
                     });
                }
            }
        }).start();
    }
    //定义handler
    Handler handler = new Handler();
    //网络判断
    public boolean Pd(Context context){
        ConnectivityManager systemService = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = systemService.getActiveNetworkInfo();
        if (activeNetworkInfo!=null){
            boolean available = activeNetworkInfo.isAvailable();
            return available;
        }
        return false;
    }
    //创建callback
    public interface Callback{
        void onCg(String json);
        void onSb(String msg);
    }
}
