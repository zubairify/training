<%@page import="com.papaya.bean.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Summary::Papaya.com</title>
<link rel="stylesheet" type="text/css" href="media/theme.css">
</head>
<body>
<jsp:include page="banner.jsp" />
<% ProductBean product = (ProductBean) request.getAttribute("PRODUCT"); %>
<table width="100%" style='background-image:url("media/perback.png")'>
<tr><th colspan="2" class="title">Product Summary</th></tr>
	<tr>
		
		<td width="350">Product added to cart:<br>
			<i><%= product.getName() %></i><br>
			Rs.<b><%= product.getPrice() %>0</b>
			</td>
			<td></td>
	</tr>
	<tr><th><a href="Shopping.do">Continue Shopping</a></th>
		<th><a href="checkcart.jsp">Check your cart</a>
</table>
<div class="footer">&copy; Copyright 2018 Papaya.com</div>
</body>
</html>
