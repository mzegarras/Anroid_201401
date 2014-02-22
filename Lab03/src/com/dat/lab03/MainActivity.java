package com.dat.lab03;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	TextView textView1;
	Button btn1,btn2;
	IntentFilter intentFilter;
	
	private BroadcastReceiver notificacion = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			
			/*double TC = intent.getDoubleExtra("TC", 0);
			textView1.setText(String.valueOf(TC));*/
			
			
			if("TIPO_CAMBIO_NOTIFICACION".compareTo(intent.getAction())==0){
				double TC = intent.getDoubleExtra("TC", 0);
				textView1.setText(String.valueOf(TC));
			}
			else if("android.intent.action.AIRPLANE_MODE".compareTo(intent.getAction())==0){
				boolean resultado=intent.getBooleanExtra("state", false);
				
				if(resultado){
					textView1.setTextColor(Color.RED);
				}
				else{
					textView1.setTextColor(Color.GREEN);
				}
			}
		}
		
	};
	
	
		
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		unregisterReceiver(notificacion);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		intentFilter = new IntentFilter();
		intentFilter.addAction("TIPO_CAMBIO_NOTIFICACION");
		//intentFilter.addAction("com.dat.lab03.SYN_SERVICE");
		intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
		registerReceiver(notificacion, intentFilter);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textView1 = (TextView)findViewById(R.id.textView1);
		btn1= (Button)findViewById(R.id.button1);
		btn2= (Button)findViewById(R.id.button2);
		
		intentFilter = new IntentFilter();
		intentFilter.addAction("com.dat.lab03.SYN_SERVICE");
		intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
		registerReceiver(notificacion, intentFilter);
		
		
		
	}

	public void btnIniciar(View v){
		Intent intent = new Intent(this,TipoCambioService.class);
		startService(intent);
	}
	
	public void btnDetener(View v){
		Intent intent = new Intent(this,TipoCambioService.class);
		stopService(intent);
	}
	
	public void btnScheduled(View v){
		AlarmManager alarmManager =
				(AlarmManager)getSystemService(Context.ALARM_SERVICE);
		
		Intent intent = new Intent(this,SincronizaService.class);
		
		PendingIntent pendingIntent = 
				PendingIntent.getService(this, 
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
