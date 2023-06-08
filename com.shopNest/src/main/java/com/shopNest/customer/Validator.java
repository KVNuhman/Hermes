package com.shopNest.customer;

import com.shopNest.dbHandler.DataFetcher;

public class Validator {
	
	public static Boolean isValid(String uname, String pass) {
		String dbPass = DataFetcher.fetchPass(uname);
		if(pass.equals(dbPass))
			return true;
		else
			return false;
	}
}
