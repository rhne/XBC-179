<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="trainer" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<trainer:forEach items="${trainerModelList}" var="trainerModel" varStatus="number">
<tr>
	<td>${trainerModel.name}</td>
	<td>${trainerModel.active}</td>
	<td>
		<select id="action">
			<option id="edit-list-trainer">Edit</option>
			<option id="deactive-status" value="0">Deactive</option>
		</select>
	</td>
</tr>
</trainer:forEach>