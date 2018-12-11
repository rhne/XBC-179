<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:forEach items = "${roomModelList}" var = "roomModel" varStatus="number">
	<tr>
		<td>${roomModel.code}</td>
		<td>${roomModel.name}</td>
		<td>${roomModel.capacity}</td>
				<td>
			<div class="btn-group">
			  <button type="button" class="btn btn-normal dropdown-toggle" data-toggle="dropdown">
			    <span class="fa fa-bars"></span>
			    <span class="sr-only">Toggle Dropdown</span>
			  </button>
			  <ul class="dropdown-menu" role="menu">
			    <li><a id="${roomModel.code}" class="btn-edit">Edit</a></li>
			    <li class="divider"></li>
			    <li><a id="${roomModel.code}" class="btn-deactivate">Deactivate</a></li>
			  </ul>
			</div>
		</td>	
		<td></td>
	</tr>
</c:forEach>