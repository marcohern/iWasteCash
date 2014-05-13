package com.rocketteam.iwastecash;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PurchaseFragment extends Fragment {
	
	public static PurchaseFragment newFragment() {
		return null;
	}
	
	public PurchaseFragment() {
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment_purchase_list, container, false);
		return v;
	}
}
