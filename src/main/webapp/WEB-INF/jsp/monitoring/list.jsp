<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:forEach items = "${monitoringModelList}" var = "monitoringModel" varStatus="number">
	<tr>
		<td>${monitoringModel.biodataModel.name}</td>
		<td>${monitoringModel.idleDate}</td>
		<td>${monitoringModel.placementDate}</td>
		<td>
			<div class="dropdown">
  				<button class="btn btn-link dropdown-toggle" type="button" data-toggle="dropdown">
  				<i class="fa fa-bars"></i>
  				</button>
  					<ul class="dropdown-menu">
    					<li><button type="button" class="btn btn-link" id="btn-edit" value="${monitoringModel.id}">Edit</button></li>
    					<li><button type="button" class="btn btn-link" id="btn-placement" value="${monitoringModel.id}">Placement</button></li>
    					<li><button type="button" class="btn btn-link" id="btn-delete" value="${monitoringModel.id}">Delete</button></li>
  					</ul>
			</div>
		</td>
	</tr>
</c:forEach>