<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.shopNest.dbHandler.DataFetcher" %>
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
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
</head>
<body>
	
	<%
		response.setHeader("Cache-Control", "no-cahe, no-store,must-revalidate");
		if(session.getAttribute("user") == null)
			response.sendRedirect("login.jsp");
		List productList = DataFetcher.productInfo();
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
		<div class="product-container">
					<%
                    	for(int i = 0; i < productList.size(); i++){
                        String[] prodArr=((String)productList.get(i)).split(":"); 	
                	%>	
					<div class="product-card">
				  		<img src="prodimg/<%= prodArr[4] %>" alt="Product Name" class="product-image">
				  		<h3 class="product-name"><%= prodArr[1] %></h3>
						<p class="product-description"><%= prodArr[2] %></p>
		  				<div class="product-price">RS<%= prodArr[3] %></div>
		  				<form method = "post" action = "add-to-cart">
		  					<input type = "hidden" name = "productId" value = "<%= Integer.parseInt(prodArr[0])%>">
		  					<button class="add-to-cart-button">Add to Cart</button>
		  				</form>
					</div>
					<% } %>
				</div>
</body>
</html>