package com.dat.lab04;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void btnVerURL(View v){
		//Activity Explícito
		//Intent intent = new Intent(this,Activity.class)

		//Activity Implícito
		Intent intent = new Intent(Intent.ACTION_VIEW,
								 Uri.parse("http://www.google.com"));
		
		startActivity(intent);
		
	}
	
	public void btnLlamar(View v){
		/*
		Intent intent = new Intent(Intent.ACTION_VIEW,
				 Uri.parse("tel:4209056"));

		startActivity(intent);
		*/
		
		//requiere
		//<uses-permission android:name="android.permission.CALL_PHONE"/>
		Intent intent = new Intent(Intent.ACTION_CALL,
				 Uri.parse("tel:4209056"));
		
		startActivity(intent);
		
		
		
	}
	
	public void verMapa(View v){
		Intent intent = new Intent(Intent.ACTION_VIEW,
				 Uri.parse("geo:37.422219,-122.08634"));
		
		startActivity(intent);
		
	}
	
	public void sendSMS(View v){
		Intent intent = new Intent(Intent.ACTION_VIEW,
				 Uri.parse("smsto:987654123"));
		intent.putExtra("sms_body", "sms opcion 5");
		startActivity(intent);
	}
	
	
	
	
	
	
}
