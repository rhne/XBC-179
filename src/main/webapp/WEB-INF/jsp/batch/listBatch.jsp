<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="btch" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<btch:forEach items="${batchModelList}" var="batchModel" varStatus="number">
<tr>
	<td>${batchModel.technologyModel.name}</td>
	<td>${batchModel.name}</td>
	<td>${batchModel.trainerModel.name}</td>
	<td>
		<div class="btn-group">
		  <button type="button" class="btn btn-normal dropdown-toggle" data-toggle="dropdown">
		    <span class="fa fa-bars"></span>
		    <span class="sr-only">Toggle Dropdown</span>
		  </button>
		  <ul class="dropdown-menu" role="menu">
			    <li><a id="${batchModel.batchId}" class="btn-edit">Edit</a></li>
			     <li><a id="${batchModel.batchId}" class="btn-add-participant">Add Participant</a></li>
			    <li class="divider"></li>
			</ul>
			</div>
	</td>
</tr>

</btch:forEach>