package com.example.interactivenewtonslaws;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class First_Animation extends Activity {
	String law_number = new String();
	TextView message_1;
//	TextView message_2;
	TextView message_3;
	
	@SuppressLint("NewApi")
	public void firstAnimation(){
//		float x_value_ball1 = findViewById(R.id.img_ball1).getX();
//		float x_value_ball2 = findViewById(R.id.img_ball2).getX();
//		System.out.println(x_value_ball1 + " -  " + x_value_ball2);
//		findViewById(R.id.img_ball1).animate().translationX(350).withEndAction(new Runnable(){
//			  public void run(){
//			    findViewById(R.id.img_ball2).animate().translationX(300).withLayer();
//			  }
//			});
//		
		message_1 = (TextView) findViewById(R.id.message_1);
		message_1.setText("The first ball hits the second ball and applies a force on it");
		ViewPropertyAnimator first_img_anim = findViewById(R.id.img_ball1).animate();
		//first_img_anim.setStartDelay(500);
		first_img_anim.setDuration(1500);
		first_img_anim.translationX(160);
		first_img_anim.setStartDelay(1000);
		//first_img_anim.setListener(l);
		first_img_anim.setListener(new AnimatorListener() {
			
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
				
				message_1.setText("");
//				message_2 = (TextView) findViewById(R.id.message_2);
//				message_2.setText("First ball applies force to second ball");
				ViewPropertyAnimator second_img_anim = findViewById(R.id.img_ball2).animate();
				second_img_anim.setDuration(500);
				//second_img_anim.setStartDelay(2000);
				second_img_anim.translationX(220);
				//second_img_anim.setListener(l2);
				second_img_anim.setListener(new AnimatorListener() {
					
					@Override
					public void onAnimationStart(Animator animation) {
						// TODO Auto-generated method stub
						//message_2.setText("First ball applies force to second ball");
//						message_3.setText("");
						
					}
					
					@Override
					public void onAnimationRepeat(Animator animation) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationEnd(Animator animation) {
						// TODO Auto-generated method stub
//						message_2.setText("First ball applies force to second ball");
						message_3 = (TextView) findViewById(R.id.message_3);
						message_3.setText("Now, the second ball moves some distance");
						
					}
					
					@Override
					public void onAnimationCancel(Animator animation) {
						// TODO Auto-generated method stub
						
					}
				});
				second_img_anim.start();
				
			}
			
			@Override
			public void onAnimationCancel(Animator animation) {
				// TODO Auto-generated method stub
				
			}
		});
		first_img_anim.start();
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first_animation);
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
		
		
		firstAnimation();
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
		getMenuInflater().inflate(R.menu.law__animation, menu);
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