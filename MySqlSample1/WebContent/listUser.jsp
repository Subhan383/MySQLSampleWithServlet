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
			<th>Update</th>
			</thread>
			<%
			List<User> listUsers =(List) request.getAttribute("listUsers");
			String tempURL;
			for(int i=0;i<listUsers.size();i++){
				out.print("<tr>");
				out.print("<td>"+listUsers.get(i).getUser_id()+"</td>");
				out.print("<td>"+listUsers.get(i).getUsername()+"</td>");
				out.print("<td>"+listUsers.get(i).getUser_password()+"</td>");
				tempURL=request.getContextPath()+"/operation?page=updateUser"+
				"&User_id="+listUsers.get(i).getUser_id()+
				"&username="+listUsers.get(i).getUsername()+
			    "&user_password="+listUsers.get(i).getUser_password();
				out.print("<td><a href="+tempURL+"> Update<a/></td>");
				out.print("</tr>");
			}
			%>
			</table>	
		</div>
	</div>
</div>
<%@include file="include/footer.jsp" %>