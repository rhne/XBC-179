<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:forEach items = "${officeModelList}" var = "officeModel" varStatus="number">
	<tr>
		<td>${officeModel.name}</td>
		<td>${officeModel.phone}</td>
		<td>${officeModel.email}</td>
		<td>${officeModel.isActive}</td>
				<td>
			<div class="btn-group">
			  <button type="button" class="btn btn-normal dropdown-toggle" data-toggle="dropdown">
			    <span class="fa fa-bars"></span>
			    <span class="sr-only">Toggle Dropdown</span>
			  </button>
			  <ul class="dropdown-menu" role="menu">
			    <li><a id="${officeModel.id}" class="btn-delete">Delete</a></li>
			    <li class="divider"></li>
			  </ul>
			</div>
		</td>	
		<td></td>
	</tr>
</c:forEach>