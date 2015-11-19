package com.example.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.vietstory.R;

public class CustomAdapter extends BaseAdapter {
	Context context;
	ArrayList<List> listview;
	LayoutInflater inflater;
	
	public CustomAdapter(Context context, ArrayList<List> listview){
		this.context = context;
		this.listview = listview;
		inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listview.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return listview.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
	public class Holder{
		TextView title;
		TextView subview;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Holder holder = new Holder();
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.row, parent,false);
			holder.title = (TextView)convertView.findViewById(R.id.tv_title);
			holder.subview = (TextView)convertView.findViewById(R.id.tv_View);
			convertView.setTag(holder);
		} else {
			holder = (Holder)convertView.getTag();
		}
		String title = listview.get(position).getTitle();
		String view = listview.get(position).getSubView();
		holder.title.setText(title);
		holder.subview.setText(view);
		
		return convertView;
	}
}
