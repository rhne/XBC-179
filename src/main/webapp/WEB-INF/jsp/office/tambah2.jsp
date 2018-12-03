<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<form action="#" method="get" id="form-office-tambah2"
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
	<button type="button" id="button-tambah2" class="btn btn-primary btn-sm" data-toggle="tooltip" data-placement="top" title="Create Room"><i class="fa fa-user-plus"></i>Room</button>
			<div class="box-body">
		<table class="table" id="table-office">
			<thead>
			<tr>
				<th>Office Name</th>
				<th>Phone</th>
				<th>Email</th>
				<th>Address</th>
				<th>Notes</th>
				<th>Status</th>
			</tr>
			</thead>
			<tbody id="list-data-office2">
			
			</tbody>
		</table>
	</div>
		<div class="modal-footer">
			<button type="submit" class="btn btn-primary btn-sm">Simpan</button>
		</div>
</form>
<script>
listDataOffice2();

function listDataOffice2() {
	$.ajax({
		url:"office/list.html",
		type:"get",
		dataType:"html",
		success:function(result){
			$("#list-data-office2").html(result);
		}
	});
}
$(document).ready(function(){
	$("#button-tambah2").on("click", function(){
		$.ajax({
			url:"office/tambah_room.html",
			type:"get",
			dataType:"html",
			success:function(result){
				$("#modal-input").find(".modal-title").html("Form Role Data");
				$("#modal-input").find(".modal-body").html(result);
				$("#modal-input").modal("show");
			}
		});
	});
	
	$("#modal-input").on("submit", "#form-office-tambah2", function(){
		$.ajax({
			url:"office/create_room.json",
			type:"get",
			dataType:"json",
			data:$(this).serialize(),
			success:function(result){
				$("#modal-alert1").find(".modal-title");  
				$("#modal-alert1").modal("show");
				$("#modal-input").modal("hide");
				listDataAkun();
			}
		});
		return false;
	});
	
});
</script>