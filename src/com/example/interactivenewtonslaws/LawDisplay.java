package com.example.interactivenewtonslaws;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class LawDisplay extends Activity {
	
	String law_number = new String();
	public void setLawText(String law_number){
		TextView law_desc = (TextView) findViewById(R.id.text_view_law_desc);
		
		if(law_number.equals("1")){
			law_desc.setText("A body continues to be in a state of rest or of uniform motion unless an external force acts on it");
		}
		else if(law_number.equals("2")){
			law_desc.setText("The acceleration of a body is directly proportional to, and in the same direction as, the net force acting on the body, and it is inversely proportional to its mass. Hence, F=m*a");
		}
		else if(law_number.equals("3")){
			law_desc.setText("Every action has an equal and opposite reaction");
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_law_display);
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
		
		
		Bundle b = getIntent().getExtras();
		law_number = b.getString("law_number");
		setLawText(law_number);
		System.out.println(law_number);
		
		Button button_law_action = (Button)findViewById(R.id.button_law_action);
		button_law_action.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
            	if(law_number.equals("1")){
	            	Intent intent = new Intent(view.getContext(), First_Animation.class);
	            	intent.putExtra("law_number", law_number);
	    			startActivity(intent);
            	}

            	else if(law_number.equals("2")){
	            	Intent intent = new Intent(view.getContext(), Second_Animation.class);
	            	intent.putExtra("law_number", law_number);
	    			startActivity(intent);
            	}

            	else if(law_number.equals("3")){
	            	Intent intent = new Intent(view.getContext(), ThirdAnimation.class);
	            	intent.putExtra("law_number", law_number);
	    			startActivity(intent);
            	}
            }			
        });
		

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
		getMenuInflater().inflate(R.menu.law_display, menu);
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
