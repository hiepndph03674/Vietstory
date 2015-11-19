package com.example.vietstory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tabstrip.Sign_Up;
import com.example.tabstrip.TabStrips;


public class MainActivity extends Activity {
	EditText edt1,edt2;
	Button btn1,btn2;
	String t="";
	int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = (EditText)findViewById(R.id.edtUserL);
        edt2 = (EditText)findViewById(R.id.edtPassL);
        SaveUser db1 = new SaveUser(getApplication());
        //kiem tra user
        for (User cn : db1.getAllContacts()) {
        	t = cn.getID()+" - id "+cn.getName()+" pass "+cn.getPhoneNumber();
        	i++;
        }
        //Toast.makeText(this, t+" cout:"+i, Toast.LENGTH_LONG).show();
        
        if(i!=0){
        	Intent in = new Intent(MainActivity.this,TabStrips.class);
			startActivity(in);
        }
        btn1 = (Button) findViewById(R.id.btnDangNhap);
        btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						new CallLogin().execute("http://10.0.2.2/vietstories/login.php");
						
					}
				});
				
			}
		});
        btn2 = (Button)findViewById(R.id.btnDangKy);
        btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent myintent = new Intent(MainActivity.this,Sign_Up.class);
				startActivity(myintent);
				
			}
		});
    }
    class CallLogin extends AsyncTask<String, Integer, String>{
		@Override
		protected String doInBackground(String... params) {
			
			return makePostRequest(params[0],edt1.getText().toString(),edt2.getText().toString());
		}
		@Override
		protected void onPostExecute(String result) {
			Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
			if(result.equals("dang nhap thanh cong")){
				SaveUser db = new SaveUser(getApplication());
				db.addContact(new User(edt1.getText().toString(),edt2.getText().toString())); 
				Intent in1 = new Intent(MainActivity.this,TabStrips.class);
				startActivity(in1);	
			}
			
		}
		
	}
	private String makePostRequest(String u,String user,String password) {
	    HttpClient httpClient = new DefaultHttpClient();
	    
	    // URL của trang web nhận request
	    HttpPost httpPost = new HttpPost(u);
	    
	    // Các tham số truyền
	    List nameValuePair = new ArrayList(3);
	    nameValuePair.add(new BasicNameValuePair("action", "login"));
	    nameValuePair.add(new BasicNameValuePair("user", user));
	    nameValuePair.add(new BasicNameValuePair("password", password));
	    
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
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.main, menu);
        return true;
	}
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
		case R.id.id_closer:
			Intent in = new Intent(MainActivity.this,TabStrips.class);
			startActivity(in);
			break;
		default:
			break;
		}
    	return super.onOptionsItemSelected(item);
    }
}
