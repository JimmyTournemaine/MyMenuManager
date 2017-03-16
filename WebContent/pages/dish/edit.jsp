<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../../templates/head.jsp"%>
	<link href="${pageContext.servletContext.contextPath}/dropzone/dist/min/dropzone.min.css" rel="stylesheet" type="text/css"/>
	<title>Edit ${dish.name}</title>
</head>
<body>
	<%@ include file="../../templates/navbar.jsp"%>
	<div class="container">
		<h2>Edit ${dish.name} :</h2>
		<%@ include file="form.jsp"%>
		
		<h2>Add an image</h2>
		<form id="my-awesome-dropzone" class="form" method="post" action="${pageContext.servletContext.contextPath}/admin/dish/upload" class="dropzone">
			<input type="file" name="file" />
		</form>
	</div>
	
	<%@ include file="../../templates/foot.jsp"%>
	<script src="${pageContext.servletContext.contextPath}/dropzone/dist/min/dropzone.min.js"></script>
	<script type="text/javascript">
		var myDropzone = new Dropzone(); 
	</script>
</body>
</html>