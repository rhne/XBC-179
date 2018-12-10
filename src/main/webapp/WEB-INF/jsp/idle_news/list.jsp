<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:forEach items = "${idlenewsModelList}" var = "idlenewsModel" varStatus="number">
	<tr>
		<td>${idlenewsModel.title}</td>
		<td>${idlenewsModel.categoryModel.name}</td>
		<td>
			<div class="btn-group">
			  <button type="button" class="btn btn-normal dropdown-toggle" data-toggle="dropdown">
			    <span class="fa fa-bars"></span>
			    <span class="sr-only">Toggle Dropdown</span>
			  </button>
			  <ul class="dropdown-menu" role="menu">
			    <li><a id="${idlenewsModel.id}" class="btn-edit">Edit</a></li>
			    			  <li class="divider"></li>
			    <li><a id="${idlenewsModel.id}" class="btn-publish">Publish</a></li>
			    <li class="divider"></li>
			    <li><a id="${idlenewsModel.id}" class="btn-delete">Delete</a></li>
			  </ul>
			</div>
		</td>	
		<td></td>
	</tr>
</c:forEach>