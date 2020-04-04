<%@include file="include/header.jsp" %>
<div class="container mtb">
	<div class="row">
		<div class="col-lg-6">
		
		<form action="${pageContext.request.contextPath }/operation" method="post">
		User Name: <input type="text" name="username" value="${param.username }" required/><br/>
		Password: <input type="text" name="password" value="${param.user_password }" required/><br/>
		<input type="hidden" name="User_id" value="${param.User_id }" />
		<input type="hidden" name="form" value="updateUserOperation"/>
		<input type="submit" value="Update User">
		</form>
      </div>
	</div>
</div>

<%@include file="include/footer.jsp" %>