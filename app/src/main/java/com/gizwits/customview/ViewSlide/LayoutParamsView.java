package com.gizwits.customview.ViewSlide;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * author: smile .
 * date: On 2018/6/9
 */
public class LayoutParamsView extends View {
    private int lastX, lastY;

    public LayoutParamsView(Context context) {
        super(context);
    }

    public LayoutParamsView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LayoutParamsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 获取触摸点的x,y
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 记录触摸点坐标
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                // 计算偏移量
                int moveX = x - lastX;
                int moveY = y - lastY;
                //  更改位置
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) getLayoutParams();
                params.leftMargin = getLeft() + moveX;
                params.topMargin = getTop() + moveY;
                setLayoutParams(params);
                break;
        }
        return true;
    }
}
