<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:forEach items = "${roleModelList}" var = "roleModel" varStatus="number">
	<tr>
		<td>${roleModel.kode}</td>
		<td>${roleModel.name}</td>
		<td>${roleModel.isActive}</td>	
		<td>
			<ul class="sidebar-menu">
				<li>
				<a href="#"><i class="fa fa-list"></i><span class="pull-right-container"> </span></a>
					<ul class="treeview-menu">
						<li>
							<a href="${contextName}/edit.html" class="menu-item"><i class="fa fa-book"></i>Edit</a>
						</li>
						<li>
							<a href="${contextName}/deactivate.html" class="menu-item"><i class="fa fa-book"></i>Deactivate</a>
						</li>
					</ul>
				</li>	
			</ul> 
		</td>
	</tr>
</c:forEach>