<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="clazz" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<clazz:forEach items="${clazzModelList}" var="clazzModel" varStatus="number">
<tr>
	<td>${clazzModel.batchModel.name}</td>
	<td>${clazzModel.biodataModel.name}</td>
	<td>
		<div class="btn-group">
		  <button type="button" class="btn btn-normal dropdown-toggle" data-toggle="dropdown">
		    <span class="fa fa-bars"></span>
		    <span class="sr-only">Toggle Dropdown</span>
		  </button>
		  <ul class="dropdown-menu" role="menu">
			     <li><a id="${clazzModel.clazzId}" class="btn-delete">Deactive</a></li>
			    <li class="divider"></li>
			</ul>
			</div>
	</td>
</tr>

</clazz:forEach>