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
    static String TAG = "TAG";
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
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Log.i(TAG, "WORKING");

                IntentFilter intentfilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
                Intent batteryStatus = registerReceiver(null, intentfilter );

                int batteryLevel = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                Log.d("Battery", "Level: " + String.valueOf(batteryLevel));
            }
        }, 0, 3000);

        return START_STICKY;
    }

    @Override public void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy");
        timer.cancel();
    }
}
