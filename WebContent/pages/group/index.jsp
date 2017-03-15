<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      
<!DOCTYPE html>
<html lang="en">
<head>
	<%@ include file="../../templates/head.jsp"%>
	<title>Manage Groups</title>
</head>
<body>
	<%@ include file="../../templates/navbar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-sm-6">					
				<form class="form-inline">
					<i class="fa fa-2x fa-plus-circle" aria-hidden="true"></i>
					<div class="form-group">
						<input type="text" name="${form.name}" value="${form.value(form.name)}" placeholder="name" class="form-control"/>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-block">Save</button>
					</div>
				</form>
				<hr/>
				<div id="group-container">
					<c:forEach var="group" items="${groups}">
						<h3>${group.name}</h3>
						<ul>
							<c:forEach var="aDish" items="${groups.dishes}">
								<li id="dish-${aDish.id}">${aDish.name}</li>
							</c:forEach>
						</ul>
					</c:forEach>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="list-group">
					<c:forEach var="dish" items="${dishes}">
						<a href="#" class="list-group-item">${dish.name}</a>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../../templates/foot.jsp"%>
	<script></script>
</body>
</html>