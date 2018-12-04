<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:forEach items = "${officeModelList}" var = "officeModel" varStatus="number">
	<tr>
		<td>${officeModel.name}</td>
		<td>${officeModel.phone}</td>
		<td>${officeModel.email}</td>
		<td>${officeModel.isActive}</td>	
		<td></td>
	</tr>
</c:forEach>