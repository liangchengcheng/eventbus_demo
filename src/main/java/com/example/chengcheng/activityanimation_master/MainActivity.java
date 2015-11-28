package com.example.chengcheng.activityanimation_master;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import de.greenrobot.event.EventBus;
/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月28日22:54:22
 * Description:
 */
public class MainActivity extends AppCompatActivity {

    private Button btn_ok;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //简单的注册下eventbus
        EventBus.getDefault().register(this);
        tv= (TextView) findViewById(R.id.tv_result);
        btn_ok= (Button) findViewById(R.id.btn_send);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2015/10/14 这里只是单纯的演示项目
                Intent intent=new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onEventMainThread(FirstEvent event){
        String msg="在这里接受到了消息"+event.getmMsg();
        tv.setText(msg);
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().post(new FirstEvent("ok im lcc"));
    }
}
