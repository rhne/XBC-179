<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<div class="login-box-body">
 
 	<h3 class="login-box-msg">FORM LOGIN</h3>
	
	<c:if test="${not empty error}">
		<div class="error">${error}</div>
	</c:if>
	
	<c:if test="${not empty msg}">
		<div class="msg">${msg}</div>
	</c:if>
	
	<form name='loginForm' action="<c:url value='/j_spring_security_check' />" method='POST'>
		<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}" />
		
		<div class="form-group has-feedback">
			<input type="text" name="username" class="form-control" placeholder="Username" required> 
			<span class="glyphicon glyphicon-user form-control-feedback"></span>
		</div>
		<div class="form-group has-feedback">
			<input type="password" name="password" class="form-control" placeholder="Password" required> 
			<span class="glyphicon glyphicon-lock form-control-feedback"></span>
		</div>
		<div class="form-group">
				<button type="submit" class="btn btn-primary btn-block">Login</button>
		</div>
	</form>
	
</div>
<!-- /.login-box-body -->
