package com.example.interactivenewtonslaws;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class Second_Animation extends Activity {

	@SuppressLint("NewApi")
	public void showMessage(){
		View b = findViewById(R.id.button_continue);
		TextView message = (TextView)findViewById(R.id.text_message);
		message.setText("When the force is less, the ball travels slowly and covers a small distance");
		
		b.setVisibility(View.VISIBLE);

	};
	
	
	@SuppressLint("NewApi")
	public void secondAnimation(){
		
		ViewPropertyAnimator first_foot_anim = findViewById(R.id.foot_1).animate();
		//first_img_anim.setStartDelay(500);
		first_foot_anim.setDuration(1500);
		first_foot_anim.translationX(110);
		first_foot_anim.setStartDelay(500);
		//first_img_anim.setListener(l);
		first_foot_anim.setListener(new AnimatorListener() {
			
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
				ViewPropertyAnimator first_ball_anim = findViewById(R.id.ball_1).animate();
				//first_img_anim.setStartDelay(500);
				first_ball_anim.setDuration(2000);
				first_ball_anim.translationX(220);
				//first_ball_anim.setStartDelay(1000);
				first_ball_anim.setListener(new AnimatorListener() {
					
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
						showMessage();
						
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
		setContentView(R.layout.activity_second_animation);
		// Show the Up button in the action bar.
		setupActionBar();
		
		View b = findViewById(R.id.button_continue);
		b.setVisibility(View.INVISIBLE);
	
		
		/*Event handler for third law button*/
		Button button_continue = (Button)findViewById(R.id.button_continue);
		button_continue.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
            	Intent intent = new Intent(view.getContext(), SecondAnimationContinued.class);
    			startActivity(intent);
            }			
        });
		
		secondAnimation();
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
		getMenuInflater().inflate(R.menu.second__animation, menu);
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
