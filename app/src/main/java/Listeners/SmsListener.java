package Listeners;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.SmsMessage;

/**
 * Created by Acer on 6/5/2017.
 */
public class SmsListener  extends BroadcastReceiver{


  @Override
  public void onReceive(Context context, Intent intent) {
    if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
      Bundle bundle = intent.getExtras();           //---get the SMS message passed in---
      SmsMessage[] msgs = null;
      String msg_from;
      if (bundle != null){
        //---retrieve the SMS message received---
        try{
          Object[] pdus = (Object[]) bundle.get("ACTIVATE");
          msgs = new SmsMessage[pdus.length];
          msgs = new SmsMessage[pdus.length];
          for(int i=0; i<msgs.length; i++){
            msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
            msg_from = msgs[i].getOriginatingAddress();
            String msgBody = msgs[i].getMessageBody();
          }
        }catch(Exception e){
//                            Log.d("Exception caught",e.getMessage());
        }
      }
    }
  }
  }

