

<nav class="navbar" style="height: 100%; position: fixed;"
	role="navigation">
	<aside class="main-sidebar">

		<section class="sidebar">
			<ul class="sidebar-menu">
				<li class="header"><h5>XBC 179</h5></li>
				<li>
					<a href="#"><i class="fa fa-edit"></i><span>Master</span><span class="pull-right-container"> </span></a>
					<ul class="treeview-menu">
						<c:forEach items="${menuModelList}" var="menuModel">
							<li>
								<a href="${contextName}/${menuModel.menuurl}.html">
									${menuModel.title}	
								</a>	
							</li>
						</c:forEach>
					</ul>
				</li>	
			 <!-- Modul 1 -->	
				<li>
					<a href="#"><i class="fa fa-edit"></i><span>Module 1</span><span class="pull-right-container"> </span></a>
					<ul class="treeview-menu">
						<li>
							<a href="${contextName}/user.html" class="menu-item"><i class="fa fa-book"></i>User</a>
						</li>
						<li>
							<a href="${contextName}/role.html" class="menu-item"><i class="fa fa-book"></i>Role</a>
						</li>
						<li>
							<a href="${contextName}/menu.html" class="menu-item"><i class="fa fa-book"></i>Menu</a>
						</li>
						<li>
							<a href="${contextName}/menuaccess.html" class="menu-item"><i class="fa fa-book"></i>Menu Access</a>
						</li>
					</ul>
				</li>
				<!-- Modul 2 -->	
				<li>
					<a href="#"><i class="fa fa-edit"></i><span>Module 2</span><span class="pull-right-container"> </span></a>
					<ul class="treeview-menu">
						<li>
							<a href="${contextName}/question.html" class="menu-item"><i class="fa fa-question"></i>Question</a>
						</li>
						<li>
							<a href="${contextName}/version.html" class="menu-item"><i class="fa fa-book"></i>Version</a>
						</li>
						<li>
							<a href="${contextName}/feedback.html" class="menu-item"><i class="fa fa-comments"></i>Feedback</a>
						</li>
					</ul>
				</li>
				<!-- Modul 3 -->
				<li>
					<a href="#"><i class="fa fa-edit"></i><span>Module 3</span><span class="pull-right-container"> </span></a>
					<ul class="treeview-menu">
						<li>
							<a href="${contextName}/biodata.html" class="menu-item"><i class="fa fa-male"></i>Biodata</a>
						</li>
						<li>
							<a href="${contextName}/monitoring.html" class="menu-item"><i class="fa fa-desktop"></i>Monitoring</a>
						</li>
						<li>
							<a href="${contextName}/assignment.html" class="menu-item"><i class="fa fa-briefcase"></i>Assignment</a>
						</li>
					</ul>
				</li>	

				<!-- Modul 4 -->
								<li>
					<a href="#"><i class="fa fa-edit"></i><span>Modul 4</span><span class="pull-right-container"> </span></a>
					<ul class="treeview-menu">
						<li>
							<a href="${contextName}/office.html" class="menu-item"><i class="fa fa-ravelry"></i>Office</a>
						</li>
						<li>
							<a href="${contextName}/bootcamp_test_type.html" class="menu-item"><i class="fa fa-handshake-o"></i>Bootcamp Test Type</a>
						</li>
						<li>
							<a href="${contextName}/category.html" class="menu-item"><i class="fa fa-code-fork"></i>Category</a>
						</li>
						<li>
							<a href="${contextName}/idle_news.html" class="menu-item"><i class="fa fa-compass"></i>Idle News</a>
						</li>
					</ul>
				</li>

				<!-- Modul 5 -->
				<li>
					<a href="#"><i class="fa fa-edit"></i><span>Modul 5</span><span class="pull-right-container"> </span></a>
						<ul class="treeview-menu">
						<li>
								<a href="${contextName}/technology.html" class="menu-item"><i class="fa fa-code"></i>Technology</a>
						</li>
						<li>
								<a href="${contextName}/trainer.html" class="menu-item"><i class="fa fa-user"></i>Trainer</a>
						</li>
						<li> 
								<a href="${contextName}/testimony.html" class="menu-item"><i class="fa fa-sticky-note-o"></i>Testimony</a>
						</li>
						<li> 
								<a href="${contextName}/bootcamp.html" class="menu-item"><i class="fa fa-group"></i>Bootcamp</a>
						</li>
						<li> 
								<a href="${contextName}/batch.html" class="menu-item"><i class="fa fa-sitemap"></i>Batch</a>
						</li>
						<li> 
								<a href="${contextName}/clazz.html" class="menu-item"><i class="fa fa-university"></i>Class</a>
						</li>
						</ul>
				</li>	
			</ul> 
		</section>
		<!-- /.sidebar -->
	</aside>
</nav>