package com.example.retentionscheduler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Delete extends ActionBarActivity implements OnClickListener{
	DataAccessObject dao = new DataAccessObject(this);
	EditText file1;
	String deletefile="";
	String temp="";
	String notdelete="";
	Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_delete);
		TextView view = (TextView) findViewById(R.id.textView2);
		file1 = (EditText) findViewById(R.id.editText1);
		button = (Button)findViewById(R.id.button1);
	     button.setOnClickListener(this);
		try{
			String data=dao.readFile("database");
			view.setText(data);
		}catch(Exception e){}
		
	}
		
	
	
	public void onClick(View v){
		if (v.getId() == R.id.button1) {
			try{
				String data=dao.readFile("database");
				if (file1.getText() != null) {
					deletefile=""+file1.getText().toString();
				}
				for(int a=0;a<data.length();a++){
					if(data.charAt(a)!='\n'){
						temp=temp+data.charAt(a);
					}else{
						temp="";
					}
					if(temp.equals(deletefile)){
						FileOutputStream fs1 = this.openFileOutput("database.txt", Context.MODE_PRIVATE);
						OutputStreamWriter myOutWriter1 = new OutputStreamWriter(fs1);
						for(int b=0;b<data.length();b++){
							if(data.charAt(b)!='\n'){
								notdelete=notdelete+data.charAt(b);
							}else if((data.charAt(b)=='\n') && !notdelete.equals(temp)){
								myOutWriter1.append(notdelete);
								myOutWriter1.append("\n");
								notdelete="";
							}else if(notdelete.equals(temp)){
								notdelete="";
							}
						}
						myOutWriter1.close();
						fs1.close();
					}
					String temp1=deletefile+".txt";
					File file = new File(temp1);
					boolean deleted = file.delete();
				}
			}catch(Exception e){}
			
		}
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is
		// present.
		getMenuInflater().inflate(R.menu.delete, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
