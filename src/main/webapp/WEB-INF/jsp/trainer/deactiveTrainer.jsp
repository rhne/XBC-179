<h4>Are you sure want to deactive this ?</h4>
<form action="#" method="get" id="form-deactive-trainer" class="form-horizontal">
	<input type="hidden" id="id" name="idTrainer" value="${trainerModel.id}" />
	<input type="hidden" id="nameTrainer" name="trainerName" value="${trainerModel.name}"/>
	<input type="hidden" id="noteTrainer" name="trainerNote" value="${trainerModel.notes}"/>
	<div class="form-group">
		<label class="control-label col-md-3" for="nameTrainer">Name</label>
		<div class="col-md-8">
			<input type="text" style="background-color: orange; color: white" id="nameTrainer" name="trainerName" class="form-control" placeholder="Name" value="${trainerModel.name}" disabled="disabled"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="noteTrainer">Note</label>
		<div class="col-md-8">
			<textarea rows="5" cols="10" style="background-color: orange; color: white;" name="trainerNote" id="noteTrainer" class="form-control" disabled="disabled">${trainerModel.notes}</textarea>
		</div>
	</div>

	<div class="modal-footer">
		<input type="submit" class="btn btn-danger btn-sm" value="Yes">
		<input type="button" class="btn btn-warning btn-sm" data-dismiss="modal" value="No"/>
	</div>
</form>