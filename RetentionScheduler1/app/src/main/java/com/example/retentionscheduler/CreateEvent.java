package com.example.retentionscheduler;

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
	
	DataAccessObject dao = new DataAccessObject(this);
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
	
	public void onClick(View v){
        //respond to click
		if (v.getId() == R.id.add_events) {
			try {
				dao.writeFile(name, description, date, time, stringBuilder.toString());
				dao.readFile();
				Toast.makeText(CreateEvent.this, "Event Added!",Toast.LENGTH_LONG).show();
				Intent intent = new Intent(this, viewInfo.class);
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
