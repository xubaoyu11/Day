package com.bawei.wutenglong20200224.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.wutenglong20200224.R;
import com.bawei.wutenglong20200224.activity.MainActivity;
import com.bawei.wutenglong20200224.bean.Bean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * @ProjectName: wutenglong20200224
 * @Package: com.bawei.wutenglong20200224.adapter
 * @ClassName: MyAdapter
 * @Description: java类作用描述
 * @CreateDate: 2020/2/24 13:59
 * @UpdateUser: 武腾龙
 * @UpdateDate: 2020/2/24 13:59
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
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView==null){
            convertView=View.inflate(context, R.layout.item,null);
            holder=new ViewHolder();
            holder.iv=convertView.findViewById(R.id.iv);
            holder.tv=convertView.findViewById(R.id.tv);
            holder.neirong=convertView.findViewById(R.id.neirong);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        Bean.ResultsBean.NewsistBean newsistBean = list.get(position);
        holder.tv.setText(newsistBean.getTitle());
        holder.neirong.setText(newsistBean.getContent());
        String image = newsistBean.getImage();
        Glide.with(context).load(image).into(holder.iv);
        return convertView;
    }
    private class ViewHolder{
        private ImageView iv;
        private TextView tv;
        private TextView neirong;
    }
}
