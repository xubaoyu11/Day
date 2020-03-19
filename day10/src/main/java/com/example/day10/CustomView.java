package com.example.day10;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;


public class CustomView extends View {

    private Paint paint;

    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs){
        super(context,attrs);
        init();
    }

    public void init(){
    //初始化画笔
        paint = new Paint();
    }

    //创建画布
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
       // canvas.drawCircle(100,100,50,paint);
        paint.setColor(Color.GREEN);
        RectF rectF = new RectF();
        rectF.left=400;
        rectF.right=600;
        rectF.bottom=400;
        rectF.top=200;
        canvas.drawArc(rectF,0,70,true,paint);
        paint.setColor(Color.RED);
        RectF rectF1 = new RectF();
        rectF1.left=400;
        rectF1.right=600;
        rectF1.bottom=400;
        rectF1.top=200;
        canvas.drawArc(rectF1,70,90,true,paint);
        paint.setColor(Color.YELLOW);
        RectF rectF2 = new RectF();
        rectF2.left=400;
        rectF2.right=600;
        rectF2.bottom=400;
        rectF2.top=200;
        canvas.drawArc(rectF2,160,80,true,paint);
        paint.setColor(Color.GREEN);
        RectF rectF3 = new RectF();
        rectF3.left=400;
        rectF3.right=600;
        rectF3.bottom=400;
        rectF3.top=200;
        canvas.drawArc(rectF1,240,120,true,paint);

        paint.setColor(Color.GREEN);
        Rect rect = new Rect();
        rect.left=250;
        rect.right=300;
        rect.top=120;
        rect.bottom=800;
        canvas.drawRect(rect,paint);
        //竖着的
        paint.setColor(Color.YELLOW);
        Rect rect1 = new Rect();
        rect1.left=300;
        rect1.right=350;
        rect1.top=180;
        rect1.bottom=800;
        canvas.drawRect(rect1,paint);

    }
}
