package com.nag.android.fairyviewer;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView hourhand;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		hourhand = (ImageView)findViewById(R.id.imageHourHand);
		//start(1000);
	}
	
	private Timer timer = null;
	private void start(int period){
		timer = new Timer(true);
		timer.scheduleAtFixedRate(new TimerTask(){
			@Override
			public void run() {
				hourhand.invalidate();
			}}, 0, period);
	}
	
	public void stop(){
		timer.cancel();
		timer = null;
	}
	
}
