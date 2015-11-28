package com.example.chengcheng.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import de.greenrobot.event.EventBus;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月28日22:57:47
 * Description:
 */
public class ItemListFragment extends ListFragment {

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

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new Thread(new Runnable() {
            @Override
            public void run() {
             try{
                 Thread.sleep(2000);
                 EventBus.getDefault().post(new Event.ItemListEvent(Item.ITEMS));
             }
             catch (Exception e){
                 e.printStackTrace();
             }
            }
        }).start();
    }

    public void onEventMainThread(Event.ItemListEvent event){
        setListAdapter(new ArrayAdapter<Item>(getActivity(),
                android.R.layout.simple_list_item_activated_1,
                android.R.id.text1, event.getItems()));;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        EventBus.getDefault().post(getListView().getItemAtPosition(position));
    }
}
