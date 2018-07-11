package com.gizwits.customview.ViewSlide;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Scroller;

/**
 * author: smile .
 * date: On 2018/6/9
 */
public class ScrollerView extends View {
    private Scroller mScroller;

    public ScrollerView(Context context) {
        super(context);
    }

    public ScrollerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 初始化Scroller
        mScroller = new Scroller(context);
    }

    public ScrollerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 系统会在绘制View的时候在draw()方法中调用该方法，这个方法中我们调用父类的scrollTo()方法并通过Scroller
     * 来不断获取当前的滚动值，每滑动一小段距离我们就调用invalidate()方法不断的进行重绘，重绘就会调用
     * computeScroll()方法，这样我们就通过不断的移动一个小的距离并连贯起来就实现了平滑移动的效果
     */
    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            ((View) getParent()).scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            //通过不断的重绘不断的调用computeScroll方法
            invalidate();
        }
    }

    /**
     * 提供2秒内平滑的滑动方法
     * @param destX
     * @param destY
     */
    public void smoothScrollTo(int destX, int destY) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int deltaX = destX - scrollX;
        int deltaY = destY - scrollY;
        // 在2秒内滑到destX destY
        mScroller.startScroll(scrollX, scrollY, deltaX, deltaY, 2000);
        invalidate();
    }
}
