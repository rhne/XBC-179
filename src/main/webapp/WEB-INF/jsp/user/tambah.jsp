<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<form action = "#" method = "get" id="form-akun-tambah" class="form-horizontal" onsubmit="return validasi_input(this)">
	<div class="form-group">
		<label class="control-label col-md-3" for="idRole">Role</label>
		<div class="col-md-8">
			<select class="form-control" id="idRole" name="idRole">
				<c:forEach items="${roleModelList}" var="roleModel">
					<option value="${roleModel.id}">${roleModel.name}</option>		
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
	<label class="control-label col-md-3" for="name">Username</label>
		<div class="col-md-8">
			<input type="text" id="name" name="name" class="form-control">
		</div>
	</div>
	<div class="form-group">
	<label class="control-label col-md-3" for="password">Password</label>
		<div class="col-md-8">
			<input type="text" id="password" name="password" class="form-control">
		</div>
	</div>
	<div class="form-group">
	<label class="control-label col-md-3" for="rePass">Re-type Password</label>
		<div class="col-md-8">
			<input type="text" id="rePass" name="rePass" class="form-control">
		</div>
	</div>

	<div class="modal-footer">
		<button type="submit" class="btn btn-primary btn-sm">Simpan</button>
	</div>
</form>

<script type="text/javascript">

	function validasi_input(form){
  		if (form.password.value != form.rePass.value){
    		alert("Password dan Retype Password tidak sesuai!");
    		form.password.focus();
    		return (false);
  		}
		return (true);
	}
	
</script>