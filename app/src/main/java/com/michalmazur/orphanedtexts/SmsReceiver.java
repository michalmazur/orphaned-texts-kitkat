package com.michalmazur.orphanedtexts;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();

        if (extras == null) {
            return;
        }

        try {
            Object[] pdus = (Object[]) extras.get("pdus");

            for (int i = 0; i < pdus.length; i++) {

                SmsMessage msg = SmsMessage.createFromPdu((byte[]) pdus[i]);
                String address = msg.getDisplayOriginatingAddress();
                String message = msg.getDisplayMessageBody();

                ContentValues values = new ContentValues();
                values.put(Telephony.Sms.ADDRESS, address);
                values.put(Telephony.Sms.BODY, message);
                context.getContentResolver().insert(Telephony.Sms.Sent.CONTENT_URI, values);
            }
        } catch (Exception e) {
            Log.e("SmsReceiver", e.getMessage() + e.getStackTrace());
        }
    }
}
