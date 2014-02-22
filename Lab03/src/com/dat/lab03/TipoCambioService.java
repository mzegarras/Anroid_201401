package com.dat.lab03;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;


public class TipoCambioService extends Service {
	
	private static String TAG =TipoCambioService.class.getCanonicalName();
	
	private Timer timer;
	
	private TimerTask timerTask = new TimerTask() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			Random random = new Random();
			double TC =  random.nextDouble();
			
			Intent intent = new Intent("TIPO_CAMBIO_NOTIFICACION");
			intent.putExtra("TC", TC);
			sendBroadcast(intent);
			
			Log.d(TAG, "TC:" + String.valueOf(TC));
		}
	};
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		timer = new Timer(TAG);
		timer.schedule(timerTask, 1000,1000*10);
		Log.d(TAG,"Inicio Service");
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		timer.cancel();
		Log.d(TAG,"Detener Service");
	}






	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}


}
