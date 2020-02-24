package com.bawei.wutenglong20200224.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ProjectName: wutenglong20200224
 * @Package: com.bawei.wutenglong20200224.utils
 * @ClassName: NewUtils
 * @Description: 网络工具类
 * @CreateDate: 2020/2/24 13:15
 * @UpdateUser: 武腾龙
 * @UpdateDate: 2020/2/24 13:15
 */
public class NewUtils {
    private static NewUtils newUtils = new NewUtils();
    private NewUtils(){

    }
    public static NewUtils getInstance(){
        return newUtils;
    }
    Handler handler = new Handler();
    public interface ICllBack{
        void isSuccess(String json);
        void isFilear(String json);
    }
    //网络判断
    public boolean isWL(Context context){

        ConnectivityManager conn = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = conn.getActiveNetworkInfo();
        //判断是否有网
        if (info!=null){
            return true;
        }
        return false;
    }
    //获取网络json
    public void getJson(final String json, final ICllBack iCllBack){
        //使用线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(json);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(5000);
                    conn.setReadTimeout(5000);
                    int responseCode = conn.getResponseCode();
                    if (responseCode==200){
                        InputStream inputStream = conn.getInputStream();
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        StringBuilder stringBuilder = new StringBuilder();
                        while ((len=inputStream.read(bytes))!=-1){
                            String s = new String(bytes, 0, len);
                            stringBuilder.append(s);
                        }
                        inputStream.close();
                        final String s = stringBuilder.toString();
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                iCllBack.isSuccess(s);
                            }
                        });
                    }else {
                        iCllBack.isFilear("加载失败");
                    }
                } catch (final Exception e) {
                    e.printStackTrace();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            iCllBack.isFilear(e.toString());
                        }
                    });
                }
            }
        }).start();
    }
}
