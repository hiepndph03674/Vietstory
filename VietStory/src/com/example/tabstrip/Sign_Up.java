package com.example.tabstrip;

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

import com.example.vietstory.MainActivity;
import com.example.vietstory.R;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sign_Up extends Activity {
	EditText edt1,edt2;
	Button btn1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_up);
		edt1 = (EditText) findViewById(R.id.edtUser);
		edt2 = (EditText) findViewById(R.id.edtPass);
		btn1 = (Button) findViewById(R.id.button1);
		btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						new CallRegister().execute("http://10.0.2.2/vietstories/login.php");
						
					}
				});
				
			}
		});
	}
	class CallRegister extends AsyncTask<String, Integer, String>{
		@Override
		protected String doInBackground(String... params) {
			
			return makePostRequest(params[0],edt1.getText().toString(),edt2.getText().toString());
		}
		@Override
		protected void onPostExecute(String result) {
			Toast.makeText(Sign_Up.this, result, Toast.LENGTH_LONG).show();
			if(result.equals("dang ky thanh cong")){
				Intent myintent = new Intent(Sign_Up.this,MainActivity.class);
				startActivity(myintent);
			}
		}
		
	}
	private String makePostRequest(String u,String user,String password) {
	    HttpClient httpClient = new DefaultHttpClient();
	    
	    // URL của trang web nhận request
	    HttpPost httpPost = new HttpPost(u);
	    
	    // Các tham số truyền
	    List nameValuePair = new ArrayList(3);
	    nameValuePair.add(new BasicNameValuePair("action", "register"));
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
}
