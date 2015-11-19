package com.example.tabstrip;

import com.example.vietstory.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ThongTin extends Fragment{
	public ThongTin(){}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.thongtin, container, false);
		return v;
	}
}
