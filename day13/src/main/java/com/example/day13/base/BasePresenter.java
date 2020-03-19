package com.example.day13.base;

import java.lang.ref.WeakReference;

/**
 * @ProjectName: My Application4
 * @Package: com.example.day13.base
 * @ClassName: BasePresenter
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/3/12 19:39
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/12 19:39
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public abstract class BasePresenter<V extends BaseView> {
    private WeakReference<V> mWeakReference;
    public BasePresenter(V v){
         mWeakReference = new WeakReference<>(v);
         initModel();
    }

    public V getView(){
        if (mWeakReference != null){
            return mWeakReference.get();
        }
        return null;
    }
    //内存泄漏的处理
    public void detachView(){
        if (mWeakReference!=null){
            mWeakReference.clear();
            mWeakReference = null;
        }
    }
    protected abstract void initModel();
}
