<h4>Are you sure want to deactive this ?</h4>
<form action="#" method="get" id="form-deactive-bootcamp" class="form-horizontal">
	<input type="hidden" id="id" name="idBootcamp" value="${bootcampTypeModel.idBootcamp}" />
	<input type="hidden" id="id" name="bootcampName" value="${bootcampTypeModel.name}" />
	<input type="hidden" id="id" name="bootcampNotes" value="${bootcampTypeModel.notes}" />
	<div class="form-group">
		<label class="control-label col-md-3" for="nameBootcamp">Bootcamp</label>
		<div class="col-md-8">
			<input type="text" style="outline : 0px; background-color: orange; color: white" id="nameBootcamp" name="bootcampName" class="form-control" placeholder="Title" value="${bootcampTypeModel.name}" disabled="disabled"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="notesBootcamp">Notes</label>
		<div class="col-md-8">
			<textarea rows="5" cols="10" style="outline : 0px; background-color: orange; color: white" name="bootcampNotes" id="notesBootcamp" class="form-control" disabled="disabled">${bootcampTypeModel.notes}</textarea>
		</div>
	</div>
	
	<div class="modal-footer">
		<input type="submit" class="btn btn-danger btn-sm" value="Yes">
		<input type="button" class="btn btn-warning btn-sm" data-dismiss="modal" value="Cancel">
	</div>
</form>