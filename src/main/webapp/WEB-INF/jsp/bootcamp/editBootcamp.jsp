<form action="#" method="get" id="form-edit-bootcamp" class="form-horizontal">
	<input type="hidden" id="id" name="idBootcamp" value="${bootcampTypeModel.idBootcamp}" />
	<div class="form-group">
		<div class="col-md-8">
			<input type="text" id="nameBootcamp" name="bootcampName" class="form-control" placeholder="Title" value="${bootcampTypeModel.name}"/>
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-8">
			<textarea rows="5" cols="10" name="bootcampNotes" id="notesBootcamp" class="form-control">${bootcampTypeModel.notes}</textarea>
		</div>
	</div>
	
	<div class="modal-footer">
		<input type="submit" class="btn btn-primary btn-sm" value="Save">
		<input type="button" class="btn btn-primary btn-sm" data-dismiss="modal" value="Cancel">
	</div>
</form>