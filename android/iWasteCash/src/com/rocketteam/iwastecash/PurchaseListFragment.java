package com.rocketteam.iwastecash;

import java.util.ArrayList;

import com.rocketteam.iwastecash.model.IwasteCash;
import com.rocketteam.iwastecash.model.Purchase;
import com.rocketteam.iwastecash.model.PurchaseAdapter;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PurchaseListFragment extends ListFragment {
	public static String TAG = "com.rocketteam.iwastecash.PurchaseListFragment"; 
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.d(TAG,"onCreate");
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		ArrayList<Purchase> purchases = IwasteCash.get().getAllPurchases();
		
		PurchaseAdapter adapter = new PurchaseAdapter(getActivity(), purchases);
		setListAdapter(adapter);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	
}
