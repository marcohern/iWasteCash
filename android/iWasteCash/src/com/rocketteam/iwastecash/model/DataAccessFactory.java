package com.rocketteam.iwastecash.model;

public class DataAccessFactory {
	
	private static IDataAccess da = null;
	
	public static IDataAccess getDataAccess() {
		if (da == null) {
			da = new MockDataAccess();
		}
		return da;
	}
}
