<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:forEach items = "${categoryModelList}" var = "categoryModel" varStatus="number">
	<tr>
		<td>${categoryModel.code}</td>
		<td>${categoryModel.name}</td>
		<td>Active</td>
		<td>
			<div class="btn-group">
			  <button type="button" class="btn btn-normal dropdown-toggle" data-toggle="dropdown">
			    <span class="fa fa-bars"></span>
			    <span class="sr-only">Toggle Dropdown</span>
			  </button>
			  <ul class="dropdown-menu" role="menu">
			    <li><a id="${categoryModel.id}" class="btn-deactivate">Deactivate</a></li>
			    <li class="divider"></li>
			  </ul>
			</div>
		</td>		
		<td></td>
	</tr>
</c:forEach>