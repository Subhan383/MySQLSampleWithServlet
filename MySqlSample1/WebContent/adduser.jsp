<%@include file="include/header.jsp" %>
<div class="container mtb">
	<div class="row">
		<div class="col-lg-6">
		
		<form action="${pageContext.request.contextPath }/operation" method="post">
		User Name: <input type="text" name="username" required/><br/>
		Password: <input type="password" name="password" required/><br/>
		<input type="hidden" name="form" value="addUserOperation">
		<input type="submit" value="Add User">
		</form>
      </div>
	</div>
</div>

<%@include file="include/footer.jsp" %>

