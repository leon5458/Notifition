package com.hly.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * ~~~~~~文件描述:~~~~~~
 * ~~~~~~作者:huleiyang~~~~~~
 * ~~~~~~创建时间:2018/8/17~~~~~~
 * ~~~~~~更改时间:2018/8/17~~~~~~
 * ~~~~~~版本号:1~~~~~~
 */
public class SecondeActivity extends AppCompatActivity implements View.OnClickListener {
    private String  TAG = "MainActivity: ";
    private Button button;
    private NotificationManager notificationManager ;
    private static  int num = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity_layout);
        button = findViewById(R.id.my_notify_id) ;
        button.setOnClickListener(this);
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.my_notify_id :
                showNotify();
                num ++;
                break;
            default:
                break;
        }
    }
    //显示notify
    private void showNotify() {
        Intent intent = new Intent(this,TestActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);  //保证多个nitifition 跳转同一界面 不会显示多个
        intent.putExtra("test","hello " + num);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, num, intent, PendingIntent.FLAG_UPDATE_CURRENT);   //想要不同的 Pending intent 就要不同的 num 参参数
        if (Build.VERSION.SDK_INT >= 26) {   //解决 sdk 26 版本之上notifices 不显示的问题
            NotificationChannel channel = new NotificationChannel("channel_id", "channel_name", NotificationManager.IMPORTANCE_HIGH);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
            Notification.Builder notification = new Notification.Builder(this,"channel_id");
            notification.setSmallIcon(R.mipmap.ic_launcher)
                    .setSmallIcon(R.drawable.ic_launcher_background)//设置小图标
                    .setContentTitle("这是标题")
                    .setContentText("这是内容" + num)
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent)
                    .build();
            notificationManager.notify(num,notification.build());
        } else{
            Notification notification = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
                notification = new Notification.Builder(this)
                        .setSmallIcon(R.drawable.ic_launcher_background)//设置小图标
                        .setContentTitle("这是标题")
                        .setContentText("这是内容" + num)
                        .setAutoCancel(true)
                        .setContentIntent(pendingIntent)
                        .build();
            }
            notificationManager.notify(num, notification);    //想要不同的 notifice 就要不同的num 参数
        }
    }
}