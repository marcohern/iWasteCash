package com.rocketteam.iwastecash.model;

import java.util.ArrayList;

import com.rocketteam.iwastecash.R;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class PurchaseAdapter extends ArrayAdapter<Purchase> {
	public PurchaseAdapter(Context context, ArrayList<Purchase> purchases) {
		super(context,0,purchases);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Activity activity = (Activity)getContext();
		if (convertView == null) {
			convertView = activity.getLayoutInflater().inflate(R.layout.fragment_purchase_list_item, null);
		}
		Purchase p = getItem(position);
		
		TextView title = (TextView)convertView.findViewById(R.id.purchase_list_item_title);
		
		title.setText(p.getCategory());
		
		return convertView;
	}
}
