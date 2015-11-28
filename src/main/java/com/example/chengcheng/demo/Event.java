package com.example.chengcheng.demo;

import java.util.List;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月28日22:55:14
 * Description:
 */
public class Event {
    /*列表加载时间*/
    public static class ItemListEvent{

        private List<Item> items;

        public ItemListEvent(List<Item> items){
            this.items=items;
        }

        public List<Item> getItems(){
            return items;
        }
    }
}
