<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:forEach items="${versionModelList}" var="versionModel" varStatus="number">
	<tr>
		<td>${number.count}</td>
		<td>${versionModel.version}</td>
		<td>${versionDetail.id}</td>
		<td>${versionModel.isDelete}</td>
		<td>
			<div class="btn-group">
			  <button type="button" class="btn btn-normal dropdown-toggle" data-toggle="dropdown">
			    <span class="fa fa-bars"></span>
			    <span class="sr-only">Toggle Dropdown</span>
			  </button>
			  <ul class="dropdown-menu" role="menu">
			    <li><a id="${versionModel.id}" class="btn-delete">Delete</a></li>
			  </ul>
			</div>
		</td>
	</tr>
</c:forEach>
