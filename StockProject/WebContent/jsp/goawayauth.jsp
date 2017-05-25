<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
<head>
<link rel="shortcut icon" href="http://officiel-online.com/wp-content/uploads/2015/08/tumblr_mydm1r9Twn1qkzb3jo1_500.gif" type="image/gif">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Go Away</title>
<style>
	<%@include file='/css/indexStyle.css'%>
	h6 {
	color:#ff0000;
	text-decoration:none;
	text-transform:uppercase;
    font-family: 'Arial'; /* Гарнитура текста */ 
    font-size: 40pt; /* Размер шрифта в процентах */ 
   	} 
</style>
</head>
<div id="header">
	<div id="logo">
		<a href='/StockProject/'>Stock Project</a>
	</div>
	<div id="regbutton">
		<a class="input-button" href='/StockProject/jsp/registration.jsp'><h2>registration</h2></a>
	</div>
	<div id="logBtn">
		<a class="input-button" href='/StockProject/jsp/authorisation.jsp'><h2>authorisation</h2></a>
	</div>
</div>
<div id="content">
		<form action="/StockProject/authorisation" method="post" enctype="application/x-www-form-urlencoded">
			<input type="text" required placeholder="email" name="email">
			<input	type="password" required placeholder="password" name="password">
			<input class="input-btn" type="submit" value="submit">
		</form>
<h6>Go away from here<p> there is no accounts like that in our Database</h6>
</div>
</body>
</html>