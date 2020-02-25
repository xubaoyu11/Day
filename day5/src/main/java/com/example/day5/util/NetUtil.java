package com.example.day5.util;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.day5.app.App;

import java.util.Map;

/**
 * @ProjectName: My Application4
 * @Package: com.example.day5.util
 * @ClassName: NetUtil
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/2/25 15:54
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/25 15:54
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class NetUtil {
    private RequestQueue requestQueue;
    //单例模式，使用双重校验锁
    private static NetUtil instance;

    private NetUtil(){
        requestQueue = Volley.newRequestQueue(App.getContext());
    }

    public static NetUtil getInstance() {
        //双重校验锁第一重判断
        if (instance==null)
        {//第二重判断
            synchronized (NetUtil.class)
            {
                //双重校验锁是为了解决多线程并发的安全问题
                if (instance==null)
                {
                    instance=new NetUtil();
                }

            }
        }
        return instance;
    }
    //设置一个工具类的get请求方式，用于搜索
    public void doGet(String url, final VolleyCallback volleyCallback){
        StringRequest stringRequest=new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                volleyCallback.success(response);
            }
        }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                volleyCallback.failure(error);
            }
        });
        //添加消息队列
        requestQueue.add(stringRequest);
    }
    //设置工具类的post请求方式，用于登录以及注册
    public void doPost(String url, final VolleyCallback volleyCallback, final Map<String,String> parms)
    {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                volleyCallback.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyCallback.failure(error);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return parms;
            }
        };
        //添加消息队列
        requestQueue.add(stringRequest);
    }
    //定义一个接口
    public interface VolleyCallback {
        //设置一个成功时调用的方法
        void success(String response);
        //设置一个失败时调用的方法
        void failure(Throwable throwable);
    }
}

