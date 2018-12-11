<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="list"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<form action="#" method="get" id="form-add-batch" class="form-horizontal" onsubmit="return validation();">
	<div class="form-group">
		<label class="control-label col-md-3" for="idTechnology" style="color: white;">Technology</label>
		<div class="col-md-8">
			<select class="form-control" id="idTechnology" name="idTechnology">
				<list:forEach items="${technologyModelList}" var="technologyModel">
					<option selected disabled hidden>-Select Technology-</option>
					<option value="${technologyModel.id}">${technologyModel.name}</option>
				</list:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="idTrainer" style="color: white;">Trainer</label>
		<div class="col-md-8">
			<select class="form-control" id="idTrainer" name="idTrainer">
				<list:forEach items="${trainerModelList}" var="trainerModel">
					<option selected disabled hidden>-Select Trainer-</option>
					<option value="${trainerModel.id}">${trainerModel.name}</option>
				</list:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="nameBatch" style="color: white;">Name</label>
		<div class="col-md-8">
			<input type="text" name="batchName" id="nameBatch" class="form-control" placeholder="Name">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="startBatch" style="color: white;">Period From</label>
		<div class="col-md-8">
			<input type="date" name="batchStart" id="startBatch" class="form-control" placeholder="Period from">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="endBatch" style="color: white;">Period To</label>
		<div class="col-md-8">
			<input type="date" name="batchEnd" id="endBatch" class="form-control" placeholder="Period to">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="idRoom" style="color: white;">Room</label>
		<div class="col-md-8">
			<select class="form-control" id="idRoom" name="idRoom">
				<list:forEach items="${roomModelList}" var="roomModel">
					<option selected disabled hidden>-Select Room-</option>
					<option value="${roomModel.id}">${roomModel.name}</option>
				</list:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="idBootcamp" style="color: white;">Bootcamp</label>
		<div class="col-md-8">
			<select class="form-control" id="idBootcamp" name="idBootcamp">
				<list:forEach items="${bootcampTypeModelList}" var="bootcampTypeModel">
					<option selected disabled hidden>-Select Bootcamp-</option>
					<option value="${bootcampTypeModel.idBootcamp}">${bootcampTypeModel.name}</option>
				</list:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="notesBatch" style="color: white;">Notes</label>
		<div class="col-md-8">
			<textarea rows="5" cols="10" name="batchNotes" id="notesBatch" class="form-control" placeholder="Notes"></textarea>
		</div>
	</div>
	
	<div class="modal-footer">
		<input type="submit" class="btn btn-primary btn-sm" value="Save">
		<input type="button" class="btn btn-primary btn-sm" data-dismiss="modal" value="Cancel">
	</div>
</form>

<script type="text/javascript">

	function validation(){
		var name = document.getElementById("nameBatch");
		if (name.value == ""){
			alert("Please fill the field !");
			return false;
		}
			return true;
	}
	
</script>