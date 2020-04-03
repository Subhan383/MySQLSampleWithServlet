<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="com.org.mysqlservlet.entity.User" %>
<%@include file="include/header.jsp" %>
<div class="container mtb">
	<div class="row">
		<div class="col-lg-6">
			<strong>Listing Users</strong>
			<hr/>
			<table border="1">
			<thread>
			<th>User ID</th>
			<th>User name</th>
			<th>User Password</th>
			</thread>
			<%
			List<User> listUsers =(List) request.getAttribute("listUsers");
			for(int i=0;i<listUsers.size();i++){
				out.print("<tr>");
				out.print("<td>"+listUsers.get(i).getUser_id()+"</td>");
				out.print("<td>"+listUsers.get(i).getUsername()+"</td>");
				out.print("<td>"+listUsers.get(i).getUser_password()+"</td>");
				out.print("</tr>");
			}
			
			
			%>
			
			
			
			
			</table>
			
			
			
			
		</div>
	</div>
</div>
<%@include file="include/footer.jsp" %>