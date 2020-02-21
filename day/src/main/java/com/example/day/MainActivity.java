package com.example.day;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.day.contract.IHomePageContract;
import com.example.day.presenter.HomePagePresenter;

public class MainActivity extends AppCompatActivity implements IHomePageContract.iView {
    private TextView text;
    private HomePagePresenter homePagePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homePagePresenter = new HomePagePresenter(this);
        initView();
        initData();
    }
    private void initView() {
        text = (TextView) findViewById(R.id.text);
    }
    private void initData(){
        String url = "http://mobile.bwstudent.com/small/commodity/v1/bannerShow";
        homePagePresenter.getBanner(url);
        String urlGetList = "http://mobile.bwstudent.com/small/commodity/v1/commodityList";
        homePagePresenter.getList(urlGetList);
    }
    @Override
    public void onGetBannerCg(String str) {
        text.setText(str);

    }

    @Override
    public void onGetBannerSb(String str) {
        text.setText(str);
    }



    @Override
    public void onGetListCg(String str) {

    }

    @Override
    public void onGetListSb(String str) {

    }


}
