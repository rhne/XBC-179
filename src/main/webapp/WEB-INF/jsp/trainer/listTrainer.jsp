<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="trainer" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<trainer:forEach items="${trainerModelList}" var="trainerModel" varStatus="number">
<tr>
	<td>${trainerModel.name}</td>
	<td>Active</td>
	<td>
		<div class="btn-group">
		  <button type="button" class="btn btn-normal dropdown-toggle" data-toggle="dropdown">
		    <span class="fa fa-bars"></span>
		    <span class="sr-only">Toggle Dropdown</span>
		  </button>
		  <ul class="dropdown-menu" role="menu">
			    <li><a id="${trainerModel.idTrainer}" class="btn-edit">Edit</a></li>
			     <li><a id="${testimonyModel.idTrainer}" class="btn-delete">Delete</a></li>
			    <li class="divider"></li>
			</ul>
		</div>
	</td>
</tr>
</trainer:forEach>