<%@page import="com.papaya.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="media/theme.css">
</head>
<body>
<table width="100%" cellspacing="0">
<tr><td width="2" class="banner">&nbsp;</td>
	<th width="100" rowspan="2"></th>
	<td class="banner" width="300">
Papaya.com </td><td rowspan="2"></td></tr>
<tr><td class="punch"></td>
	<td class="punch">Shopping Destiny</td></tr>
<%	UserBean user = (UserBean)session.getAttribute("USER"); 
	if(user != null) {%>
	<tr><td colspan="4">Hello <%= user.getName() %> | <a href="User.do?">Logout</a></td></tr>
<%	} %>
</table>
</body>
</html>