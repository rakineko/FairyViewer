package com.nag.android.fairyviewer;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

class HourHandView extends ImageView {

	private float current = 0.0f;
	private float angle = 180.0f;
	public HourHandView(Context context) {
		super(context);
	}

	public HourHandView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public HourHandView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public void update(){
		float next = current + angle;
		ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(this
				, PropertyValuesHolder.ofFloat("rotation", current, next));
		objectAnimator.setDuration( 3000 );
		current = next%360;
		objectAnimator.start();
	}
}
