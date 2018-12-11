<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<form action="#" method="get" id="form-office-tambah"
	class="form-horizontal">
		<div class="form-group">
			<label class="control-label col-md-3" for="name">Office Name</label>
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
			<label class="control-label col-md-3" for="notes">Notes</label>
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
			<button type="submit" class="btn btn-primary btn-sm">Simpan</button>
		</div>
</form>
<script>
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
</script>
