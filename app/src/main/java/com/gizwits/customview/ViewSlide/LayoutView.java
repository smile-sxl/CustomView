package com.gizwits.customview.ViewSlide;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * author: smile .
 * date: On 2018/6/9
 */
public class LayoutView extends View {
    private int lastX, lastY;

    public LayoutView(Context context) {
        super(context);
    }

    public LayoutView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LayoutView(Context context, AttributeSet attrs, int defStyleAttr) {
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
                layout(getLeft() + moveX, getTop() + moveY,
                        getRight() + moveX, getBottom() + moveY);
                break;
        }
        return true;
    }
}
