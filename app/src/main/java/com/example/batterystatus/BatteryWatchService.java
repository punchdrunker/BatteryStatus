package com.example.batterystatus;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.IBinder;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class BatteryWatchService extends Service {
    static String TAG = "BatteryWatchService";
    private Timer timer;

    public BatteryWatchService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        return null;
    }

    @Override public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");

        // TODO: 4.タイマーを起動しよう(15行目で宣言したtimerを利用する)
        // TODO: 6.タイマーの処理の中でバッテリー情報をLog出力しよう

        return START_STICKY;
    }

    @Override public void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy");

        // TODO: 5.タイマーを停止しよう
    }
}
