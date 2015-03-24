package com.nag.android.fairyviewer;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class MainActivity extends Activity implements SensorEventListener {

	private SensorManager manager;
	private HourHandView hourhand;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		hourhand = (HourHandView)findViewById(R.id.imageHourHand);
		start(3000);
		manager = (SensorManager)getSystemService(SENSOR_SERVICE);	
	}
	
	private Timer timer = null;
	private void start(int period){
		timer = new Timer(true);
		timer.scheduleAtFixedRate(new TimerTask(){
			@Override
			public void run() {
				hourhand.update();
			}}, 0, period);
	}
	
	public void stop(){
		timer.cancel();
		timer = null;
	}
	

	@Override
	protected void onStop() {
		super.onStop();
		manager.unregisterListener(this);
	}

	@Override
	protected void onResume() {
		super.onResume();
		List<Sensor> sensors = manager.getSensorList(Sensor.TYPE_ACCELEROMETER);
		if(sensors.size() > 0) {
			Sensor s = sensors.get(0);
			manager.registerListener(this, s, SensorManager.SENSOR_DELAY_UI);
		}
	}

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
			Log.d("","H:"+event.values[SensorManager.DATA_X]);
			Log.d("","H:"+event.values[SensorManager.DATA_Y]); 
			Log.d("","H:"+ event.values[SensorManager.DATA_Z]);
		}
	}
}
