<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<form action="#" method="get" id="form-bootcamp-test-type-edit"
	class="form-horizontal">
<input type="hidden" id="id" name="id" value="${bootcamptesttypeModel.id}" />
		<div class="form-group">
			<label class="control-label col-md-3" for="name">Name</label>
			<div class="col-md-8">
				<input type="text" id="name" name="name" class="form-control" value="${bootcamptesttypeModel.name}">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-3" for="notes">Notes</label>
			<div class="col-md-8">
				<TextArea id="notes" name="notes" class="form-control">${bootcamptesttypeModel.notes}</TextArea>
			</div>
		</div>
		<div class="modal-footer">
			<button type="submit" class="btn btn-primary btn-sm" onclick="return validasi_input();">Edit</button>
			<button type="button" class="btn btn-danger btn-sm" data-dismiss="modal">Cancel</button>
		</div>
</form>
<script type="text/javascript">

function validasi_input(){
	var name = document.getElementById("name");
	var notes = document.getElementById("notes");
		if (name.value == ""){
		alert("Nama Is Still Empty :v");
		return false;
		}else if (notes.value == ""){
		alert("Notes Is Still Empty :v");
		return false;
		}
	return true;
}
	
</script>