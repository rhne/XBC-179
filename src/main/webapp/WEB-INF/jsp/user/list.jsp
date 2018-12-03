<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:forEach items = "${akunModelList}" var = "akunModel" varStatus="number">
	<tr>
		<td>${akunModel.name}</td>
		<td>${akunModel.roleModel.name}</td>
		<td>${akunModel.isActive}</td>
	</tr>
</c:forEach>