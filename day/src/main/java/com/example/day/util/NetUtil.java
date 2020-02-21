package com.example.day.util;

import android.os.Handler;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ProjectName: My Application4
 * @Package: com.example.day.util
 * @ClassName: NetUtil
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/2/21 20:17
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/21 20:17
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class NetUtil {
    private static final String TAG = "NetUtil";
    //单例模式
    public static NetUtil netUtil = new NetUtil();
    private NetUtil(){}

    public static NetUtil getNetUtil() {
        return netUtil;
    }
    //创建handler
    private Handler handler = new Handler();
    //接口定义成功与失败
    public interface CallBack{
        void onCg(String json);
        void onSb(String msg);
    }
    //加载json数据
    public void getJson(final String path, final CallBack callBack){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(path);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode==200){
                        InputStream inputStream = httpURLConnection.getInputStream();
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        StringBuffer stringBuffer = new StringBuffer();
                        while ((len = inputStream.read(bytes))!=-1){
                            stringBuffer.append(new String(bytes,0,len));
                        }
                        final String json = stringBuffer.toString();
                        //关流
                        inputStream.close();
                        //打印json
                        Log.i(TAG, "run: "+json);
                        //切换线程
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                //判断网络
                                if (callBack!=null){
                                    callBack.onCg(json);
                                }
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
