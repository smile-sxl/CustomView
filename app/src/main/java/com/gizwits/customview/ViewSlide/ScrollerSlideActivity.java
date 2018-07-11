package com.gizwits.customview.ViewSlide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gizwits.customview.R;

/**
 * author: smile .
 * date: On 2018/6/9
 */
public class ScrollerSlideActivity extends AppCompatActivity {

    private ScrollerView mScrollerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroller_view);
        mScrollerView = (ScrollerView) findViewById(R.id.scrollerview);
        mScrollerView.smoothScrollTo(-400, -200);
    }

}
