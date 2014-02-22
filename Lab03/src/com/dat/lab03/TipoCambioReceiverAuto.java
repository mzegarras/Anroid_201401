package com.dat.lab03;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


public class TipoCambioReceiverAuto extends BroadcastReceiver {
	public static String TAG=TipoCambioReceiverAuto.class.getCanonicalName();
	public void onReceive(Context arg0, Intent arg1){
		Log.d(TAG,"BootCompleteReceive entro");
		
		Intent intent = new Intent(arg0,TipoCambioService.class);
		arg0.startService(intent);
		
	}
	
}
