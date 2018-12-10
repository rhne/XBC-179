<form action="#" method="get" id="form-edit-trainer" class="form-horizontal">
	<input type="hidden" id="id" name="idTrainer" value="${trainerModel.idTrainer}" />
	<div class="form-group">
		<label class="control-label col-md-3" for="nameTrainer">Name</label>
		<div class="col-md-8">
			<input type="text" id="nameTrainer" name="trainerName" class="form-control" placeholder="Name" value="${trainerModel.name}"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="noteTrainer">Note</label>
		<div class="col-md-8">
			<textarea rows="5" cols="10" name="trainerNote" id="noteTrainer" class="form-control">${trainerModel.notes}</textarea>
		</div>
	</div>

	<div class="modal-footer">
		<input type="submit" class="btn btn-primary btn-sm" value="Save">
		<input type="button" class="btn btn-default btn-sm" data-dismiss="modal" value="Cancel"/>
	</div>
</form>