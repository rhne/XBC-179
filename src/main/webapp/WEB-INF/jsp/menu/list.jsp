<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:forEach items = "${menuModelList}" var = "menuModel" varStatus="number">
	<tr>
		<td>${roleModel.kode}</td>
		<td>${roleModel.title}</td>
		<td>${roleModel.status}</td>
		<td>Active</td>	
		<td>
			<div class="dropdown">
  				<button class="btn btn-link dropdown-toggle" type="button" data-toggle="dropdown">
  				<i class="fa fa-bars"></i>
  				</button>
  					<ul class="dropdown-menu">
    					<li><button type="button" class="btn btn-link" id="btn-edit" value="${menuModel.id}">Edit</button></li>
    					<li><button type="button" class="btn btn-link" id="btn-deactivate">Deactivate</button></li>
  					</ul>
			</div>
		</td>
	</tr>
</c:forEach>