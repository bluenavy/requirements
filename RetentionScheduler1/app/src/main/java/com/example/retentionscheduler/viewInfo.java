/*“This is a course requirement for CS 192 Software Engineering II under the supervision of Asst. Prof. Ma. Rowena C. Solamo of the Department of Computer Science, College of Engineering, University of the Philippines, Diliman for the AY 2014-2015”.
 Neil Jonathan A. Joaquin
 David Relao
 Aldrin Simpao*/
/*Code History:
Initial Code Authored by: Neil Jonathan A. Joaquin, David Relao*/
/* File Creation Date:
    Development Group: Blue Navy Inc.
    Client Group:
    Purpose of file: Displays the event you created
*/
package com.example.retentionscheduler;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.widget.TextView;

public class viewInfo extends ActionBarActivity{

     DataAccessObject dao = new DataAccessObject(this);

      /*
     Method name: onCreate
     Purpose: Sets the xml. Creates the clickable buttons
     Calling Arguments:Bundle savedInstanceState
     Required Files:
     Database Tables:
     Return value: None
     */
	
	protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.event_information);
          TextView view = (TextView) findViewById(R.id.info);
          view.setText(dao.getString());
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
