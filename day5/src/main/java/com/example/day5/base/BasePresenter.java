package com.example.day5.base;

/*
* 时间：2020/02/25
* 作者：续宝玉
* 功能：抽调MVP中P层的基类*/
public abstract class BasePresenter<M extends BaseModel,V extends IBaseView> {
    public M model;
    public V view;

    public BasePresenter() {
        this.model = initModel();
    }



    /*绑定view*/
    public void attach(V v)
    {
        v=this.view;
    }
    protected abstract M initModel();
    public void dettach(){
        if (view!=null)
        {
            view=null;
        }
    }
    public V getView(){
        return view;
    }
}
