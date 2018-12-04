<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:forEach items = "${biodataModelList}" var = "biodataModel" varStatus="number">
	<tr>
		<td>${biodataModel.name}</td>
		<td>${biodataModel.majors}</td>
		<td>${biodataModel.gpa}</td>
	</tr>
</c:forEach>