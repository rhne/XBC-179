<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<form action="#" method="get" id="form-office-tambah"
	class="form-horizontal">
		<div class="form-group">
			<label class="control-label col-md-3" for="office-name">Office Name</label>
			<div class="col-md-8">
				<input type="text" id="office-name" name="office-name" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-3" for="phone">Phone</label>
			<div class="col-md-8">
				<input type="text" id="phone" name="phone" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-3" for="email">Email</label>
			<div class="col-md-8">
				<input type="text" id="email" name="email" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-3" for="address">Address</label>
			<div class="col-md-8">
				<TextArea id="address" name="address" class="form-control"></TextArea>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-3" for="office-notes">Notes</label>
			<div class="col-md-8">
				<TextArea id="office-notes" name="office-notes" class="form-control"></TextArea>
			</div>
		</div>
	<button type="button" id="button-tambah2" class="btn btn-primary btn-sm"><i class="fa fa-user-plus"></i>Room</button>
			<div class="box-body">
		<table class="table" id="table-room">
			<thead>
			<tr>
				<th>Code</th>
				<th>Name</th>
				<th>Capacity</th>
			</tr>
			</thead>
			<tbody id="list-data-room">
			
			</tbody>
		</table>
	</div>
		<div class="modal-footer">
			<button type="submit" class="btn btn-primary btn-sm" onclick="return validasi_input();">Simpan</button>
			<button type="button" class="btn btn-normal btn-sm" data-dismiss="modal">Cancel</button>
		</div>
</form>
<script>



function validasi_input(){
	var name = document.getElementById("office-name");
	var phone = document.getElementById("phone");
	var email = document.getElementById("email");
	var address = document.getElementById("address");
	var notes = document.getElementById("notes");
		if (name.value == ""){
		alert("Name Is Still Empty :v");
		return false;
		}else if (phone.value == ""){
		alert("Phone Is Still Empty :v");
		return false;
		}else if (email.value == ""){
			alert("Email Is Still Empty :v");
			return false;
			}
		else if (address.value == ""){
			alert("Address Is Still Empty :v");
			return false;
			}
		else if (notes.value == ""){
			alert("Notes Is Still Empty :v");
			return false;
			}
	return true;
}
	
</script>
