package com.gizwits.customview.ViewSlide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.gizwits.customview.BaseRecyclerAdapter;
import com.gizwits.customview.R;
import com.gizwits.customview.SmartViewHolder;

import java.util.Arrays;

import static android.R.layout.simple_list_item_2;
import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * author: smile .
 * date: On 2018/6/10
 */
public class ViewSlideActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private enum Item {
        Layout(R.string.layout, LayoutSlideActivity.class),
        Offset(R.string.offset, OffsetSlideActivity.class),
        LayoutParams(R.string.layoutparams, LayoutParamsSlideActivity.class),
        Scroll(R.string.scroll, ScrollSlideActivity.class),
        Scroller(R.string.scroller, ScrollerSlideActivity.class);

        public int nameId;
        public Class<?> clazz;

        Item(@StringRes int nameId, Class<?> clazz) {
            this.nameId = nameId;
            this.clazz = clazz;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, VERTICAL));
        recyclerView.setAdapter(new BaseRecyclerAdapter<ViewSlideActivity.Item>(Arrays.asList(ViewSlideActivity.Item.values()), simple_list_item_2, this) {
            @Override
            public SmartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                SmartViewHolder holder = super.onCreateViewHolder(parent, viewType);
                return holder;
            }

            @Override
            protected void onBindViewHolder(SmartViewHolder holder, ViewSlideActivity.Item model, int position) {
                holder.text(android.R.id.text1, model.name());
                holder.text(android.R.id.text2, model.nameId);
                holder.textColorId(android.R.id.text2, R.color.colorTextAssistant);
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        startActivity(new Intent(this, ViewSlideActivity.Item.values()[position].clazz));
    }
}
