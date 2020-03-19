package com.example.mode3.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/**
 * @ProjectName: My Application4
 * @Package: com.example.mode3.base
 * @ClassName: BaseFragment
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/3/2 14:13
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/2 14:13
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(initLayoutid(), container, false);
        initView();
        initList();
        initData();
        return view;
    }
    protected abstract int initLayoutid();
    protected abstract void initView();
    protected abstract void initList();
    protected abstract void initData();
}
