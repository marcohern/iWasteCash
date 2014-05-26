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
	
	@SuppressWarnings("deprecation")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Activity activity = (Activity)getContext();
		if (convertView == null) {
			convertView = activity.getLayoutInflater().inflate(R.layout.fragment_purchase_list_item, null);
		}
		Purchase pr = (position <= 0) ? null : getItem(position-1);
		Purchase p = getItem(position);
		
		TextView title = (TextView)convertView.findViewById(R.id.purchase_list_item_title);
		TextView subtitle = (TextView)convertView.findViewById(R.id.purchase_list_item_subtitle);
		TextView section = (TextView)convertView.findViewById(R.id.purchase_list_item_sectionTitle);
		
		
		title.setText(p.getCategory());
		subtitle.setText(p.getComments());
		
		int currDate = (p.getCreated().getYear() + 1900)*100 + p.getCreated().getMonth();
		section.setText("" + currDate);
		section.setVisibility(TextView.VISIBLE);
		if (pr != null) {
			
			int prevDate = (pr.getCreated().getYear() + 1900)*100 + pr.getCreated().getMonth();
			if (prevDate == currDate) {
				section.setVisibility(TextView.GONE);
			}
		}
		
		return convertView;
	}
}
