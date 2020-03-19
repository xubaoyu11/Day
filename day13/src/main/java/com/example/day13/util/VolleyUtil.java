package com.example.day13.util;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.day13.base.App;

import java.util.Map;

/**
 * @ProjectName: My Application4
 * @Package: com.example.day13.util
 * @ClassName: VolleyUtil
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/3/12 19:15
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/12 19:15
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class VolleyUtil {
    private static final String TAG = "VolleyUtil";
    RequestQueue mrequestQueue;

    //单例模式
    private VolleyUtil(){
        mrequestQueue = Volley.newRequestQueue(App.getContext());
    }
    private static class SingleInstance{
        //静态内部类
        private static final VolleyUtil INSTANCE = new VolleyUtil();
    }
    public static VolleyUtil getInstance(){
        return SingleInstance.INSTANCE;
    }
    public void doGet(String url, final CallBack callBack){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (callBack!=null){
                    callBack.onCg(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (callBack!=null){
                    callBack.onSb(error.getMessage());
                }
            }
        });
        mrequestQueue.add(stringRequest);
    }
    public void doPost(String url, final Map<String,String> map, final CallBack callBack){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (callBack!=null){
                    callBack.onCg(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (callBack!=null){
                    callBack.onSb(error.getMessage());
                }
            }
        }){
            @Override
            protected Map<String, String> getParams(){
                return map;
            }
        };
        mrequestQueue.add(stringRequest);
    }
    //接口回调
    public interface CallBack{
        void onCg(String str);
        void onSb(String str);
    }
}
