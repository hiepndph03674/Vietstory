package com.example.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.tabstrip.AboutUs;
import com.example.tabstrip.KhoTruyen;
import com.example.tabstrip.ThongTin;
import com.example.tabstrip.TrangChu;
import com.example.tabstrip.YeuThich;

public class ViewPagerAdapter extends FragmentPagerAdapter{
	final int PAGE_COUNT =5;
	private String tabtitles[] = new String[] { "Trang Chủ", "Yêu Thích", "Kho Truyện", "About Us", "Thông Tin" };
	Context context;
	public ViewPagerAdapter(FragmentManager fm) {
		super(fm);
		
	}
	

	@Override
	public Fragment getItem(int position) {
		
		switch (position) {
		case 0:
			TrangChu tab1 = new TrangChu();
			return tab1;

			// Open FragmentTab2.java
		case 1:
			YeuThich tab2 = new YeuThich();
			return tab2;

			// Open FragmentTab3.java
		case 2:
			KhoTruyen tab3 = new KhoTruyen();
			return tab3;
		case 3:
			AboutUs tab4 = new AboutUs();
			return tab4;
		case 4:
			ThongTin tab5 = new ThongTin();
			return tab5;
		}
		return null;
	}

	@Override
	public int getCount() {
		
		return PAGE_COUNT;
	}
	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		return tabtitles[position];
	}
}
