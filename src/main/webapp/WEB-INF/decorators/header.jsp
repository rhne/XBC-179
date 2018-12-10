<header class="main-header">
    <!-- Logo -->
    <a href="/miniproject/" class="logo">
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
      			Welcome Here, ${username} as ${nameRole}</span>
      		</a></li>     		
      	</ul>
      </div>
      <div class = "navbar-custom-menu">
      	<ul class="nav navbar-nav">
      	
      		<li>
      			<form method="post" action="<c:url value="/j_spring_security_logout"/>">
      				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      					<button type="submit" class="btn btn-block btn-warning"> Log Out</button>
      			</form>
      		</li>
      		
      	</ul>
      	<div class="pull-right"></div>
      </div>
      
    </nav>
    
    
  </header>