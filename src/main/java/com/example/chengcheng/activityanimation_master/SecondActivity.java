package com.example.chengcheng.activityanimation_master;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import de.greenrobot.event.EventBus;
/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月28日22:54:16
 * Description:
 */
public class SecondActivity extends AppCompatActivity {

    private Button first_event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        first_event= (Button) findViewById(R.id.first_event);
        first_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new FirstEvent("event btn is clicking"));
            }
        });
    }

}
