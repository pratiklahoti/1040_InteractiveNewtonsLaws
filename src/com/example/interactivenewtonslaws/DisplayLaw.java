package com.example.interactivenewtonslaws;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayLaw extends Activity {
	String law_number = new String();
	public void setLawText(String law_number){
		TextView law_desc = (TextView) findViewById(R.id.text_view_law_desc);
		
		if(law_number.equals("1")){
			law_desc.setText("A body continues to be in a state of rest or of uniform motion unless an external force acts on it");
		}
		else if(law_number.equals("2")){
			law_desc.setText("The acceleration of a body is directly proportional to, and in the same direction as, the net force acting on the body, and inversely proportional to its mass.");
		}
		else if(law_number.equals("3")){
			law_desc.setText("Every action has an equal and opposite reaction");
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_law);
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_law, menu);
		return true;
	}

}
