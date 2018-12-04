<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<form action = "#" method = "get" id="form-role-tambah" class="form-horizontal">
	<div class="form-group">
		<label class="control-label col-md-3" for="kode">Role Code</label>
		<div class="col-md-8">
			<input type="text" id="kode" name="kode" value="${roleAuto}" class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="name">Role Name</label>
		<div class="col-md-8">
			<input type="text" id="name" name="name" class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="description">Description</label>
		<div class="col-md-8">
			<textarea id="deskripsi" name="deskripsi" class="form-control"></textarea> 
		</div>
	</div>

	<div class="modal-footer">
		<button type="submit" class="btn btn-primary btn-sm">Simpan</button>
	</div>
</form>