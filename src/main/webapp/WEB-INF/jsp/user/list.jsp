<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:forEach items = "${akunModelList}" var = "akunModel" varStatus="number">
	<tr>
		<td>${akunModel.name}</td>
		<td>${akunModel.roleModel.name}</td>
		<td>${akunModel.isActive}</td>
		<td>
			<ul class="sidebar-menu">
				<li>
				<a href="#"><i class="fa fa-list"></i><span class="pull-right-container"> </span></a>
					<ul class="treeview-menu">
						<li>
							<a href="${contextName}/user.html" class="menu-item"><i class="fa fa-book"></i>User</a>
						</li>
						<li>
							<a href="${contextName}/role.html" class="menu-item"><i class="fa fa-book"></i>Role</a>
						</li>
					</ul>
				</li>	
			</ul> 
		</td>
	</tr>
</c:forEach>