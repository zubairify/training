<%@page import="com.papaya.bean.ProductBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Check Cart::Papaya.com</title>
<link rel="stylesheet" type="text/css" href="media/theme.css">
</head>
<body>
<jsp:include page="banner.jsp" />
<%	List<ProductBean> cart = (List) session.getAttribute("CART"); %>
<%	if(request.getParameter("idx") != null) {
		cart.remove(Integer.parseInt(request.getParameter("idx")));
		session.setAttribute("CART",cart);
} %>
<table width="100%" style='background-image:url("media/perback.png")'>
<tr><th colspan="2" class="title">Your Shopping Cart</th></tr>
<%	for(int i=0;i<cart.size(); i++) {
		ProductBean product = cart.get(i); %>
		<tr>
		<td width="350">Product Description:<br>
			<i><%= product.getName() %></i><br>
			Rs.<b><%= product.getPrice() %>0</b>
			</td>
			<td><a href="checkout.jsp?idx=<%=i %>">Remove Item</a></td>
	</tr>
<%	} %>
</table>
<div class="footer">&copy; Copyright 2018 Papaya.com</div>
</body>
</html>