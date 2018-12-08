<h4>Deactive this ?</h4>
<form action="#" method="get" id="form-deactive-bootcamp" class="form-horizontal">
	<input type="hidden" id="id" name="idBootcamp" value="${bootcampTypeModel.idBootcamp}" />
	<div class="form-group">
		<div class="col-md-8">
			<input type="text" id="nameBootcamp" name="bootcampName" class="form-control" placeholder="Title" value="${bootcampTypeModel.name}" disabled="disabled"/>
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-8">
			<textarea rows="5" cols="10" name="bootcampNotes" id="notesBootcamp" class="form-control" disabled="disabled">${bootcampTypeModel.notes}</textarea>
		</div>
	</div>
	
	<div class="modal-footer">
		<input type="submit" class="btn btn-primary btn-sm" value="Yes">
		<input type="button" class="btn btn-primary btn-sm" data-dismiss="modal" value="Cancel">
	</div>
</form>