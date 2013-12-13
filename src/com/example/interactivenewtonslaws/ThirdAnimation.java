package com.example.interactivenewtonslaws;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class ThirdAnimation extends Activity {
	TextView message;
	@SuppressLint("NewApi")
	public void thirdAnimation(){
		message = (TextView) findViewById(R.id.third_message);
		message.setText("The ball makes an action on the wall");
		ViewPropertyAnimator ball_action = findViewById(R.id.img_ball).animate();
		//first_img_anim.setStartDelay(500);
		ball_action.setDuration(1500);
		ball_action.translationX(417);
		ball_action.setStartDelay(500);
		ball_action.setListener(new AnimatorListener() {
			
			@Override
			public void onAnimationStart(Animator animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animator animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animator animation) {
				// TODO Auto-generated method stub
				message.setText("Now the wall makes reaction on the ball");
				ViewPropertyAnimator wall_reaction = findViewById(R.id.img_ball).animate();
				wall_reaction.setDuration(4000);
				//second_img_anim.setStartDelay(2000);
				wall_reaction.translationX(-1);
//				wall_reaction.translationXBy((float) -1);
				//second_img_anim.setListener(l2);
				wall_reaction.setListener(new AnimatorListener() {
					
					@Override
					public void onAnimationStart(Animator animation) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationRepeat(Animator animation) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationEnd(Animator animation) {
						// TODO Auto-generated method stub
						message.setText("Ball is pushed backward by the wall");
						
					}
					
					@Override
					public void onAnimationCancel(Animator animation) {
						// TODO Auto-generated method stub
						
					}
				}); 
				
			}
			
			@Override
			public void onAnimationCancel(Animator animation) {
				// TODO Auto-generated method stub
				
			}
		});

	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third_animation);
		// Show the Up button in the action bar.
		setupActionBar();
		
		Button button_home = (Button)findViewById(R.id.button_home);
		button_home.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
            	Intent intent = new Intent(view.getContext(), MainActivity.class);
            	startActivity(intent);
            }			
        });
		
		thirdAnimation();
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.third_animation, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
