<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:forEach items="${biodataModelList}" var="biodataModel"
	varStatus="number">
	<tr>
		<td>${biodataModel.name}</td>
		<td>${biodataModel.majors}</td>
		<td>${biodataModel.gpa}</td>
		<td>
			<div class="dropdown">
				<button class="btn btn-link dropdown-toggle" type="button"
					data-toggle="dropdown">
					<i class="fa fa-bars"></i>
				</button>
				<ul class="dropdown-menu">
					<li><button type="button" class="btn btn-link" id="btn-edit"
							value="${biodataModel.id}">Edit</button></li>
					<li><button type="button" class="btn btn-link"
							id="btn-deactivate" value="${biodataModel.id}">Deactivate</button></li>
				</ul>
			</div>
		</td>
	</tr>
</c:forEach>