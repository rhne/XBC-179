<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<form action="#" method="get" id="form-category-edit"
	class="form-horizontal">
	<input type="hidden" id="id" name="id" value="${categoryModel.id}" />
		<div class="form-group">
			<label class="control-label col-md-3" for="code">Code</label>
			<div class="col-md-8">
				<input type="text" id="code" name="code" class="form-control" disabled="disabled" value="${categoryModel.code}">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-3" for="name">Name</label>
			<div class="col-md-8">
				<input type="text" id="name" name="name" class="form-control" value="${categoryModel.name}">
			</div>
		</div>
		<div class="modal-footer">
			<button type="submit" class="btn btn-primary btn-sm">Simpan</button>
		</div>
</form>