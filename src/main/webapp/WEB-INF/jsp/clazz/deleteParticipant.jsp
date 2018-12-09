<h4>Are you sure want to delete this ?</h4>
<form action="#" method="get" id="form-delete-participant">
	<input type="hidden" id="id" name="idClazz" value="${clazzModel.clazzId}" />
	<input type="hidden" id="idBatch" name="batchId" value="${clazzModel.batchId}" />
	<input type="hidden" id="idBatch" name="biodataId" value="${clazzModel.biodataId}" />
	<table>
		<tr>
			<td>Batch :</td>
			<td>${clazzModel.batchModel.name}</td>
		</tr>
		<tr>
			<td>Name :</td>
			<td>${clazzModel.biodataModel.name}</td>
		</tr>
	</table>
	
	<div class="modal-footer">
		<input type="submit" class="btn btn-danger btn-sm" value="Yes">
		<input type="button" class="btn btn-warning btn-sm" data-dismiss="modal" value="Cancel">
	</div>
</form>