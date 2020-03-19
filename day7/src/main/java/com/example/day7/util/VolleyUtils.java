package com.example.day7.util;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.day7.app.App;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: My Application4
 * @Package: com.example.day7.util
 * @ClassName: VolleyUtils
 * @Description:
 * @Author: deshuai
 * @CreateDate: 2020/2/27 21:47
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/27 21:47
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class VolleyUtils {

    private final RequestQueue requestQueue;

    private VolleyUtils(){
        requestQueue = Volley.newRequestQueue(App.getAppContext());
    }
    private static class SingLeInstance{
        private static VolleyUtils volleyUtils = new VolleyUtils();
    }
    public static VolleyUtils getInstance(){
        return SingLeInstance.volleyUtils;
    }
    public void doGet(String url, final CallBack callBack){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callBack.onCg(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onSb(error.getMessage());
            }
          }
        );
        requestQueue.add(stringRequest);
    }
    public void doPost(String url, final HashMap<String,String>map, final CallBack callBack){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callBack.onCg(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onSb(error.getMessage());
            }
         }){
            protected Map getParams(){
                return map;
            }
        };
    }
    //接口
    public interface CallBack{
        //成功
        void onCg(String json);
        void onSb(String msg);
    }
}
