<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<jsp:useBean id="pers" class="com.mphasis.bean.Person" scope="request"/>

<jsp:setProperty property="*" name="pers"/>

<%-- <jsp:setProperty property="name" name="pers"/>
<jsp:setProperty property="age" name="pers"/>
<jsp:setProperty property="city" name="pers" param="city"/> --%>

<sql:update dataSource="jdbc/myoracle">
insert into person values ('${pers.name}',${pers.age},'${pers.city}')
</sql:update>

<%	response.sendRedirect("output.jsp"); %>
<%-- <jsp:forward page="output.jsp" /> --%>
</body>
</html>
