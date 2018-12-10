<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:forEach items = "${menuModelList}" var = "menuModel" varStatus="number">
	<tr>
		<td>${menuModel.kode}</td>
		<td>${menuModel.title}</td>
		<td ${menuModel.menuparent==menuModel.id}>${menuModel.menuparent}</td>
		<td>Active</td>	
		<td>
			<div class="dropdown">
  				<button class="btn btn-link dropdown-toggle" type="button" data-toggle="dropdown">
  				<i class="fa fa-bars"></i>
  				</button>
  					<ul class="dropdown-menu">
    					<li><button type="button" class="btn btn-link" id="btn-edit" value="${menuModel.id}">Edit</button></li>
    					<li><button type="button" class="btn btn-link" id="btn-deactivate" value="${menuModel.id}">Deactivate</button></li>
  					</ul>
			</div>
		</td>
	</tr>
</c:forEach>