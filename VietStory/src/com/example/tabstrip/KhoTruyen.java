package com.example.tabstrip;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.vietstory.R;

public class KhoTruyen extends Fragment {
	public KhoTruyen(){}
	final String[] arr={"A","B","C","D"};
	final String[] arr2={"1221","1234","1789","4321"};
	ListView lv;
	TextView txt1,txt2;
	ArrayAdapter<String> adapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.khotruyen, container, false);
		lv = (ListView)v.findViewById(R.id.listview_lv);
		lv.setAdapter(new CustomsAdapter(getActivity(),R.layout.row,arr));
		lv.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				Intent in = new Intent(getActivity(),ReadingBook.class);
				startActivity(in);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		return v;
	}
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
	class CustomsAdapter extends ArrayAdapter{
		 public CustomsAdapter(Context context, int resource, String[] objects) {
	            super(context, resource, objects);
	        }
		 @Override
	        public View getView(int position, View convertView, ViewGroup parent) {
	            View v=((Activity)getContext()).getLayoutInflater().inflate(R.layout.row,null);
	            txt1 = (TextView) v.findViewById(R.id.tv_title);
	            txt2 = (TextView) v.findViewById(R.id.tv_View);
	            txt1.setText(arr[position]);
	            txt2.setText(arr2[position]);
	            ImageView img = (ImageView) v.findViewById(R.id.imgIma);
				
	            

	            return v;
	        }
	}
}
