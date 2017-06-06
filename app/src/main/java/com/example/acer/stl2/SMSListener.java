package com.example.acer.stl2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import com.example.acer.stl2.Database.DatabaseHelper;
import com.example.acer.stl2.Database.Model.Activator;

/**
 * Created by Acer on 6/7/17.
 */

public class SMSListener extends BroadcastReceiver {
    DatabaseHelper db;

    static final String ACTION = "android.provider.Telephony.SMS_RECEIVED";
    @Override
    public void onReceive(Context context, Intent intent) {
        db = new DatabaseHelper(context);

        if (intent.getAction().equals(ACTION)){
            Bundle bundle = intent.getExtras();
            if (bundle != null){
                Object[] pdus = (Object[]) bundle.get("pdus");
                SmsMessage[] messages = new SmsMessage[pdus.length];
                for (int i = 0; i < pdus.length; i++){
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                }
                for (SmsMessage message : messages){
                    String strFrom = message.getDisplayOriginatingAddress();
                    String strMsg = message.getDisplayMessageBody();
                    if (!db.checkActive()) {
                        Activator activator = db.getActivator();
                        if (strMsg.equals(activator.getCode()) && strFrom.substring(strFrom.length() - 10).equals(activator.getActivatorNumber().substring(activator.getActivatorNumber().length() - 10))) {
                            db.activateApp();
                            Toast.makeText(context, "Activated", Toast.LENGTH_LONG).show();
                        }

                    }
                }
            }
        }
    }
}
