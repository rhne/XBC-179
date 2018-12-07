<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:forEach items = "${assignmentModelList}" var = "assignmentModel" varStatus="number">
	<tr>
		<td>${assignmentModel.biodataModel.name}</td>
		<td>${assignmentModel.startDate}</td>
		<td>${assignmentModel.endDate}</td>
		<td>
			<div class="dropdown">
  				<button class="btn btn-link dropdown-toggle" type="button" data-toggle="dropdown">
  				<i class="fa fa-bars"></i>
  				</button>
  					<ul class="dropdown-menu">
    					<li><button type="button" class="btn btn-link" id="btn-edit" value="${assignmentModel.id}">Edit</button></li>
    					<li><button type="button" class="btn btn-link" id="btn-delete" value="${assignmentModel.id}">Delete</button></li>
    					<li><button type="button" class="btn btn-link" id="btn-hold" value="${assignmentModel.id}">Hold</button></li>
    					<li><button type="button" class="btn btn-link" id="btn-markAsDone" value="${assignmentModel.id}">Mark as Done</button></li>
  					</ul>
			</div>
		</td>
	</tr>
</c:forEach>