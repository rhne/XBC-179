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
	<button type="button" id="button-tambah-room-baru" class="btn btn-primary btn-sm"><i class="fa fa-user-plus"></i>Room</button>
			<div class="box-body">
		<table class="table" id="table-room">
			<thead>
			<tr>
				<th>Code</th>
				<th>Name</th>
				<th>Capacity</th>
			</tr>
			</thead>
			<tbody id="list-data-room-edit">
			
			</tbody>
		</table>
	</div>
		<div class="modal-footer">
			<button type="submit" class="btn btn-primary btn-sm">Simpan</button>
		</div>
</form>

<div class="modal fade" id="modal-input-room-baru">
	<div class="modal-dialog">
		<div class = "modal-content">
			<div class="modal-header" style="background-color:#3c8dbc;">
				<h4 class="modal-title" style="color:white;"></h4>
			</div>
			
			<div class="modal-body">
			
			</div>
		</div>
	</div>
</div>
<script>
var roomArray = new Array;
listDataRoomDB();

function listDataRoomDB() {
	$.ajax({
		url : "office/list_room.html",
		type : "get",
		dataType : "html",
		data : { idOffice : $("#id").val() },
		success : function(result){
			$("#list-data-room-edit").html(result);
		}
	});
}

$("#list-data-room-edit").on("click", ".btn-edit", function() {
	
	var Id = $(this).prop('id');
	$.ajax({
		url : "office/edit_room.html",
		type : "get",
		dataType : "html",
		data : {
			id : Id
		},
		success : function(result) {
			
			$("#modal-room").find(".modal-title").html("Form Edit Room");
			$("#modal-room").find(".modal-body").html(result);
			$("#modal-room").modal("show");
		}
	});
});

$("#list-data-room-edit").on("click", ".btn-deactivate", function() {
	var Id = $(this).prop('id');
	$.ajax({
		url: "office/delete_room",
		type: "get",
		dataType: "html",
		data: {
			id: Id
		},
		success: function (result) {
			$("#modal-alert-delete-room").find(".modal-body").html(result);
			$("#modal-alert-delete-room").modal("show");
		}
	});
});
$("#modal-alert-delete-room").on("submit", "#form-confirm-delete-room", function() {
	$.ajax({
		url: "office/delete_room/save.json",
		type: "get",
		dataType: "json",
		data: $(this).serialize(),
		success: function (result) {
			$("#modal-alert-delete-room").modal("hide");
			listDataRoomDB();
		}
});
});
/*  function newRoomListTable() {
	var roomListTable = '<tr></tr>';
	
	for(i=0; i<roomArray.length; i++) {
		roomListTable += '<tr><td>' + roomArray[i]['code'] + '</td>';
		roomListTable += '<td>' + roomArray[i]['name'] + '</td>';
		roomListTable += '<td>' + roomArray[i]['capacity'] + '</td>';
		roomListTable += '<td><div class="btn-group"> <button type="button" class="btn btn-normal dropdown-toggle" data-toggle="dropdown"> <span class="fa fa-bars"></span> <span class="sr-only">Toggle Dropdown</span> </button> <ul class="dropdown-menu" role="menu"> <li><a ';
		roomListTable += 'id=' + JSON.stringify(roomArray[i]);
		roomListTable += ' class="btn-delete">Delete</a></li>';
		roomListTable += '<li><a ';
		roomListTable += 'id=' + JSON.stringify(roomArray[i]);
		roomListTable += ' class="btn-edit">Edit</a></li> </ul></div></td>';
		roomListTable += '</tr>';
	}
	
	var html $("#modal-input").find("#list-data-room-edit").html();
	html = $("#modal-input").find("#list-data-room-edit").html(html+roomListTable);
} */

$("#modal-input-room-baru").on("submit", "#form-tambah-room-baru", function(){
	
	var room = {
			code: $("#code").val(),
			name: $("#name").val(),
			capacity: $("#capacity").val(),
			projector: $("#projector").val(),
			notes: $("#notes").val()
		};
		roomArray.push(room);
		newRoomListTable();
		$("#modal-alert1").modal("show");
		$("#modal-input-room-baru").modal("hide");
		return false;
	});

/* $("#list-data-room-edit").on("click", ".btn-delete", function(){
	var deletedId = $(this).prop('id');
	var jsonId = JSON.parse(deletedId);
	alert(deletedId);
	arrayTrainer.pop(jsonId);
	listDataRoomDB();
});
 */

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
 $("#button-tambah-room-baru").on("click", function(){
		$.ajax({
			url:"office/tambah_room.html",
			type:"get",
			dataType:"html",
			data: {
				id: id
			},
			success:function(result){
				$("#modal-input-room-baru").find(".modal-title").html("Form Room");
				$("#modal-input-room-baru").find(".modal-body").html(result);
				$("#modal-input-room-baru").modal("show");
			}
		});
	});
	
</script>
