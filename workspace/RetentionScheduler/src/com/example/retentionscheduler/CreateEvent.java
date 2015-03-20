/*â€œThis is a course requirement for CS 192 Software Engineering II under the supervision of Asst. Prof. Ma. Rowena C. Solamo of the Department of Computer Science, College of Engineering, University of the Philippines, Diliman for the AY 2014-2015â€�.
 Neil Jonathan A. Joaquin
 David Relao
 Aldrin Simpao*/
/*Code History:
Initial Code Authored by: Neil Jonathan A. Joaquin, David Relao
Changes made authored by David Relao: added intent functionality, dao implementations*/
/* File Creation Date: CS 191 days
    Development Group: Blue Navy Inc.
    Client Group: Purple McShort Shorts
    Purpose of file: Creates the Event and save it in a text file.
*/
package com.example.retentionscheduler;

//import android.content.Context;
import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;


public class CreateEvent extends ActionBarActivity implements OnClickListener {
	
	Button theButton;
	Button assocButt;
	EditText name;
	EditText description;
	EditText date;
	EditText time;
	EditText file1;
	EditText file2;
	EditText file3;	
	StringBuilder stringBuilder = new StringBuilder();
	String dates;
	
	DataAccessObject dao = new DataAccessObject(this);
	

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
          setContentView(R.layout.create_event);
          name = (EditText) findViewById(R.id.event_name);
		description = (EditText) findViewById(R.id.description_name);
		date = (EditText) findViewById(R.id.dated);
		time = (EditText) findViewById(R.id.time);
		file1 = (EditText) findViewById(R.id.file);
		file2 = (EditText) findViewById(R.id.file1);
		file3 = (EditText) findViewById(R.id.file2);
		
          theButton = (Button)findViewById(R.id.add_events);
          theButton.setOnClickListener(this);
          assocButt = (Button) findViewById(R.id.associate_notes);
          assocButt.setOnClickListener(this);
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
          //respond to click
		if (v.getId() == R.id.add_events) {
			try {
				dates = dao.writeFile(name, description, date, time, stringBuilder.toString());
				Toast.makeText(CreateEvent.this, "Event Added!",Toast.LENGTH_LONG).show();
				dao.getTitles().add(name.getText().toString());
				dao.getDates().add(date.getText().toString());
				Intent intent = new Intent(this, MainActivity.class);
				intent.putExtra("eventTitle", name.getText().toString());
				intent.putExtra("dates", dates);
				intent.putStringArrayListExtra("titleArray", dao.getTitles());
				intent.putStringArrayListExtra("dateArray", dao.getDates());
				//System.out.println("titles.size() = "+dao.getSize(dao.getTitles())/2);
				startActivity(intent);
			}catch (Exception e) {
				System.out.println(Log.getStackTraceString(e));
			}
		}
		else if (v.getId() == R.id.associate_notes) {
			if (file1.getText() != null) {
				stringBuilder.append(file1.getText().toString()+"\n");
			}
			if (file2.getText() != null) {
				stringBuilder.append(file2.getText().toString()+"\n");
			}
			if (file3.getText() != null) {
				stringBuilder.append(file3.getText().toString()+"\n");
			}
			Toast.makeText(CreateEvent.this, "Files Associated!",Toast.LENGTH_LONG).show();
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