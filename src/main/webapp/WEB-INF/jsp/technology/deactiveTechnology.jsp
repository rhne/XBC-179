<h4>Deactive this ?</h4>
<form action="#" method="get" id="form-deactive-tech" class="form-horizontal">
	<input type="hidden" id="id" name="idTech" value="${technologyModel.idTech}" />
	<div class="form-group">
		<div class="col-md-8">
			<input type="text" id="nameTech" name="techName" class="form-control" value="${technologyModel.name}" disabled="disabled"/>
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-8">
			<input type="text" id="noteTech" name="techNote" class="form-control" value="${technologyModel.notes}" disabled="disabled"/>
		</div>
	</div>	
	<div class="modal-footer">
		<input type="submit" class="btn btn-primary btn-sm" value="Yes">
		<input type="button" class="btn btn-primary btn-sm" data-dismiss="modal" value="Cancel">
	</div>
</form>