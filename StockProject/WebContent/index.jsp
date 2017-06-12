<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	%>
	<%@page import = "java.util.ArrayList" %>
	<%@page import = "privateOrder.domain.*" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
<head>
<link rel="shortcut icon" href="http://officiel-online.com/wp-content/uploads/2015/08/tumblr_mydm1r9Twn1qkzb3jo1_500.gif" type="image/gif">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Title</title>
<style>
	<%@include file='/css/bootstrap-theme.css'%>
	<%@include file='/css/bootstrap.css'%>
</style>
</head>
<div id="header">
	<div id="logo">
		<a href='/StockProject/'>Stock Project</a>			
	</div>
	<div id = "reg or auth">
		<ul class="nav-list">
			<li><a class="input-button" href='/StockProject/jsp/registration.jsp'><h2>registration</h2></a></li>
			<li><a class="input-button" href='/StockProject/jsp/authorisation.jsp'><h2>authorisation</h2></a></li>
		</ul></div>
</div>
<div id="content">
	<div id="filter block">
		<form class ="form-inline">
			<input size = "15" type="text" placeholder="group" name="group" > 
			<input size = "15" type="text" name="maker" placeholder="maker"> 
				<input  size = "15" class="input-small" type="text" name="code" placeholder="code"> 
				<input	 size = "7" class="input-small" type="text" name="sizel" placeholder="size lenght"> 
				<input  size = "7" class="input-small" type="text" name="sizeh" placeholder="size height">
				<input  size = "7" class="input-small" type="text" name="sizew" placeholder="size width"> 
				<input  size = "10" class="input-small" type="text"name="minprice" placeholder="Minimal Price"> 
				<input  size = "10" class="input-small" type="text" name="maxprice" placeholder="maximal price">
			<input class="btn" type="submit" value="find-goods">
		</form>
	</div>
	
	<jsp:useBean id="goodsListBean" scope ="request" class="privateOrder.beans.GoodsListBean"></jsp:useBean>
	<% ArrayList<Good> goods = goodsListBean.getGoodsForIndex();
%>
	<div id="goods-list" style=height:59px
	<%	if(goods.isEmpty()){
		%>
		hidden ="true"
		<% 
	}
	%>
	 >
		<table class = "table table-bordered">
			<tr>
				<th style=	text-transform:capitalize>name</th>
				<th style=	text-transform:capitalize>group</th>
				<th style=	text-transform:capitalize>maker</th>
				<th style=	text-transform:capitalize>code</th>
				<th style=	text-transform:capitalize>price</th>
				<th style=	text-transform:capitalize>size L</th>
				<th style=	text-transform:capitalize>size H</th>
				<th style=	text-transform:capitalize>size W</th>
				<th style=	text-transform:capitalize>description</th>
				<th style=	text-transform:capitalize>owner</th>
			</tr>
				<%
				Good good = new Good();
				for(int i=0; i<goods.size();i++){
					good = goods.get(i);
				
				%>
			<tr>
				<td style=	text-transform:capitalize><%= good.name %></td>
				<td style=	text-transform:capitalize></td>
				<td style=	text-transform:capitalize><%= good.maker %></td>
				<td style=	text-transform:capitalize><%= good.code %></td>
				<td style=	text-transform:capitalize><%= good.price%></td>
				<td style=	text-transform:capitalize><%= good.sizeL%></td>
				<td style=	text-transform:capitalize><%= good.sizeH %></td>
				<td style=	text-transform:capitalize><%= good.sizeW%></td>
				<td style=	text-transform:capitalize><%= good.description%></td>
				<td style=	text-transform:capitalize><%= good.accOwner %></td>
			</tr>
			<% } %>
		</table>
	</div>
</div>
</body>
</html>