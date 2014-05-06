package com.rocketteam.iwastecash.model;

import java.math.BigDecimal;
import java.util.ArrayList;

import android.util.Log;

import com.rocketteam.iwastecash.exceptions.IwasteCashException;

public class IwasteCash {
	public static String TAG = "com.rocketteam.iwastecash.model.IwasteCash";
	private static IwasteCash instance = null;
	
	private ArrayList<Purchase> purchases;
	
	private IwasteCash() {
		purchases = new ArrayList<Purchase>();
	}
	
	public static IwasteCash get() {
		if (instance == null) {
			instance = new IwasteCash();
		}
		return instance;
	}
	
	public void addPurchase(Purchase purchase) {
		purchases.add(purchase);
	}
	
	public Purchase getPurchase(int index) {
		if (index < purchases.size()) {
			return purchases.get(index);
		}
		return null;
	}
	
	public void RunTest() {
		BigDecimal total = new BigDecimal(10);
		Purchase p = new Purchase("Casual","These are the comments", total, BigDecimal.ZERO, "COP");
		Log.w(TAG, p.getJson().toString());
		
		String json = "{\"amountTotal\":34.95,\"id\":\"36d1fb49-8e53-436d-a85a-a3d381dedfdb\",\"category\":\"Casual\",\"currencyCode\":\"COP\",\"order\":0,\"created\":\"5/5/14 3:58 PM\",\"amountOffset\":0,\"comments\":\"These are the other comments\"}";
		try {
			Purchase p2 = Purchase.fromJson(json);
			Log.w(TAG, p2.getJson().toString());
		} catch (IwasteCashException e) {
			e.printStackTrace();
		}
	}
}
