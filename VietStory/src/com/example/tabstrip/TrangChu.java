package com.example.tabstrip;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vietstory.R;



public class TrangChu extends Fragment {
	ArrayList<String> arrT,arrID,arrV;
	ListView lv;
	TextView txt1,txt2;
	String b  = "";
public TrangChu(){}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.trangchu, container, false);
		lv = (ListView)view.findViewById(R.id.listview_lv);
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					new docjson().execute("http://10.0.2.2/vietstories/loadTruyen.php");
					
				}
			}).start();
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				//Tạo Intent để mở ResultActivity
				 Intent myIntent=new Intent(getActivity(), ReadingBook.class);
				 //Khai báo Bundle
				 Bundle bundle=new Bundle();
				 int a=Integer.parseInt(arrID.get(arg2).toString());
				 String b=arrT.get(arg2).toString();
				 //đưa dữ liệu riêng lẻ vào Bundle
				 bundle.putInt("soa", a);
				 bundle.putString("sob", b);
				 //Đưa Bundle vào Intent
				 myIntent.putExtra("MyPackage", bundle);
				 //Mở Activity ResultActivity
				 startActivity(myIntent);
				//Toast.makeText(getActivity(), arg2+"", Toast.LENGTH_LONG).show();
			}
		});
		return view;

	}
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
	class CustomsAdapter extends ArrayAdapter{
		 public CustomsAdapter(Context context, int resource,ArrayList<String> objects) {
	            super(context, resource, objects);
	        }
		 @Override
	        public View getView(int position, View convertView, ViewGroup parent) {
	            View v=((Activity)getContext()).getLayoutInflater().inflate(R.layout.row,null);
	            txt1 = (TextView) v.findViewById(R.id.tv_title);
	            txt2 = (TextView) v.findViewById(R.id.tv_View);
	            txt1.setText(arrT.get(position));
	            txt2.setText(arrV.get(position));
	            ImageView img = (ImageView) v.findViewById(R.id.imgIma);
	            return v;
	        }
	}
	class docjson extends AsyncTask<String, Integer, String>{

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			return docNoiDung_Tu_URL(params[0]);
		}
		@Override
		protected void onPostExecute(String result) {
			arrT =  new ArrayList<String>();
			arrV =  new ArrayList<String>();
			arrID =  new ArrayList<String>();
			try{
				
				JSONArray m =  new JSONArray(result);
				for(int i = 0; i<m.length();i++){
					JSONObject t  =  m.getJSONObject(i);
					arrT.add(t.getString("tenTruyen"));
					arrID.add(t.getInt("id")+"");
					arrV.add(t.getInt("nView")+"");
				}
				//ArrayAdapter adapter  =  new ArrayAdapter (new CustomsAdapter(getActivity(),R.layout.row,arr));
				lv.setAdapter(new CustomsAdapter(getActivity(),R.layout.row,arrT));
			
			}catch(JSONException e){
				e.printStackTrace();
			}
		}
	}
	private static String docNoiDung_Tu_URL(String theUrl)
	{
	    StringBuilder content = new StringBuilder();

	    // many of these calls can throw exceptions, so i've just
	    // wrapped them all in one try/catch statement.
	    try
	    {
	        // create a url object
	        URL url = new URL(theUrl);

	        // create a urlconnection object
	        URLConnection urlConnection = url.openConnection();

	        // wrap the urlconnection in a bufferedreader
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

	        String line;

	        // read from the urlconnection via the bufferedreader
	        while ((line = bufferedReader.readLine()) != null)
	        {
	            content.append(line + "\n");
	        }
	        bufferedReader.close();
	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	    return content.toString();
	}
}
