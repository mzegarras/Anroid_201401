package com.dat.lab03b;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	TextView textView1;
	
	
	private BroadcastReceiver notificacion = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {

			
				double TC = intent.getDoubleExtra("TC", 0);
				textView1.setText(String.valueOf(TC));
		}
		
	};
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		unregisterReceiver(notificacion);
	}

	IntentFilter intentFilter;
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		intentFilter = new IntentFilter();
		intentFilter.addAction("TIPO_CAMBIO_NOTIFICACION");
		registerReceiver(notificacion, intentFilter);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textView1 = (TextView)findViewById(R.id.textView1);
	}

	public void iniciarServicio(View v){
		Intent i=new Intent("com.dat.lab03.TCService");
		startService(i);
		
	}

	public void detenerServicio(View v){
		Intent i=new Intent("com.dat.lab03.TCService");
		stopService(i);
	
	}
	
}
