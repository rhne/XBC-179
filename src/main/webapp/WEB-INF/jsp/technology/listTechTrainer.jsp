<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="tech" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<tech:forEach items="${technologyTrainerModelList}" var="technologyTrainerModel" varStatus="number">
<tr>
	<td>${technologyTrainerModel.trainerModel.name}</td>
	<td>${technologyModel.createdOn}</td>
	<td>Aktif</td>
	<td>
		<div class="btn-group">
		  <button type="button" class="btn btn-normal dropdown-toggle" data-toggle="dropdown">
		    <span class="fa fa-bars"></span>
		    <span class="sr-only">Toggle Dropdown</span>
		  </button>
		  <ul class="dropdown-menu" role="menu">
		    <li><a id="${technologyTrainerModel.idTechTrainer}" class="btn-edit">Edit</a></li>
 			<li><a id="${technologyTrainerModel.idTechTrainer}" class="btn-delete">Delete</a></li>
		    <li class="divider"></li>
		  </ul>
		</div>
	</td>
</tr>
</tech:forEach>