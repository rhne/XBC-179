<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="tech" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<tech:forEach items="${technologyModelList}" var="technologyModel" varStatus="number">
<tr>
	<td>${technologyModel.name}</td>
	<td>${technologyModel.createdBy}</td>
	<td>${technologyModel.active}</td>
	<td>
		<select id="action">
			<option id="edit-list-technology">Edit</option>
			<option id="deactive-status" value="0">Deactive</option>
		</select>
	</td>
</tr>

</tech:forEach>

<tr>
	<td>
		<select id="action">
			<option id="edit-list-technology">Edit</option>
			<option id="deactive-status" value="0">Deactive</option>
		</select>
	</td>
</tr>