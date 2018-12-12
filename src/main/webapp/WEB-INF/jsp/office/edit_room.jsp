<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<form action="#" method="get" id="form-room-edit"
	class="form-horizontal">
	<input type="hidden" id="id" name="id" class="form-control" value="${roomModel.id}" >
		<div class="form-group">
			<label class="control-label col-md-3" for="code">Code</label>
			<div class="col-md-8">
				<input type="text" id="code" name="code" class="form-control" value="${roomModel.code}" >
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-3" for="name">Name</label>
			<div class="col-md-8">
				<input type="text" id="name" name="name" class="form-control" value="${roomModel.name}">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-3" for="capacity">Capacity</label>
			<div class="col-md-8">
				<input type="text" id="capacity" name="capacity" class="form-control" value="${roomModel.capacity}">
			</div>
		</div>
			<div class="form-group">
	<label class="control-label col-md-3" for="token">Any Projector</label>
		<div class="col-md-8">
			<input type="radio" id="projector" name="projector" value="1"/>True 
			<input type="radio" id="projector" name="projector" value="0"/>False
		</div>
	</div>
		<div class="form-group">
			<label class="control-label col-md-3" for="notes">Notes</label>
			<div class="col-md-8">
				<TextArea id="notes" name="notes" class="form-control">${roomModel.notes}</TextArea>
			</div>
		</div>
	<button type="submit" id="button-tambah-room" class="btn btn-primary btn-sm" data-toggle="tooltip" data-placement="top" title="Create Room" onclick="return validasi_input();"><i class="fa fa-user-plus"></i>Tambah</button>
			
</form>
<script>
function validasi_input(){
	var code = document.getElementById("code");
	var name = document.getElementById("name");
	var capacity = document.getElementById("capacity");
	var projector = document.getElementById("projector");
	var notes = document.getElementById("notes");
		if (code.value == ""){
		alert("Code Is Still Empty :v");
		return false;
		}else if (name.value == ""){
		alert("Name Is Still Empty :v");
		return false;
		}else if (capacity.value == ""){
			alert("Capacity Is Still Empty :v");
			return false;
			}
		else if (projector.value == ""){
			alert("Projector Is Still Empty :v");
			return false;
			}
		else if (notes.value == ""){
			alert("Notes Is Still Empty :v");
			return false;
			}
	return true;
}
</script>