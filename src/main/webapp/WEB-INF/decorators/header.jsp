<header class="main-header">
    <!-- Logo -->
    <a href="/miniproject/index.html" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>XBC</b></span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg">Mini Project</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <div>
      	<ul class="nav navbar-nav">
      		<li><a href="#" class="dropdown-toggle" data-toggle="dropdown">
      			<span class="hidden-xs">
      			Welcome Here, ${username} as ${nameRole}</span></a>
      			<ul class="dropdown-menu dropdown-menu-right">
      				<li>
      					<form method="post" action="<c:url value="/j_spring_security_logout"/>">
      						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      						<button type="submit" class="btn btn-link"><p class="text-danger">Log Out</p></button>
      					</form>
      				</li>      		
      			</ul>
      		</li>     		
      	</ul>
      </div>      
    </nav>
    
    
  </header>