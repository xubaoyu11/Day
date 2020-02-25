package com.example.mode2.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.example.mode2.context.App;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * @ProjectName: My Application4
 * @Package: com.example.mode2.util
 * @ClassName: NetUtil
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/2/25 19:46
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/25 19:46
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class NetUtil {
    private static final String TAG = "NetUtil";
    //单例模式
    private static NetUtil netUtil = new NetUtil();
    public NetUtil(){

    }
    public static NetUtil getNetUtil() {
        netUtil = new NetUtil();
        return NetUtil.netUtil;
    }
    //回调接口
    public interface CallBack{
        void onCg(String json);
        void onSb(String msg);
    }
    //定义handler
    private Handler handler = new Handler();
    //判断网络
    public boolean Pd(){
        ConnectivityManager systemService = (ConnectivityManager) App.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = systemService.getActiveNetworkInfo();
        if (activeNetworkInfo!=null){
            boolean available = activeNetworkInfo.isAvailable();
            return available;
        }
        return false;
    }
    //请求数据
    public void doGet(final String path, final Map<String,String>params, final CallBack callBack){
        boolean pd = Pd();
        if (!pd){
            Toast.makeText(App.context, "网络错误", Toast.LENGTH_SHORT).show();
            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(path);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setRequestMethod("POST");
                    //是否使用缓存
                    httpURLConnection.setUseCaches(false);
                    //设置输入
                    httpURLConnection.setDoInput(true);
                    //设置输出
                    httpURLConnection.setDoOutput(true);
                    //拼接中间人
                    StringBuffer stringBuffer = new StringBuffer();
                    //遍历集合
                    for (Map.Entry<String,String> entry : params.entrySet()){
                        String key = entry.getKey();
                        String value = entry.getValue();
                        stringBuffer.append(key+"="+value+"&");
                    }
                    String user = stringBuffer.toString();
                    user = user.substring(0, user.length() - 1);
                    Log.i(TAG, "run: "+user);
                    //获取输出流
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    //转换字节
                    outputStream.write(user.getBytes());
                    outputStream.flush();
                    httpURLConnection.connect();
                    //根基判断码请求
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode==200){
                        InputStream inputStream = httpURLConnection.getInputStream();
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        StringBuffer buffer = new StringBuffer();
                        while ((len = inputStream.read(bytes))!=-1){
                            buffer.append(new String(bytes,0,len));
                        }
                        //关流
                        inputStream.close();
                        outputStream.close();
                        //打印
                        final String json = buffer.toString();
                        Log.i(TAG, "run: "+json);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (callBack!=null){
                                    callBack.onSb(json);
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
