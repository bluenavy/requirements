/*“This is a course requirement for CS 192 Software Engineering II under the supervision of Asst. Prof. Ma. Rowena C. Solamo of the Department of Computer Science, College of Engineering, University of the Philippines, Diliman for the AY 2014-2015”.
 Neil Jonathan A. Joaquin
 David Relao
 Aldrin Simpao*/
/*Code History:
Initial Code Authored by: Neil Jonathan A. Joaquin, David Relao*/
/* File Creation Date:
    Development Group: Blue Navy Inc.
    Client Group:
    Purpose of file: Object that writes and reads from a text file
*/
package com.example.retentionscheduler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
//import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.content.Context;
//import android.util.Log;
import android.widget.EditText;
//import android.util.Log;

public class DataAccessObject{
	
     static Context fileContext;
	String receiveString = "";
     StringBuilder stringBuilder = new StringBuilder();
     StringBuilder global = new StringBuilder();
	
	DataAccessObject (Context fileContext) {
		DataAccessObject.fileContext = fileContext;
	}

     /*
     Method name: writeFile
     Purpose: Writes the data on a textfile
     Calling Arguments:EditTex
     Required Files:
     Database Tables:
     Return value: None
     */

	public void writeFile(EditText name, EditText description, EditText date, EditText time, String files) {
		try {
			FileOutputStream fos = fileContext.openFileOutput("database.txt", Context.MODE_PRIVATE);
			OutputStreamWriter myOutWriter = new OutputStreamWriter(fos);
			
			myOutWriter.append(name.getText().toString());
			myOutWriter.append("\n");
			global.append(name.getText().toString());

			myOutWriter.append(description.getText().toString());
			myOutWriter.append("\n");
			global.append(description.getText().toString());

			myOutWriter.append(date.getText().toString());
			myOutWriter.append("\n");
			global.append(date.getText().toString());

			myOutWriter.append(time.getText().toString());
			myOutWriter.append("\n");
			global.append(time.getText().toString());
			
			myOutWriter.append(files);
			myOutWriter.append("\n");
			global.append(files);
				
			
			myOutWriter.close();
			fos.close();
			System.out.println("Write SUCCESS!");
		}
		catch (Exception e) {
//			System.out.println("Error? "+Log.getStackTraceString(e));
		};
	}

     /*
     Method name: onClick
     Purpose: Creates the clickable buttons
     Calling Arguments:
     Required Files:
     Database Tables:
     Return value: None
     */

	public void readFile() throws FileNotFoundException{
		InputStream inputStream = fileContext.openFileInput("database.txt");
		String current="";
          BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

		try {
			if (inputStream != null) {
				while (((receiveString = bufferedReader.readLine()) != null)) {
					stringBuilder.append(receiveString+"\n");
				}
			}
		}
		catch(Exception e){

		}finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
					current = stringBuilder.toString();
				}
			} catch (Exception e) {}
		}
		current += "\n\n";
		System.out.println(current);
	}


}
