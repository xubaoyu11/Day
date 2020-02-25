package com.example.day5.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class FlowLayout extends ViewGroup {
    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int left = 0;
        int top = 0;
        int right = 0;
        int bottom = 0;
        int space=30;
        int count = getChildCount();
        if (count>0){
            for (int i=0;i<count;i++)
            {
                View view=getChildAt(i);
                view.measure(0,0);
                int childWidth=view.getMeasuredWidth();
                int childHeight=view.getMeasuredHeight();
                //right累计叠加
                right=left+childWidth;
                int widthPixels=getResources().getDisplayMetrics().widthPixels;
                if (right>widthPixels)
                {
                    left=0;
                    right=left+childWidth;
                    top=bottom+space;
                }
                bottom=top+childHeight;
                view.layout(left,top,right,bottom);
                left+=childWidth+space;
            }
        }
    }
    public void add(List<String>tags){
        if (tags!=null&&tags.size()>0)
        {
            for (String tag:tags)
            {
                final TextView textView=new TextView(getContext());
                textView.setText(tag);
                addView(textView);
                textView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        flowCallback.flowClick(textView.getText().toString());
                    }
                });
            }
        }
    }
    public void addTextView(String name)
    {
        final TextView textView=new TextView(getContext());
        textView.setText(name);
        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), ""+textView.getText(), Toast.LENGTH_SHORT).show();
                flowCallback.flowClick(textView.getText().toString());
            }
        });
        addView(textView);
    }
    private FlowCallback flowCallback;
    public void setFlowCallback(FlowCallback flowCallback){
        this.flowCallback=flowCallback;
    }
    public interface FlowCallback{
        void flowClick(String name);
    }
}
