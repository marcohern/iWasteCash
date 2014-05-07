package com.rocketteam.iwastecash.model;

import java.util.ArrayList;
import java.util.Date;

public interface IDataAccess {
	ArrayList<Purchase> getAllPurchases();
	ArrayList<Purchase> getPurchasesBefore(Date date);
	ArrayList<Purchase> getPurchasesAfter(Date date);
	ArrayList<Purchase> getPurchasesBetween(Date start, Date end);
}
