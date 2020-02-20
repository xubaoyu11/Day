package com.example.mode1.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Trace;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @ProjectName: text1
 * @Package: com.bw.text1.utils
 * @ClassName: NetUtils
 * @Description: (java类作用描述)
 * @Author: 续宝玉
 * @CreateDate: 2020/2/11 16:55
 */
public class NetUtils  {

    private static NetUtils netUtils = new NetUtils();

    private NetUtils(){

    }
    public static NetUtils getInstance(){
        return  netUtils;
    }
    //判断网络状态
    public boolean isNetWork(Context context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if(info!=null){
            Toast.makeText(context, "网络连接成功", Toast.LENGTH_SHORT).show();
            return  true;
        }else{
            return false;
        }
    }
    //获取图片
    public void getPhoto(final String path, final ImageView iv){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(path);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(5000);
                    conn.setReadTimeout(5000);
                    int responseCode = conn.getResponseCode();
                    if(responseCode==200){
                        InputStream inputStream = conn.getInputStream();
                        final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                        inputStream.close();
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                iv.setImageBitmap(bitmap);
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    //获取json文件
    public void getJson(final String jsonpath, final ICallBack iCallBack){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(jsonpath);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setReadTimeout(5000);
                    conn.setConnectTimeout(5000);
                    int responseCode = conn.getResponseCode();
                    if(responseCode==200){
                        InputStream inputStream = conn.getInputStream();
                        int len = 0;
                        StringBuilder sb = new StringBuilder();
                        byte [] bt = new byte[1024];
                        while((len=inputStream.read(bt))!=-1){
                            String s = new String(bt, 0, len);
                            sb.append(s);
                        }
                        final String json = sb.toString();
                        inputStream.close();
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (iCallBack != null) {
                                    iCallBack.onSuccess(json);
                                }
                            }
                        });
                    }else{
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (iCallBack != null) {
                                    iCallBack.onError("请求失败");
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
    //创建handler
    private Handler handler = new Handler();
    //创建接口回调
    public interface ICallBack{
        void onSuccess(String json);
        void onError(String msg);
    }
}
