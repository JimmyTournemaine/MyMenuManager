<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../../templates/head.jsp"%>
		<title></title>
	</head>
	<body>
		<%@ include file="../../templates/navbar.jsp"%>
		<div class="container">
			<c:forEach var="dish" items="${dishes}">
				<h2>${dish.name}</h2>
				<div class="well">${dish.description} : ${dish.price}€</div>
			</c:forEach>
		</div>
	<%@ include file="../../templates/foot.jsp"%>
	</body>
</html>
