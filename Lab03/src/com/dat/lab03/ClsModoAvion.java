package com.dat.lab03;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ClsModoAvion extends BroadcastReceiver{
	
	
	public static String TAG=ClsModoAvion.class.getCanonicalName();
	public void onReceive(Context arg0, Intent arg1){
		Log.d(TAG,"Modo avion on");
		
		Intent intent = new Intent(arg0,ClsModoAvion.class);
		arg0.startService(intent);
		
	}

}
