<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>MainForm</title>
		
		<script type="text/javascript">
			$("document").ready(function(){
				$("#btnRetrive").on("click", function(){
					
					$("#result").html("");
					
					$.ajax("<c:url value="/demo/searchDummyList"/>", {
						type : "post",
						dataType : "json"
					})
					.done(function(data) { // success 시
						var jsonData = data.dummyList;
					
						var innerText = "<table border=1>";
						$.each(jsonData, function(i, row) {
							innerText += "<tr><td>";
							innerText += row.seq;
							innerText += "</td><td>";
							innerText += row.content;
							innerText += "</td><tr>";
						});
						innerText += "</table>";
						
						$("#result").html(innerText);
						/* alert(innerText); */
					})
					.fail(function(data) {
						alert("loadLogs failed");
					});
				});			
			});
		</script>
	</head>
	<body>
		<a href="/mink/logout">logout</a>
		<h1>Hello</h1>
		<input type="button" id="btnRetrive" value="조회" />
		
		<div id="result" />
	</body>
</html>