<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:forEach items = "${bootcamptesttypeModelList}" var = "bootcamptesttypeModel" varStatus="number">
	<tr>
		<td>${bootcamptesttypeModel.name}</td>
		<td>${bootcamptesttypeModel.createdBy}</td>
		<td>${bootcamptesttypeModel.isActive}</td>	
		<td></td>
	</tr>
</c:forEach>