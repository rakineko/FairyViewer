package com.nag.android.fairyviewer;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

class HourHandView extends ImageView {

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
		ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(this
				, PropertyValuesHolder.ofFloat("rotate", 0.0f, 360.0f)); 
		objectAnimator.setDuration( 3000 );
		objectAnimator.start();
	}
}
