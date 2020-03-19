package com.example.day8.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.example.day8.app.App;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @ProjectName: My Application4
 * @Package: com.example.day8.util
 * @ClassName: NetUtil
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/2/28 16:43
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/28 16:43
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class NetUtil {
    private static final String TAG = "NetUtil";
    //单例模式
    public static NetUtil netUtil = new NetUtil();
    public NetUtil(){}

    public static NetUtil getNetUtil() {
        netUtil = new NetUtil();
        return netUtil;
    }
    //网络判断
    public boolean Pd(){
        ConnectivityManager systemService = (ConnectivityManager) App.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = systemService.getActiveNetworkInfo();
        if (activeNetworkInfo!=null){
            boolean available = activeNetworkInfo.isAvailable();
            return available;
        }
        return false;
    }
    //创建Handler
    public static Handler handler = new Handler();
    public interface CallBack{
        void onCg(String json);
        void onSb(String msg);
    }
    //json
    public void doGet(final String path, final CallBack callBack){
        boolean pd = Pd();
        if (!pd){
            Toast.makeText(App.context, "网络异常", Toast.LENGTH_SHORT).show();
        }
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
                            buffer.append(inputStream.read(bytes,0,len));

                        }
                        final String json = buffer.toString();
                        Log.i(TAG, "run: "+json);
                        inputStream.close();
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                callBack.onCg(json);
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
}
