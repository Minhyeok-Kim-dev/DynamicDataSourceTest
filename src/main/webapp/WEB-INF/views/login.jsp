<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>login</title>
	</head>
	<body>
		
		<div align="center">
			<form:form id="loginForm" modelAttribute="loginForm" method="post">
				<table>
					<tr>
						<td>ID</td>
						<td>
							<form:input path="id"/>
						</td>
					</tr>
					<tr>
						<td>PW</td>
						<td>
							<form:input path="pwd"/>
						</td>
					</tr>
				</table>
				<input type="submit" value="입력" />	
			</form:form> 
		</div>
	</body>
</html>