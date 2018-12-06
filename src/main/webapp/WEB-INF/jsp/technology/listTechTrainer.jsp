<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="tech" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<tech:forEach items="${technologyTrainerModelList}" var="technologyTrainerModel" varStatus="number">
<tr>
	<td>${technologyTrainerModel.trainerId}</td>
	<td>${technologyModel.createdOn}</td>
	<td>${technologyModel.active}</td>
	<td>
		<select id="action">
			<option id="edit-list-tech-trainer">Edit</option>
			<option id="deactive-status" value="0">Deactive</option>
		</select>
	</td>
</tr>
</tech:forEach>