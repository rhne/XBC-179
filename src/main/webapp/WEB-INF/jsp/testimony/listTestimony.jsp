<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="tsm" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<tsm:forEach items="${testimonyModelList}" var="testimonyModel" varStatus="number">
<tr>
	<td>${testimonyModel.title}</td>
	<td>
		<select id="action">
			<option id="edit-list-testimony">Edit</option>
			<option id="deactive-status" value="0">Deactive</option>
		</select>
	</td>
</tr>

</tsm:forEach>

<tr>
	<td>
		<select id="action">
			<option id="edit-list-testimony">Edit</option>
			<option id="deactive-status" value="0">Deactive</option>
		</select>
	</td>
</tr>