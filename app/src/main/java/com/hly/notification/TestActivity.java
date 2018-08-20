package com.hly.notification;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * ~~~~~~文件描述:~~~~~~
 * ~~~~~~作者:huleiyang~~~~~~
 * ~~~~~~创建时间:2018/8/20~~~~~~
 * ~~~~~~更改时间:2018/8/20~~~~~~
 * ~~~~~~版本号:1~~~~~~
 */
public class TestActivity extends AppCompatActivity {


    private String TAG = "TestActivity: ";
    private TextView textView;
    private  String  test = "";



    //当使用多notifition  的时候，跳转同一个界面
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        System.out.println(TAG +  "onNewIntent: ");
        if(intent != null){
            setIntent(intent);
            getIntentData();
            setTest();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        textView = (TextView) findViewById(R.id.hello_notify_id);

        getIntentData();
        setTest();
    }

    private void setTest() {

        textView.setText(test);
    }

    private void getIntentData() {
        Intent intent = getIntent();
        test = intent.getStringExtra("test");
        System.out.println("test:" + test);
    }
}