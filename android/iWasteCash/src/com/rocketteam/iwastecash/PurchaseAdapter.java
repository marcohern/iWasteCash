package com.rocketteam.iwastecash;

import java.util.ArrayList;

import com.rocketteam.iwastecash.model.Purchase;

import android.app.Activity;
import android.widget.ArrayAdapter;

public class PurchaseAdapter extends ArrayAdapter<Purchase> {

	public PurchaseAdapter(Activity activity, ArrayList<Purchase> purchases) {
		super(activity, 0, purchases);
		// TODO Auto-generated constructor stub
	}

}
