package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mBtnOpen, mBtnClose;
    String CHANNEL_ID = "My_channel";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnOpen = findViewById(R.id.buttonOpenNotification);
        mBtnClose = findViewById(R.id.buttonCloseNotification);

        mBtnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,CHANNEL_ID);
                builder.setContentTitle("Thông báo");
                builder.setContentText("Bạn còn 5 voucher sắp hết hạn. Hãy vào kiểm tra!!");
                builder.setShowWhen(true);
                builder.setSmallIcon(android.R.drawable.btn_star);

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "abc", NotificationManager.IMPORTANCE_DEFAULT);

                }

                notificationManager.notify(1,builder.build());
            }
        });
    }
}