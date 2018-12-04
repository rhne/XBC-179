<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:forEach items = "${monitoringModelList}" var = "monitoringModel" varStatus="number">
	<tr>
		<td>Reynaldo Kevin</td>
		<td>${monitoringModel.idleDate}</td>
		<td>${monitoringModel.placementDate}</td>
	</tr>
</c:forEach>