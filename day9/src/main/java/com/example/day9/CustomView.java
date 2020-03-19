package com.example.day9;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/**
 * @ProjectName: My Application4
 * @Package: com.example.day9
 * @ClassName: CustomView
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/2/28 21:40
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/2/28 21:40
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CustomView extends View {


    private Paint paint;

    public CustomView(Context context) {
        super(context);
        init();
    }

    private void init() {
        //初始化画笔
        paint = new Paint();
    }
    //创建画布

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLUE);
        RectF rectF = new RectF();
        rectF.left = 400;
        rectF.right = 600;
        rectF.bottom =400;
        rectF.top = 200;
        canvas.drawArc(rectF,0,70,true,paint);
        paint.setColor(Color.RED);
        RectF rectF1 = new RectF();
        rectF1.left = 400;
        rectF1.right = 600;
        rectF1.bottom = 400;
        rectF1.top = 200;
        canvas.drawArc(rectF1,70,90,true,paint);

        paint.setColor(Color.YELLOW);
        RectF rectF2 = new RectF();
        rectF2.left  = 400;
        rectF2.right = 600;
        rectF2.bottom = 400;
        rectF2.top = 200;
        canvas.drawArc(rectF2,160,80,true,paint);
        paint.setColor(Color.GREEN);
        RectF rectF3 = new RectF();
        rectF3.left = 400;
        rectF3.right = 600;
        rectF3.bottom = 400;
        rectF3.top = 200;
        canvas.drawArc(rectF1,240,120,true,paint);
    }
}
