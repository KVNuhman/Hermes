<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.shopNest.product.Cart" %>
<%@ page import = "com.shopNest.product.Product" %>
<%@page import="java.util.List"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Hermes-homes</title>
    <link rel = "stylesheet" href="Styles.css" type="text/css" />
    <script src="https://kit.fontawesome.com/87764f93a3.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lavishly+Yours&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
</head>

<title>Insert title here</title>
</head>
<body>
	
	<%
		response.setHeader("Cache-Control", "no-cahe, no-store,must-revalidate");
		if(session.getAttribute("user") == null)
			response.sendRedirect("login.jsp");
		Cart c = (Cart)session.getAttribute("cart");
		List itemsList = c.getItems();
	%>
	
	<header id = "topbar">
    	<nav>  
        	<div id = "left-menu">
            	<p id = "logo"><a href = "home.jsp">Hermes</a></p>
            </div>
            <div id = 'right-menu'>
            	<div id = :search-container>
                	<input type = "text" id = "search-box">
               	</div>
                  <span id = "cart" class="material-symbols-outlined"><a href = "cart.jsp">shopping_cart</a></span>
                    <span id = "logout" class="material-symbols-outlined"><a href = "./logOut">logout</a></span>
           	</div>
		</nav>
	</header>
	<main>
		<div class="product-container">
			<%
				for(int i=0; i<itemsList.size(); i++) {
					String p=((Product)(itemsList.get(i))).getpName();
			%>
			<div class="product-card">
		  		<img src="prodimg/<%= ((Product)(itemsList.get(i))).getpImg() %>" alt="Product Name" class="product-image">
		  		<h3 class="product-name"><%= ((Product)(itemsList.get(i))).getpName() %></h3>
	  			<div class="product-price">RS<%= ((Product)(itemsList.get(i))).getpPrice() %></div> 
			</div>
			<% } %>
		</div>	
	</main>
	<br>
	<aside>
		<h1>Total : <%= c.getTotal() %></h1>
	</aside>      
</body>
</html>