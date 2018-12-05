<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<form action = "#" method = "get" id="form-role-edit" class="form-horizontal">
<div class="form-group">
	<input type="hidden" id="id" name="id" value="${roleModel.id}" />
	<div class="form-group">
		<label class="control-label col-md-3" for="idRole">CODE</label>
		<div class="col-md-8">
			<input type="hidden" id="kode" name="kode" value="${roleModel.kode}">
			<input type="text" id="kodedis" name="kodedis" class="form-control" value="${roleModel.kode}" disabled="disabled">
		</div>
	</div>
	<div class="form-group">
	<label class="control-label col-md-3" for="name">NAME</label>
		<div class="col-md-8">
			<input type="text" id="name" name="name" class="form-control" value="${roleModel.name}">
		</div>
	</div>
	<div class="form-group">
	<label class="control-label col-md-3" for="description">Description</label>
		<div class="col-md-8">
			<textarea id="description" name="description" class="form-control">${roleModel.description}</textarea>
		</div>
	</div>

	<div class="modal-footer">
		<button type="submit" class="btn btn-primary btn-sm">Save</button>
	</div>
</div>
</form>
