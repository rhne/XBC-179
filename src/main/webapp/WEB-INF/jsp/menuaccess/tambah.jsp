<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<form action = "#" method = "get" id="form-menu-akses-tambah" class="form-horizontal" onsubmit="return validasi_input(this)">
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
		<label class="control-label col-md-3" for="idMenu">Menu</label>
		<div class="col-md-8">
			<select class="form-control" id="idMenu" name="idMenu">
				<c:forEach items="${menuModelList}" var="menuModel">
					<option value="${menuModel.id}">${menuModel.title}</option>		
				</c:forEach>
			</select>
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