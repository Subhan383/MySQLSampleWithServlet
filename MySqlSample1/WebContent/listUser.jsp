<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="com.org.mysqlservlet.entity.User" %>
<%@include file="include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<th>Operation</th>
			</thread>
			
			<c:forEach items="${listUsers}" var="user">
				<c:url var="updateURL" value="operation">
				<c:param name="page" value="updateUser"></c:param>			
				<c:param name="User_id" value="${user.user_id}"></c:param>
				<c:param name="username" value="${user.username}"></c:param>
				<c:param name="user_password" value="${user.user_password}"></c:param>
				</c:url>
				
				<c:url var="deleteUser" value="operation">
				<c:param name="page" value="deleteUser"></c:param>			
				<c:param name="User_id" value="${user.user_id}"></c:param>
				</c:url>
				
				<tr>
 				<td>${user.user_id}</td>
 				<td>${user.username}</td>
 				<td>${user.user_password}</td>
 				<td>
 				<a href="${updateURL}">Update</a>|
 				<a href="${deleteUser}"
					onclick="if(!confirm('Are you sure to delete the user?')) return false">Delete</a>
 				</td>
 				</tr>			
				</c:forEach>
			
			
			</table>	
		</div>
	</div>
</div>
<%@include file="include/footer.jsp" %>