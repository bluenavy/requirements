package com.example.retentionscheduler;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
//import android.view.MenuItem;


public class MainActivity extends ActionBarActivity implements OnClickListener {
	 CalendarView calendarView;
	 private Button button_manage;
	 private Button button_viewevents;
	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.home);
		  button_manage = (Button)findViewById(R.id.manage);
		  button_manage.setOnClickListener(this);

		calendarView=(CalendarView) findViewById(R.id.calendarView1);
		calendarView.setOnDateChangeListener(new OnDateChangeListener() {
			long selected = calendarView.getDate();
			@Override
			public void onSelectedDayChange(CalendarView view, int year, int month,
					int dayOfMonth) {
				//Toast.makeText(getApplicationContext(), ""+selected, 0).show();// TODO Auto-generated method stub
				if(selected != view.getDate()){
						selected=view.getDate();
						 Intent intent1=new Intent(MainActivity.this,ManageActivity.class);
						 startActivity(intent1);
				}
			}
		});
	}

	public void onClick(View v){
		//respond to click
		if(v.getId()==button_manage.getId()){
			//the button was clicked
			Intent intent = new Intent(this, ManageActivity.class);
			startActivity(intent);
		}
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}