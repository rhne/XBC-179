
<% request.setAttribute("contextName", request.getContextPath()); %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"	prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<!DOCTYPE html>
<!-- main.jsp decorator //-->
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Login XBC</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet"
	href="${contextName}/assets/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${contextName}/assets/dist/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="${contextName}/assets/dist/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${contextName}/assets/dist/css/AdminLTE.min.css">
<!-- iCheck -->
<link rel="stylesheet"
	href="${contextName}/assets/plugins/iCheck/square/blue.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
<!-- jQuery 2.2.3 -->
<script src="${contextName}/assets/dist/js/jquery-3.1.1.min.js"></script>
</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<decorator:body />
	</div>
	<!-- /.login-box -->

	<!-- Bootstrap 3.3.6 -->
	<script src="${contextName}/assets/dist/js/bootstrap.min.js"></script>
	<!-- iCheck -->
	<script src="${contextName}/assets/plugins/iCheck/icheck.min.js"></script>
	<script>
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		});
	</script>
</body>
</html>
