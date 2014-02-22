package com.dat.lab03;

import java.util.Random;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class SincronizaService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static String TAG =SincronizaService.class.getCanonicalName();
	
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		Random random = new Random();
		double TC =  random.nextDouble();
		
		Intent intent = new Intent("com.dat.lab03.SYN_SERVICE");
		intent.putExtra("TC", TC);
		sendBroadcast(intent);
		
		Log.d(TAG, "TC:" + String.valueOf(TC));
		
		stopSelf();
		
	}
	

}
