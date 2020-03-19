package com.example.day6.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.day6.R;
import com.example.day6.bean.Bean;

import java.util.List;

/**
 * @ProjectName: My Application4
 * @Package: com.example.day6.adapter
 * @ClassName: MyAdapter
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/2/26 22:15
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/26 22:15
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MyAdapter extends BaseAdapter {
    Context context;
    List<Bean.ResultsBean.NewsistBean> list;
    public MyAdapter(Context context, List<Bean.ResultsBean.NewsistBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHandler handler = null;
        if (view==null){
            view = View.inflate(context, R.layout.item,null);
            handler = new ViewHandler();
            handler.item_image = view.findViewById(R.id.item_image);
            handler.item_text1 = view.findViewById(R.id.item_text1);
            handler.item_text2 = view.findViewById(R.id.item_text2);
            view.setTag(handler);
        }else {
            handler = (ViewHandler) view.getTag();
        }
        Bean.ResultsBean.NewsistBean newsistBean = list.get(i);
        handler.item_text1.setText(newsistBean.getTitle());
        handler.item_text2.setText(newsistBean.getContent());
        String image = newsistBean.getImage();
        Glide.with(view).load(image).into(handler.item_image);
        return view;
    }
    private class ViewHandler{
        ImageView item_image;
        TextView item_text1;
        TextView item_text2;
    }
}
