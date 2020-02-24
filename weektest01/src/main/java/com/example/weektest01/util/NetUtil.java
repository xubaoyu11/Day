package com.example.weektest01.util;

import com.example.weektest01.app.App;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ProjectName: My Application4
 * @Package: com.example.weektest01.util
 * @ClassName: NetUtil
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/2/24 13:13
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/24 13:13
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class NetUtil {
    private static final String TAG = "NetUtil";
    //单例模式
    public static NetUtil netUtil = new NetUtil();
    public NetUtil (){
    }
    public static NetUtil getNetUtil() {
        netUtil = new NetUtil();
        return NetUtil.netUtil;
    }
    //json
    public void doGet(final String path, final CallBack callBack){

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

                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        while ((len=inputStream.read(bytes))!=-1){
                           outputStream.write(bytes,0,len);
                        }
                        final String json = outputStream.toString();
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
                } catch (Exception e) {
                    e.printStackTrace();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            if (callBack!=null){
                                callBack.onSb("错误");
                            }
                        }
                    });
                }
            }
        }).start();
    }
    //网络
    private void Pd(){

    }
    public interface CallBack{
        void onCg(String json);
        void onSb(String msg);
    }
}
