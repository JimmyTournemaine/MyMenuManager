<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="fr">
	<head>
		<%@ include file="../templates/head.jsp"%>
		<title>Accueil</title>
	</head>
	<body>
		<%@ include file="../../templates/navbar.jsp"%>
		<div class="container">
			<c:if test="${pageError != null}">
				<p class="alert alert-danger">${pageError}</p>
			</c:if>
			<h1>Bonjour</h1>
		</div>
		<%@ include file="../templates/foot.jsp"%>
	</body>
</html>