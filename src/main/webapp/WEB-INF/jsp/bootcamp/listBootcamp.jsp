<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="bt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<bt:forEach items="${bootcampTypeModelList}" var="bootcampTypeModel" varStatus="number">
<tr>
	<td>${bootcampTypeModel.name}</td>
	<td>${bootcampTypeModel.akunModel.name}</td>
	<td>Active</td>
	<td>
		<div class="btn-group">
		  <button type="button" class="btn btn-normal dropdown-toggle" data-toggle="dropdown">
		    <span class="fa fa-bars"></span>
		    <span class="sr-only">Toggle Dropdown</span>
		  </button>
		  <ul class="dropdown-menu" role="menu">
			    <li><a id="${bootcampTypeModel.idBootcamp}" class="btn-edit">Edit</a></li>
			     <li><a id="${bootcampTypeModel.idBootcamp}" class="btn-deactive">Deactive</a></li>
			    <li class="divider"></li>
			</ul>
			</div>
	</td>
</tr>

</bt:forEach>