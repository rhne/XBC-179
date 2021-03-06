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
			<button type="submit" class="btn btn-primary btn-sm" onclick="return validasi_input();">Simpan</button>
			<button type="button" class="btn btn-danger btn-sm" data-dismiss="modal">Cancel</button>
		</div>
</form>

<script type="text/javascript">

function validasi_input(){
	var code = document.getElementById("code");
	var name = document.getElementById("name");
		if (code.value == ""){
		alert("Code Is Still Empty :v");
		return false;
		}else if (name.value == ""){
		alert("Name Is Still Empty :v");
		return false;
		}
	return true;
}
	
</script>