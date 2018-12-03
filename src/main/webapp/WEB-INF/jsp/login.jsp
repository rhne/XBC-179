<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<div class="login-box-body">
	<p class="login-box-msg">Sign in to start your session</p>
	<c:if test="${not empty error}">
		<div class="error">${error}</div>
	</c:if>
	<c:if test="${not empty msg}">
		<div class="msg">${msg}</div>
	</c:if>
	<form name='loginForm' action="<c:url value='/j_spring_security_check' />" method='POST'>
		<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}" />
		
		<div class="form-group has-feedback">
			<input type="text" name="username" class="form-control"
				placeholder="Username"> <span
				class="glyphicon glyphicon-envelope form-control-feedback"></span>
		</div>
		<div class="form-group has-feedback">
			<input type="password" name="password" class="form-control"
				placeholder="Password"> <span
				class="glyphicon glyphicon-lock form-control-feedback"></span>
		</div>
		<div class="row">
			<div class="col-xs-8">
				
			</div>
			<!-- /.col -->
			<div class="col-xs-4">
				<button type="submit" class="btn btn-primary btn-block btn-flat">Sign
					In</button>
			</div>
			<!-- /.col -->
		</div>
	</form>

	

</div>
<!-- /.login-box-body -->
