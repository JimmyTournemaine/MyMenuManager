<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
             
<jsp:include page="../../templates/head.jsp">
	<jsp:param name="title" value="Sign In" />
	<jsp:param name="css" value="css/login.css" />
</jsp:include>

<form id="form-signin" method="POST">
	<h2 class="form-signin-heading">Please sign in :</h2>
	<p class="text-danger">${formError}</p>
	<p class="text-danger">${form.errors.get(form.username)}</p>
	<label for="username" class="sr-only">Username</label> 
	<input name="${form.username}" value="${form.value(form.username)}" type="text" id="username" class="form-control" placeholder="Username" required autofocus> 
	<p class="text-danger">${form.errors.get(form.password)}</p>
	<label for="password" class="sr-only">Password</label> 
	<input name="${form.password}" value="${form.value(form.password)}" type="password" id="password" class="form-control" placeholder="Password" required>
	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
</form>

<%@ include file="../../templates/foot.jsp"%>