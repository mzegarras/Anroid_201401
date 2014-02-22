package com.dat.lab03;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class TipoCambioReceiver extends BroadcastReceiver {
	
	public static String TAG = TipoCambioReceiver.class.getCanonicalName();
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		Log.d(TAG, "RECEPCIONAR NOTIFICACION");
		double TC = arg1.getDoubleExtra("TC", 0); 
		Log.d(TAG, "TC : " + String.valueOf(TC));
	}

}
