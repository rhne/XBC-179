<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:forEach items="${questionModelList}" var="questionModel" varStatus="number">
	<tr>
		<td>${number.count}</td>
		<td>${questionModel.question}</td>
		<td>${questionModel.createdOn}</td>
		<td>${questionModel.isDelete}</td>
		<td>
			<div class="btn-group">
			  <button type="button" class="btn btn-normal dropdown-toggle" data-toggle="dropdown">
			    <span class="fa fa-bars"></span>
			    <span class="sr-only">Toggle Dropdown</span>
			  </button>
			  <ul class="dropdown-menu" role="menu">
			    <li><a id="${questionModel.id}" class="btn-delete">Delete</a></li>
			    <li class="divider"></li>
			  </ul>
			</div>
		</td>
	</tr>
</c:forEach>
