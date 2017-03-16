<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
             


<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../../templates/head.jsp"%>
		<title>Dishes List</title>
	</head>
	<body>
		<%@ include file="../../templates/navbar.jsp"%>
		<div class="container">
			<table class="table table-striped table-hover">
			    <thead>
			        <tr>
			            <th scope="row">Name</th>
			            <th scope="row">Price</th>
			            <th scope="row">Actions</th>
			        </tr>
			    </thead>
    			<tbody>
    			<c:forEach var="dish" items="${dishes}">
			        <tr>
			        	    <td>${dish.name}</td>	
			        	    		        	      		        	    
				                       
			            	<td>${dish.price}€</td>
			            	<td>
			                	<a href="${pageContext.servletContext.contextPath}/admin/dish/edit?id=${dish.id}" class="teal-text"><i class="fa fa-pencil" aria-hidden="true"><span class="sr-only">Edit</span></i></a>
			                	<a href="${pageContext.servletContext.contextPath}/admin/dish/delete?id=${dish.id}" class="red-text"><i class="fa fa-times" aria-hidden="true"><span class="sr-only">Delete</span></i></a>
			            	</td>
			        </tr>
			    </c:forEach>
    			</tbody>
			</table>			
		</div>
	<%@ include file="../../templates/foot.jsp"%>
	<script type="text/javascript" src="//cdn.datatables.net/1.10.13/js/jquery.dataTables.js"></script>
	<script> 
		$(document).ready(function(){
    	$('#dishes_table').DataTable({
    	});
		});
	</script>
	</body>
</html>



