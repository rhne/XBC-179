<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<form id="form-akun-tambah" class="form-horizontal" >
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
			<input type="text" id="password" name="password" class="form-control" required>
		</div>
	</div>
	<div class="form-group">
	<label class="control-label col-md-3" for="rePass">Re-type Password</label>
		<div class="col-md-8">
			<input type="text" id="rePass" name="rePass" class="form-control" required>
		</div>
	</div>

	<div class="modal-footer">
		<button type="submit" class="btn btn-primary btn-sm" onclick="return validasi_input()">Save</button>
		<button type="button" class="btn btn-warning btn-sm" data-dismiss="modal">Cancel</button>
	</div>
</form>

<script type="text/javascript">

	function cekuser(a) {
		valid = /^[A-Za-z][a-zA-Z0-9-_\.]{7,}$/;
		return valid.test(a);
	}
	function cekpass(a) {
		valid = /(?=^.{1,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/;
		return valid.test(a);
	}
	
	function validasi_input(){
		var password = document.getElementById("password").value;
		var rePass = document.getElementById("rePass").value;
		var name = document.getElementById("name").value;
		
		if (password != rePass){
    		alert("Password dan Retype Password tidak sesuai!");
    		return false;
  		} else if (!cekuser(name)) {
  			 alert("Username, isi dengan kombinasi huruf dan angka dan minimal 8 character!");
  			 return false;
  		} else if (!cekpass(password)) {
  			 alert("Password, isi dengan kombinasi angka, huruf kecil dan HURUF BESAR!");
  			 return false;
  		}
		return true;
	}
	
</script>