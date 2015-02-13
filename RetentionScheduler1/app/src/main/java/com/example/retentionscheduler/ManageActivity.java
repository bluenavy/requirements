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


public class ManageActivity extends ActionBarActivity implements OnClickListener {
	
	private Button create_button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage);
        create_button = (Button)findViewById(R.id.createbutton);
        create_button.setOnClickListener(this);
    }
	
	public void onClick(View v){
		if(v.getId()==create_button.getId()){
    	    //the button was clicked
    		Intent intent = new Intent(this, CreateEvent.class);
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
