package com.michalmazur.orphanedtexts;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class HeadlessSmsSendService extends Service {

    String message = "Orphaned Texts does not support sending quick replies.";

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
