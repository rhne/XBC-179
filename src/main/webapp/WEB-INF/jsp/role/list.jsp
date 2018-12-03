<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:forEach items = "${roleModelList}" var = "roleModel" varStatus="number">
	<tr>
		<td>${roleModel.kode}</td>
		<td>${roleModel.name}</td>
		<td>${roleModel.isActive}</td>	
		<td></td>
	</tr>
</c:forEach>