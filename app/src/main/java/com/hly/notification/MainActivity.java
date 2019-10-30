package com.hly.notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;

import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.RemoteViews;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private static final int PUSH_NOTIFICATION_ID = (0x001);
    private static final String PUSH_CHANNEL_ID = "PUSH_NOTIFY_ID";
    private static final String PUSH_CHANNEL_NAME = "PUSH_NOTIFY_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //创建通知栏管理工具
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                //如果是8.0 创建一个渠道
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel mChannel = new NotificationChannel(PUSH_CHANNEL_ID, PUSH_CHANNEL_NAME, NotificationManager.IMPORTANCE_LOW);
                    notificationManager.createNotificationChannel(mChannel);
                }
                //点击跳转
                Intent intent = new Intent(MainActivity.this, SecondeActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
                Notification mBuilder = new NotificationCompat.Builder(MainActivity.this, PUSH_CHANNEL_ID)
                        .setSmallIcon(R.mipmap.ic_launcher) //小图片 ，有些手机可能不显示，
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))//设置大图标
                        .setWhen(System.currentTimeMillis())  //设置时间
                        .setContentTitle("精选内容") //标题
                        .setContentText("点击查看更多详细的内容呢") //内容
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)  //通知优先级，PRIORITY_DEFAULT为默认写与不写一样
                        .setContentIntent(pendingIntent)
                        .build();
                //通知显示出来
                notificationManager.notify(PUSH_NOTIFICATION_ID, mBuilder);

            }
        });


        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //创建通知栏管理工具
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                //如果是8.0 创建一个渠道
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel mChannel = new NotificationChannel(PUSH_CHANNEL_ID, PUSH_CHANNEL_NAME, NotificationManager.IMPORTANCE_LOW);
                    notificationManager.createNotificationChannel(mChannel);
                }
                //点击跳转
                Intent intent = new Intent(MainActivity.this, SecondeActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
                Notification mBuilder = new NotificationCompat.Builder(MainActivity.this, PUSH_CHANNEL_ID)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("精选内容")
                        .setContentText("点击查看更多详细的内容呢")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setContentIntent(pendingIntent)
                        .setStyle(new NotificationCompat.InboxStyle().addLine("第一行内容显示").addLine("第二行内容显示").addLine("第三行内容显示").addLine("第四行内容显示").addLine("第五行内容显示"))
                        .build();
                notificationManager.notify(2, mBuilder);
            }
        });


        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //创建通知栏管理工具
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                //如果是8.0 创建一个渠道
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel mChannel = new NotificationChannel(PUSH_CHANNEL_ID, PUSH_CHANNEL_NAME, NotificationManager.IMPORTANCE_LOW);
                    notificationManager.createNotificationChannel(mChannel);
                }
                //点击跳转
                Intent intent = new Intent(MainActivity.this, SecondeActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
                Notification mBuilder = new NotificationCompat.Builder(MainActivity.this, PUSH_CHANNEL_ID)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("精选内容")
                        .setContentText("点击查看更多详细的内容呢")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setContentIntent(pendingIntent)
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(), R.mipmap.image)))
                        .build();
                notificationManager.notify(2, mBuilder);
            }
        });


        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //创建通知栏管理工具
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                //如果是8.0 创建一个渠道
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel mChannel = new NotificationChannel(PUSH_CHANNEL_ID, PUSH_CHANNEL_NAME, NotificationManager.IMPORTANCE_LOW);
                    notificationManager.createNotificationChannel(mChannel);
                }
                //自定义布局
                RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notification_remote_layout);

                Notification mBuilder = new NotificationCompat.Builder(MainActivity.this, PUSH_CHANNEL_ID)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("精选内容")
                        .setContentText("点击查看更多详细的内容呢")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setContent(remoteViews)
                        .build();
                notificationManager.notify(2, mBuilder);
            }
        });


        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationUtils notificationUtils = new NotificationUtils(MainActivity.this);
                notificationUtils.sendNotification("测试标题", "测试内容");

            }
        });


    }


}
