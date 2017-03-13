<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../templates/head.jsp" >
  <jsp:param name="title" value="Accueil" />
</jsp:include>

<h1>Forbidden</h1>

<p>It looks like you are not allow to access to this page !</p>
<p>You can log in to the application by following 
	<a href="${pageContext.servletContext.contextPath}/login">this link</a>.
</p>

<%@ include file="../templates/foot.jsp"%>