<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<form action="#" method="get" id="form-office-edit"
	class="form-horizontal">
	<input type="hidden" id="id" name="id" value="${officeModel.id}" />
		<div class="form-group">
			<label class="control-label col-md-3" for="name">Office Name</label>
			<div class="col-md-8">
				<input type="text" id="office-name" name="office-name" class="form-control" value="${officeModel.name}">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-3" for="phone">Phone</label>
			<div class="col-md-8">
				<input type="text" id="phone" name="phone" class="form-control" value="${officeModel.phone}">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-3" for="email">Email</label>
			<div class="col-md-8">
				<input type="text" id="email" name="email" class="form-control" value="${officeModel.email}">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-3" for="address">Address</label>
			<div class="col-md-8">
				<TextArea id="address" name="address" class="form-control">${officeModel.address}</TextArea>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-3" for="notes">Notes</label>
			<div class="col-md-8">
				<TextArea id="office-notes" name="office-notes" class="form-control">${officeModel.notes}</TextArea>
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
			<button type="submit" class="btn btn-primary btn-sm">Simpan</button>
		</div>
</form>
<script>
listDataRoom();
function listDataRoom() {
	$.ajax({
		url:"office/list_room.html",
		type:"get",
		dataType:"html",
		success:function(result){
			$("#list-data-room").html(result);
		}
	});
}

$("#list-data-room").on("click", ".btn-delete", function(){
	var jsonId = JSON.parse($(this).prop('code'));
	alert(jsonId);
	var roomId = jsonId;
	alert(roomId);
	roomArray.pop(roomId);
	listDataRoom();
});


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
