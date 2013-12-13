package com.example.interactivenewtonslaws;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/*Event handler for first law button*/
		Button button_law_1 = (Button)findViewById(R.id.button_law_action);
		button_law_1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
            	Intent intent = new Intent(view.getContext(), LawDisplay.class);
            	intent.putExtra("law_number","1");
    			startActivity(intent);
            }			
        });
		
		/*Event handler for second law button*/
		Button button_law_2 = (Button)findViewById(R.id.button_law2);
		button_law_2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
            	Intent intent = new Intent(view.getContext(), LawDisplay.class);
            	intent.putExtra("law_number","2");
    			startActivity(intent);
            }			
        });
	
		
		/*Event handler for third law button*/
		Button button_law_3 = (Button)findViewById(R.id.button_law3);
		button_law_3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
            	Intent intent = new Intent(view.getContext(), LawDisplay.class);
            	intent.putExtra("law_number","3");
    			startActivity(intent);
            }			
        });
		
		Button button_exit = (Button)findViewById(R.id.button_exit);
		button_exit.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
            	System.exit(0);
            }			
        });
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
