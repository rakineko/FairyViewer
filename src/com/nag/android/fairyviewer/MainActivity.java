package com.nag.android.fairyviewer;

import com.nag.android.fairyviewer.ShakeManager.OnShakeListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnShakeListener {

	private HourHandView hourhand;
	private ShakeManager shakemanager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		hourhand = (HourHandView)findViewById(R.id.imageHourHand);
		findViewById(R.id.button1).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				hourhand.update();
			}
		});
		shakemanager = new ShakeManager();
		shakemanager.setOnShakeListener(this);
	}

	@Override
	protected void onResume() {
		super.onResume();
		shakemanager.resume(this);
	}

	@Override
	protected void onStop() {
		super.onStop();
		shakemanager.pause();
	}

	@Override
	public void onShake() {
		hourhand.update();
	}
}
