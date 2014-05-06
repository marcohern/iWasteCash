package com.rocketteam.iwastecash.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

public class MockDataAccess implements IDataAccess {
	
	ArrayList<Purchase> purchases;
	String[] categories = {
		"Casual", "Special", "Market", "Transport",
		"Car", "Breakfast", "Lunch", "Dinner"
	};
	
	public MockDataAccess() {
		purchases = new ArrayList<Purchase>();
		
		Calendar c = new GregorianCalendar(2012,1,1);
		Date dt;
		Date created;
		UUID id;
		int order;
		String comments, category;
		BigDecimal amountTotal, amountOffset = new BigDecimal(0);
		
		double d;
		int cati;
		String currencyCode = "COP";
		
		for (int i=0;i<100;i++) {
			dt = c.getTime();
			c.add(Calendar.HOUR, 1);
			c.add(Calendar.MINUTE, 10);
			
			id = UUID.randomUUID();
			created = dt;
			order = 0;
			comments = "Comment " + i;
			cati = (int)(categories.length * Math.random());
			category = categories[cati];
			d = 99 * Math.random();
			amountTotal = new BigDecimal(d);
			
			Purchase p = new Purchase(
				id, created, order, comments, category,
				amountTotal, amountOffset, currencyCode
			);
			purchases.add(p);
		}
	}

	@Override
	public ArrayList<Purchase> getAllPurchases() {
		return purchases;
	}

	@Override
	public ArrayList<Purchase> getPurchasesBefore(Date date) {
		ArrayList<Purchase> ps = new ArrayList<Purchase>();
		for (int i=0; i<purchases.size(); i++) {
			Purchase p = purchases.get(i);
			if (p.getCreated().before(date)) {
				ps.add(p);
			}
		}
		return ps;
	}

	@Override
	public ArrayList<Purchase> getPurchasesBetween(Date start, Date end) {
		ArrayList<Purchase> ps = new ArrayList<Purchase>();
		for (int i=0; i<purchases.size(); i++) {
			Purchase p = purchases.get(i);
			Date created = p.getCreated();
			if (created.after(start) && created.before(end)) {
				ps.add(p);
			}
		}
		return ps;
	}
}
