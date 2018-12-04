<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<form action = "#" method = "get" id="form-akun-edit" class="form-horizontal" onsubmit="return validasi_input(this)">
<div class="form-group">
	<input type="hidden" id="id" name="id" value="${roleModel.id}" />
	<div class="form-group">
		<label class="control-label col-md-3" for="idRole">CODE</label>
		<div class="col-md-8">
			<input type="text" id="name" name="name" class="form-control" value="${roleModel.kode}" disabled="disabled">
		</div>
	</div>
	<div class="form-group">
	<label class="control-label col-md-3" for="name">NAME</label>
		<div class="col-md-8">
			<input type="text" id="name" name="name" class="form-control" value="${roleModel.name}">
		</div>
	</div>
	<div class="form-group">
	<label class="control-label col-md-3" for="password">Password</label>
		<div class="col-md-8">
			<textarea id="deskripsi" name="deskripsi" class="form-control">${roleModel.description}</textarea>
		</div>
	</div>

	<div class="modal-footer">
		<button type="submit" class="btn btn-primary btn-sm">Simpan</button>
	</div>
</div>
</form>
