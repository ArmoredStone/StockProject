<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Authorise</title>
<style>
<%@include file='/css/indexStyle.css'%>
</style>
</head>
<body>
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
	</div>
</body>
</html>
