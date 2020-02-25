package com.example.day5.model;

import com.example.day5.contract.IHomeContract;
import com.example.day5.util.NetUtil;

import java.util.Map;

public class HomeModel implements IHomeContract.IModel {
    private Map<String,String>map;
    @Override
    public void getZhuce(String url, final IModelCallback iModelCallback) {
        NetUtil.getInstance().doPost(url, new NetUtil.VolleyCallback() {
            @Override
            public void success(String response) {
                iModelCallback.success(response);
            }

            @Override
            public void failure(Throwable throwable) {
                iModelCallback.failur(throwable);
            }
        },map);
    }

    @Override
    public void getLogin(String url, final IModelCallback iModelCallback) {
        NetUtil.getInstance().doPost(url, new NetUtil.VolleyCallback() {
            @Override
            public void success(String response) {
                iModelCallback.success(response);
            }

            @Override
            public void failure(Throwable throwable) {
                iModelCallback.failur(throwable);
            }
        },map);
    }

    @Override
    public void getRecycle(String url, final IModelCallback iModelCallback) {
        NetUtil.getInstance().doGet(url, new NetUtil.VolleyCallback() {
            @Override
            public void success(String response) {
                iModelCallback.success(response);
            }

            @Override
            public void failure(Throwable throwable) {
                iModelCallback.failur(throwable);
            }
        });
    }
}
