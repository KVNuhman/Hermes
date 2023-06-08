package com.shopNest.customer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		
		 boolean logStatus = Validator.isValid(uname,pass);

			try {
				if(logStatus == true && uname.equals("admin")) 
					 res.sendRedirect("admin.jsp");
				
				 else if(logStatus == true) {
					 HttpSession session = req.getSession();
					 session.setAttribute("user", "valuser");
					 res.sendRedirect("home.jsp");
				 }
				 else {
					 System.out.println();
					 res.sendRedirect("login.jsp");
				 }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Invalid login credentials");
				e.printStackTrace();
			}
	}

}
