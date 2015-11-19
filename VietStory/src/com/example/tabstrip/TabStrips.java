package com.example.tabstrip;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.example.adapter.ViewPagerAdapter;
import com.example.vietstory.MainActivity;
import com.example.vietstory.R;
import com.example.vietstory.SaveUser;

public class TabStrips extends FragmentActivity {
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.tabstrip);
		ViewPager viewpager = (ViewPager)findViewById(R.id.pager);
        viewpager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.search_menu, menu);
        return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.id_search:
			
			break;
		case R.id.id_over:
			SaveUser db = new SaveUser(this);
			db.logOut();
			Intent in1 = new Intent(TabStrips.this,MainActivity.class);
			startActivity(in1);	
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
