<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:forEach items = "${menuAksesModelList}" var = "menuAksesModel" varStatus="number">
	<tr>
		<td>${menuAksesModel.roleModel.name}</td>
		<td>${menuAksesModel.menuModel.title}</td>
		<td>
			<div class="dropdown">
  				<button class="btn btn-link dropdown-toggle" type="button" data-toggle="dropdown">
  				<i class="fa fa-bars"></i>
  				</button>
  					<ul class="dropdown-menu">
    					<li><button type="button" class="btn btn-link" id="btn-delete" value="${menuAksesModel.id}">Delete</button></li>
  					</ul>
			</div> 
		</td>
	</tr>
</c:forEach>