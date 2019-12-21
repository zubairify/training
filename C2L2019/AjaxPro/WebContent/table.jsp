<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var xhttp;  
	function showTable() {  
		var num=document.getElementById("num").value;  
		var url="http://localhost:8080/AjaxPro/table.ajax?val="+num; 
  
		if(window.XMLHttpRequest) {  
			request=new XMLHttpRequest();  
		} else if(window.ActiveXObject) {  
			request=new ActiveXObject("Microsoft.XMLHTTP");  
		}  
  
		try {  
			request.onreadystatechange=getTable;  
			request.open("GET",url,true);  
			request.send();  
		} catch(e) {  
			alert("Unable to connect to server");  
		}  
	}  
  
	function getTable(){  
		if(request.readyState==4){  
			var val=request.responseText;  
			document.getElementById("output").innerHTML=val;
		}  
	}
</script>
</head>
<body>
	<h1>AJAX Table Demo</h1>
	<input id="num" size=5 onkeyup="showTable()">
	<hr>
	<div id="output"></div>
</body>
</html>
