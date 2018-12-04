<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:forEach items = "${categoryModelList}" var = "categoryModel" varStatus="number">
	<tr>
		<td>${categoryModel.code}</td>
		<td>${categoryModel.name}</td>
		<td>${categoryModel.isActive}</td>	
		<td></td>
	</tr>
</c:forEach>