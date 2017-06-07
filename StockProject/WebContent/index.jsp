<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
<head>
<link rel="shortcut icon" href="http://officiel-online.com/wp-content/uploads/2015/08/tumblr_mydm1r9Twn1qkzb3jo1_500.gif" type="image/gif">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Title</title>
<style>
	<%@include file='/css/indexStyle.css'%>
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
	<div id="filter block">
		<form>
			<input type="text" placeholder="group" name="group" > <input type="text"
				name="maker" placeholder="maker"> <input type="text" name="code" placeholder="code"> <input
				type="text" name="sizel" placeholder="size lenght"> <input type="text" name="sizeh" placeholder="size height">
			<input type="text" name="sizew" placeholder="size width"> <input type="text"
				name="minprice" placeholder="Minimal Price"> <input type="text" name="maxprice" placeholder="maximal price">
			<input class="input-button" type="submit" value="find-goods">
		</form>
	</div>
	<div id="goods-list" style=height:59px>
		<table>
			<tr>
				<th>name</th>
				<th>group</th>
				<th>maker</th>
				<th>code</th>
				<th>price</th>
				<th>size L</th>
				<th>size H</th>
				<th>size W</th>
				<th>description</th>
				<th>owner</th>
			</tr>
			<tr>
				<td>name</td>
				<td>group</td>
				<td>maker</td>
				<td>code</td>
				<td>price</td>
				<td>size L</td>
				<td>size H</td>
				<td>size W</td>
				<td>description</td>
				<td>owner</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>