<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
             

<jsp:include page="../../templates/head.jsp">
	<jsp:param name="title" value="Sign In" />
	<jsp:param name="css" value="//cdn.datatables.net/1.10.13/css/jquery.dataTables.css" />
</jsp:include>

<table id="dishes_table" class="display">
    <thead>
        <tr>
            <th>Column 1</th>
            <th>Column 2</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Row 1 Data 1</td>
            <td>Row 1 Data 2</td>
        </tr>
        <tr>
            <td>Row 2 Data 1</td>
            <td>Row 2 Data 2</td>
        </tr>
    </tbody>
</table>
<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.13/js/jquery.dataTables.js"></script>
<script> 
$(document).ready(function(){
    $('#dishes_table').DataTable({
    });
});

</script>

<jsp:include page="../../templates/foot.jsp">
	<jsp:param name="script" value="//cdn.datatables.net/1.10.13/js/jquery.dataTables.js" />
</jsp:include>
