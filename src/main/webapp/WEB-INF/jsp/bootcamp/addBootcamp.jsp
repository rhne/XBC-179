<form action="#" method="get" id="form-add-bootcamp" class="form-horizontal">
	<div class="form-group">
		<label class="control-label col-md-3" for="nameBootcamp">Name</label>
		<div class="col-md-8">
			<input type="text" id="nameBootcamp" name="bootcampName" class="form-control" placeholder="Name">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="notesBootcamp">Notes</label>
		<div class="col-md-8">
			<textarea rows="5" cols="10" name="bootcampNotes" id="notesBootcamp" class="form-control" placeholder="Notes"></textarea>
		</div>
	</div>
	
	<div class="modal-footer">
		<input type="submit" class="btn btn-primary btn-sm" value="Save">
		<input type="button" class="btn btn-default btn-sm" data-dismiss="modal" value="Cancel">
	</div>
</form>
