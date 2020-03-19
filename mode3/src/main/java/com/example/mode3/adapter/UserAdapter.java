package com.example.mode3.adapter;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import com.example.mode3.bean.UserBean;

import java.util.List;

/**
 * @ProjectName: My Application4
 * @Package: com.example.mode3.adapter
 * @ClassName: UserAdapter
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/3/2 14:06
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/2 14:06
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class UserAdapter  implements ListAdapter {
    public UserAdapter(List<UserBean.DataBean.VerticalListDataBean> verticalListData) {

    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int i) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return 0;
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
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public int getItemViewType(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
