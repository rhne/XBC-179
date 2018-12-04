<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:forEach items = "${idlenewsModelList}" var = "idlenewsModel" varStatus="number">
	<tr>
		<td>${idlenewsModel.title}</td>
		<td>${categoryModel.name}</td>
		<td>${idlenewsModel.isDeleted}</td>
		<td></td>
	</tr>
</c:forEach>