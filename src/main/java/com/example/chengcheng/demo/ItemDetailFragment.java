package com.example.chengcheng.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chengcheng.activityanimation_master.R;

import de.greenrobot.event.EventBus;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月28日22:57:16
 * Description:
 */
public class ItemDetailFragment  extends ListFragment{

    private TextView tv_detail;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    //list的点击事件发送时间然后接受更新
    public void onEventMainThread(Item item){
        if (item!=null){
            tv_detail.setText(item.content);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_item_detail,container,false);
        return view;
    }
}
