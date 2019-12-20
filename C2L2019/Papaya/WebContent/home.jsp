<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home::Papaya.com</title>
<link rel="stylesheet" type="text/css" href="media/theme.css">
</head>
<body>
<jsp:include page="banner.jsp" />
<table width="100%" style='background-image:url("media/perback.png")'>
<tr><th colspan="2" class="title">
Hello and Welcome to Papaya.com</th></tr>
<tr><td width="350" style="padding-bottom:20px;padding-top:20px"><img src="media/perleft.gif" width="300" height="300"></td>
	<td>
<form action="User.do" method="get">
<table>
<%	if(request.getParameter("invalid") != null) { %>
	<tr><td colspan="2" style="color:red">Invalid User ID/Password</td></tr>
<%	} %>
<tr><td>Email ID</td>
	<td><input type="email" name="email" required></td></tr>
<tr><td>Password</td>
	<td><input type="password" name="password" required pattern="[A-Za-z0-9]{4,}"></td></tr>
<tr><th colspan="2"><input type="submit" value="Login"></th></tr>
<tr><td><br></td></tr>
<tr><td colspan="2">New user <a href="register.jsp">Register Now!</a></td></tr>
</table>
</form>
	</td></tr>
</table>
<div class="footer">&copy; Copyright 2018 Papaya.com</div>
</body>
</html>