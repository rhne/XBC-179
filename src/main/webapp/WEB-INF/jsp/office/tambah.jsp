<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<form action="#" method="get" id="form-office-tambah"
	class="form-horizontal">
		<div class="form-group">
			<label class="control-label col-md-3" for="name">Office Name</label>
			<div class="col-md-8">
				<input type="text" id="name" name="name" class="form-control">
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
			<label class="control-label col-md-3" for="notes">Notes</label>
			<div class="col-md-8">
				<TextArea id="notes" name="notes" class="form-control"></TextArea>
			</div>
		</div>
	<button type="button" id="button-tambah2" class="btn btn-primary btn-sm" data-toggle="tooltip" data-placement="top" ><i class="fa fa-user-plus"></i>Room</button>
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

<script type="text/javascript">
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
$(document).ready(function(){
	$("#button-tambah2").on("click", function(){
		$.ajax({
			url:"office/room.html",
			type:"get",
			dataType:"html",
			success:function(result){
				$("#modal-input").find(".modal-title").html("Form Room");
				$("#modal-input").find(".modal-body").html(result);
				$("#modal-input").modal("show");
			}
		});
	});
	$("#list-data-room").on("click", ".btn-deactivate", function() {
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
				listDataRoom();
			}
		});
		return false;
	});
});
</script>