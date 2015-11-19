package com.example.tabstrip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vietstory.MainActivity;
import com.example.vietstory.R;
import com.example.vietstory.SaveUser;
import com.example.vietstory.User;

public class ReadingBook extends Activity{
	int a =0;
	String b ="";
	TextView txt1,txt2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.read_main);
		 Intent callerIntent=getIntent();
		 Bundle packageFromCaller=callerIntent.getBundleExtra("MyPackage");
		 a=packageFromCaller.getInt("soa");
		 b=packageFromCaller.getString("sob");
		 Toast.makeText(this, a+" "+b, Toast.LENGTH_LONG).show();
		 txt1 = (TextView) findViewById(R.id.heading);
		 txt2 = (TextView) findViewById(R.id.textView2);
		 txt1.setText(b);
		 runOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					new CallLogin().execute("http://10.0.2.2/vietstories/read.php");
					
				}
			});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.write_menu, menu);
        return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.id_write:
			Intent in = new Intent(ReadingBook.this,WriteBook.class);
			startActivity(in);
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	class CallLogin extends AsyncTask<String, Integer, String>{
		@Override
		protected String doInBackground(String... params) {
			return makePostRequest(params[0],a+"");
		}
		@Override
		protected void onPostExecute(String result) {
			txt2.setText(result);
		}
		
	}
	private String makePostRequest(String u,String id) {
	    HttpClient httpClient = new DefaultHttpClient();
	    
	    // URL của trang web nhận request
	    HttpPost httpPost = new HttpPost(u);
	    
	    // Các tham số truyền
	    List nameValuePair = new ArrayList(2);
	    nameValuePair.add(new BasicNameValuePair("id", id));
	    nameValuePair.add(new BasicNameValuePair("view", "1"));
	    
	    //Encoding POST data
	    try {
	        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    }

	    String kq = "";
	    try {
	        HttpResponse response = httpClient.execute(httpPost);
	        HttpEntity entity = response.getEntity();
	        kq = EntityUtils.toString(entity);
	    } catch (ClientProtocolException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return kq;
	}
}
