package com.shopNest.dbHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shopNest.product.Product;

public class DataFetcher {
	
	public static String fetchPass(String uname) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String un = "system";
		String password = "system";
		String sql = "SELECT PASS FROM CUSTOMERS WHERE UNAME = ?";
		String dbPass = "";
		ResultSet rs = null;
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,un,password);
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, uname);
			rs = ps.executeQuery();
			if(rs.next()) {
				dbPass = rs.getString(1);
			}
		}
		catch(Exception e) {
			System.out.println("Problem fetching customer");
			e.printStackTrace();
		}
		return dbPass;
	}
	
	public static List userInfo() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String un = "system";
		String password = "system";
		String sql = "SELECT UNAME, MAIL, GENDER, ADDRESS FROM CUSTOMERS";
		ResultSet rs = null;
		List ulist = new ArrayList();
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,un,password);
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String temp = rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(3)+":"+rs.getString(4);
				ulist.add(temp);
			}
			
		}
		catch(Exception e) {
			System.out.println("Problem fetching customer data");
			e.printStackTrace();
		}
		return ulist;
	}
	
	public static List productInfo() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String un = "system";
		String password = "system";
		String sql = "SELECT PID, PNAME, PDESC, PPRICE, PIMG FROM PRODUCTS";
		ResultSet rs = null;
		List plist = new ArrayList();
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,un,password);
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String temp = rs.getInt(1)+":"+rs.getString(2)+":"+rs.getString(3)+":"+rs.getInt(4)+":"+rs.getString(5);
				plist.add(temp);
			}
			
		}
		catch(Exception e) {
			System.out.println("Problem fetching product data");
			e.printStackTrace();
		}
		return plist;
	}
	
	public static Product getProductById(int pid) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String un = "system";
		String password = "system";
		String sql = "SELECT PNAME, PPRICE,PIMG FROM PRODUCTS WHERE PID = ?";
		ResultSet rs = null;
		Product product = null;
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,un,password);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, pid);
			rs = ps.executeQuery();
			rs.next();
			String pname = rs.getString(1);
			int pprice = rs.getInt(2);
			String pimg = rs.getString(3);
			product = new Product(pid, pname, pprice, pimg);
		}
		catch(Exception e) {
			System.out.println("Error geting product for cart");
			e.printStackTrace();
		}
		return product;
	}
}
