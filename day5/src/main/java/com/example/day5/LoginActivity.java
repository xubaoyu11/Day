package com.example.day5;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day5.adapter.MyBaseAdapter;
import com.example.day5.app.App;
import com.example.day5.base.BaseActivyty;
import com.example.day5.base.BasePresenter;
import com.example.day5.contract.IHomeContract;
import com.example.day5.entity.ShopEntity;
import com.example.day5.presenter.HomePresenter;
import com.example.day5.weight.FlowLayout;
import com.google.gson.Gson;

import java.net.URLEncoder;
import java.util.List;

public class LoginActivity extends BaseActivyty implements IHomeContract.IView {
    private FlowLayout flowLayout;
    private EditText edit_shop;
    private TextView title_one;
    private RecyclerView recyclerView;
    private String url;
    private String shop;
    private HomePresenter homePresenter;
    private TextView sou;

    @Override
    protected int layoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initListener() {
        sou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            shop=edit_shop.getText().toString();
            flowLayout.addTextView(shop);
            url="http://mobile.bwstudent.com/small/commodity/v1/findCommodityByKeyword?keyword="+ URLEncoder.encode(shop) +"&page=1&count=5";
            homePresenter.getRecycle(url);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(App.getContext(), RecyclerView.VERTICAL, true);
        recyclerView.setLayoutManager(linearLayoutManager);
        title_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(LoginActivity.this,ForActivity.class);
                startActivity(it);
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        flowLayout=findViewById(R.id.flowlayout);
        sou=findViewById(R.id.sou);
        edit_shop=findViewById(R.id.edit_shop);
        homePresenter=new HomePresenter(this);
        recyclerView=findViewById(R.id.recycler);
        title_one=findViewById(R.id.title_one);
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    public void success(String response) {
        ShopEntity shopEntity = new Gson().fromJson(response, ShopEntity.class);
        List<ShopEntity.ResultBean> result = shopEntity.getResult();
        recyclerView.setAdapter(new MyBaseAdapter(App.getContext(),result));
    }

    @Override
    public void failur(Throwable throwable) {

    }
}
