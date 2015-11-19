package com.example.tabstrip;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vietstory.R;

public class AboutUs extends Fragment{
	public AboutUs(){}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.about_us, container, false);
		return v;
	}
}
