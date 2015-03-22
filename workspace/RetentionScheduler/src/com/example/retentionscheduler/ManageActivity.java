/*â€œThis is a course requirement for CS 192 Software Engineering II under the supervision of Asst. Prof. Ma. Rowena C. Solamo of the Department of Computer Science, College of Engineering, University of the Philippines, Diliman for the AY 2014-2015â€�.
 Neil Jonathan A. Joaquin
 David Relao
 Aldrin Simpao*/
/*Code History:
Initial Code Authored by: Neil Jonathan A. Joaquin, David Relao
Version 2.0 Authored by: Neil Jonathan A. Joaquin
     Added Manage, Calendar*/
/* File Creation Date:
    Development Group: Blue Navy Inc.
    Client Group: Purple McShort Shorts
    Purpose of file: Manages Activity, Displays Calendar
*/
package com.example.retentionscheduler;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
//import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;


public class ManageActivity extends ActionBarActivity implements OnClickListener {
	
	private Button create_button;
	private Button delete_button;
	

     /*
     Method name: onCreate
     Purpose: Sets the xml. Creates the clickable buttons
     Calling Arguments:Bundle savedInstanceState
     Required Files:
     Database Tables:
     Return value: None
     */
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.manage);
          create_button = (Button)findViewById(R.id.createbutton);
          create_button.setOnClickListener(this);
          delete_button = (Button)findViewById(R.id.deletebutton);
          delete_button.setOnClickListener(this);
    }

     /*
     Method name: onClick
     Purpose: Links the clickable buttons to their associated activity
     Calling Arguments: View v
     Required Files:
     Database Tables:
     Return value: None
     */
	
	public void onClick(View v){
		if(v.getId()==create_button.getId()){
			//the button was clicked
			Intent intent = new Intent(this, CreateEvent.class);
			startActivity(intent);
		}else if(v.getId()== delete_button.getId()){
			Intent intent = new Intent(this, Delete.class);
			startActivity(intent);
		}
    }
	
	
	
	/*public void initiatePopupWindow() {
		try {
			// We need to get the instance of the LayoutInflater
			LayoutInflater inflater = (LayoutInflater) MainActivity2.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View layout = inflater.inflate(R.layout.popup,(ViewGroup) findViewById(R.id.popup_element));
			pwindo = new PopupWindow(layout, 720, 1130, true);
			pwindo.showAtLocation(layout, Gravity.BOTTOM, 0, 0);
	
			assocButt = (Button) layout.findViewById(R.id.btn_close_popup);
			assocButt.setOnClickListener(cancel_button_click_listener);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public OnClickListener cancel_button_click_listener = new OnClickListener() {
		public void onClick(View v) {
			pwindo.dismiss();
			//getEditText(file1, file2, file3);
		}
	};
	
	public void getEditText(EditText file1, EditText file2, EditText file3) {
		stringBuilder.append(file1.getText()+"\n");
		stringBuilder.append(file2.getText()+"\n");
		stringBuilder.append(file3.getText()+"\n");
		System.out.println(stringBuilder.toString());
	}*/
	
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
