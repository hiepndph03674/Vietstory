package com.example.vietstory;

import com.example.adapter.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class Test extends Activity {
	String t="";
	String t2="";
	int i  = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		SaveUser db = new SaveUser(this);     
	        for (User cn : db.getAllContacts()) {
	        	t = cn.getID()+" - id "+cn.getName()+" pass "+cn.getPhoneNumber();
	        	i++;
	        }
	        Toast.makeText(this, t+" cout:"+i, Toast.LENGTH_LONG).show();
	       db.logOut();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test, menu);
		return true;
	}

}
