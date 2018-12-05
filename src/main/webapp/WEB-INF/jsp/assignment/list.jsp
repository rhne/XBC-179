<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:forEach items = "${assignmentModelList}" var = "assignmentModel" varStatus="number">
	<tr>
		<td>${assignmentModel.biodataModel.name}</td>
		<td>${assignmentModel.startDate}</td>
		<td>${assignmentModel.endDate}</td>
	</tr>
</c:forEach>