<%@page import="com.papaya.bean.ProductBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.imdv:hover {
	transform:scale(2);
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Catalog::Papaya.com</title>
<link rel="stylesheet" type="text/css" href="media/theme.css">
</head>
<body>
<jsp:include page="banner.jsp" />
<%	List<ProductBean> catalog = (List) request.getAttribute("CATALOG"); %>
<table width="100%" style='background-image:url("media/perback.png")'>
<tr><th colspan="2" class="title">Product Catalog</th></tr>
<%	for(ProductBean product : catalog) { %>
	<tr>
		
		<td width="350">Product Description:<br>
			<i><%= product.getName() %></i><br>
			Rs.<b><%= product.getPrice() %>0</b>
			</td>
		<td width="50"><a href="Shopping.do?code=<%= product.getCode() %>">
			<img src="media/cart.png" height="50" width="50"></a></td>
		<td></td>
	</tr>
<%	} %>
</table>
<div class="footer">&copy; Copyright 2018 Papaya.com</div>
</body>
</html>




