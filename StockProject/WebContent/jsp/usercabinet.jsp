<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="java.util.*,java.text.*"%>
<%@ page import="privateOrder.domain.Good"%>
<body>
<head>
<link rel="shortcut icon"
	href="http://officiel-online.com/wp-content/uploads/2015/08/tumblr_mydm1r9Twn1qkzb3jo1_500.gif"
	type="image/gif">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>usercabinet</title>
<style>
<%@
include file ='/css/indexStyle.css'%>
</style>
</head>
<div id="header">
	<div id="logo">
		<a href='/StockProject/'>Stock Project</a>
	</div>
	<div id="logBtn">
		<a class="input-button" href='/StockProject/'><h2>LOGOUT</h2></a>
	</div>
</div>
<div id="content">
	CONGRATS
	<%=session.getAttribute("login")%>, YOU LOGGED IN
	<jsp:useBean id="goodsForAcc" scope="request"
		class="privateOrder.beans.AccountInfoBean" />
</div>
<div id="goods-list" style="height: 59px">
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
		</tr>
		<%
			ArrayList<Good> goods = goodsForAcc.getGoodsByAcc((String) session.getAttribute("email"));
			for (int i = 0; i < goods.size(); i++) {
		%>
		<tr>
			<td>
				<%=
					goods.get(i).getName()
				%>
			</td>
			<td>
				<%=
					goods.get(i).getGroupe()
				%>
			</td>
			<td>
				<%=
					goods.get(i).getMaker()
				%>
			</td>
			<td>
				<%=
					goods.get(i).getCode()
				%>
			</td>
			<td>
				<%=
					goods.get(i).getPrice()
				%>
			</td>
			<td>
				<%=
					goods.get(i).getSizeL()
				%>
			</td>
			<td>
				<%=
					goods.get(i).getSizeH()
				%>
			</td>
			<td>
				<%=
				goods.get(i).getSizeW()
				%>
			</td>
			<td>
				<%= goods.get(i).getDescription() %>
			</td>
		</tr>
		<%
			}
		%>

	</table>
</div>
</body>
</html>