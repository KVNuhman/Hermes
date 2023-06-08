package com.shopNest.dbHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataInjector {
	
	public static String addColumns(String uname, String mail, String pass,String gender, String address) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String un = "system";
		String password = "system";
		String sql = "INSERT INTO CUSTOMERS VALUES(?,?,?,?,?)";
		String regStatus = "";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,un,password);
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, uname);
			ps.setString(2, mail);
			ps.setString(3, pass);
			ps.setString(4, gender);
			ps.setString(5, address);
			
			ps.executeUpdate();
			regStatus = "success";
			
		}
		catch(Exception e) {
			System.out.println("Problem in adding customer");
			regStatus = "fail";
			e.printStackTrace();
		}
		finally {
			return regStatus;
		}
	}
	
	public static Boolean addProduct(int pid,String pname,String pdesc,int pprice,String pimg) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String un = "system";
		String password = "system";
		String sql = "INSERT INTO PRODUCTS VALUES(?,?,?,?,?)";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,un,password);
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, pid);
			ps.setString(2, pname);
			ps.setString(3, pdesc);
			ps.setInt(4, pprice);
			ps.setString(5, pimg);
			ps.executeUpdate();
			
		}
		catch(Exception e ) {
			System.out.println("Error entering data into Products");
			e.printStackTrace();
			return false;	
		}
		return true;
	}

}
