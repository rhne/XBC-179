<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="tsm" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<tsm:forEach items="${testimonyModelList}" var="testimonyModel" varStatus="number">
<tr>
	<td>${testimonyModel.title}</td>
	<td>
		<div class="btn-group">
		  <button type="button" class="btn btn-normal dropdown-toggle" data-toggle="dropdown">
		    <span class="fa fa-bars"></span>
		    <span class="sr-only">Toggle Dropdown</span>
		  </button>
		  <ul class="dropdown-menu" role="menu">
			    <li><a id="${testimonyModel.idTestimony}" class="btn-edit">Edit</a></li>
			     <li><a id="${testimonyModel.idTestimony}" class="btn-deactive">Deactive</a></li>
			    <li class="divider"></li>
			</ul>
			</div>
	</td>
</tr>

</tsm:forEach>