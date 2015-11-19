package com.example.tabstrip;

import com.example.vietstory.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class WriteBook extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.write_main);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.save_menu, menu);
        return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.id_save:
			Toast.makeText(getApplicationContext(), "Lưu Thành Công", Toast.LENGTH_LONG).show();
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
