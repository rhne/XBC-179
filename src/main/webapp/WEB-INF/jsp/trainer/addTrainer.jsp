<form action="#" method="get" id="form-add-trainer" class="form-horizontal">
	<div class="form-group">
		<label class="control-label col-md-3" for="nameTrainer">Name</label>
		<div class="col-md-8">
			<input type="text" id="nameTrainer" name="trainerName" class="form-control" placeholder="Name">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="noteTrainer">Note</label>
		<div class="col-md-8">
			<input type="text" id="noteTrainer" name="trainerNote" class="form-control" placeholder="Notes">
		</div>
	</div>
	<input type="hidden" id="statusTrainer" name="trainerStatus" value="1">

	<div class="modal-footer">
		<input type="submit" class="btn btn-primary btn-sm" value="Save">
		<input type="reset" class="btn btn-default btn-sm" value="Cancel">
	</div>
</form>