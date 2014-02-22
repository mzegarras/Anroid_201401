package com.dat.lab03;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootCompleteRecieve extends BroadcastReceiver {

	
	public static String TAG = BootCompleteRecieve.class.getCanonicalName();
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		Log.d(TAG, "BootCompleteRecieve entro");
	
		//Intent intent = new Intent(arg0,TipoCambioService.class);
		//arg0.startService(intent);
		
		
		//SCHELUED SINCRONIZA SERVICE
		
		AlarmManager alarmManager =
				(AlarmManager)arg0.getSystemService(Context.ALARM_SERVICE);
		
		Intent intent = new Intent(arg0,SincronizaService.class);
		
		PendingIntent pendingIntent = 
				PendingIntent.getService(arg0, 
											0, 
											intent, 
											PendingIntent.FLAG_UPDATE_CURRENT);
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.SECOND, 20);
		
		alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
				calendar.getTimeInMillis(), 
				1000 * 10, pendingIntent);
	}

}
