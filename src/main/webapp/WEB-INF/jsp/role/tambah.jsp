<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<form id="form-role-tambah" class="form-horizontal">
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
			<textarea id="description" name="description" class="form-control"></textarea> 
		</div>
	</div>

	<div class="modal-footer">
		<button type="submit" class="btn btn-primary btn-sm" onclick="return validasi_input()">Save</button>
		<button type="button" class="btn btn-warning btn-sm" data-dismiss="modal">Cancel</button>
	</div>
</form>

<script type="text/javascript">

	function cekrole(a) {
		valid = /^[A-Za-z]{1,}$/;
		return valid.test(a);
	}
	
	function validasi_input(){
		var name = document.getElementById("name").value;
		if (!cekrole(name)) {
  			 alert("Role Name, isi dengan huruf saja!");
  			 return false;
  		}
		return true;
	}
	
</script>