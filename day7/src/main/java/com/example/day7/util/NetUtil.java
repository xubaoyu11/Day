package com.example.day7.util;

import android.os.Handler;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @ProjectName: My Application4
 * @Package: com.example.day7.util
 * @ClassName: NetUtil
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/2/27 21:32
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/27 21:32
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class NetUtil {
    private static final String TAG = "NetUtil";
    //单例模式
    public static NetUtil netUtil =new NetUtil();
    private NetUtil(){

    }

    public static NetUtil getNetUtil() {
        return netUtil;
    }
    //创建handler
    private Handler handler = new Handler();

    //加载Json数据
    public void doGet(final String path, final CallBack callBack){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(path);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setRequestMethod("GET");
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode==200){
                        //输入流
                        InputStream inputStream = httpURLConnection.getInputStream();
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        StringBuffer buffer = new StringBuffer();
                        while ((len = inputStream.read(bytes))!=-1){
                            buffer.append(new String(bytes,0,len));
                        }
                        final String json = buffer.toString();
                        Log.i(TAG, "run: "+json);
                        //关流
                        inputStream.close();
                        //切换线程
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
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
    //接口
    public interface CallBack{
        //成功
        void onCg(String json);
        //失败
        void onSb(String msg);
    }
    public void post(String url,CallBack callBack){

    }
}
