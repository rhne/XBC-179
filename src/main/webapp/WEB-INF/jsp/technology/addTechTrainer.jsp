<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="trainer" %>
<form action="#" method="get" id="form-add-tech-trainer" class="form-horizontal">
	<div class="form-group">
		<div class="col-md-8">
			<select class="form-control" id="idTrainer" name="idTrainer">
				<trainer:forEach items="${trainerModelList}" var="trainerModel">
					<option value='{ "id": "${trainerModel.idTrainer}", "name": "${trainerModel.name}"}' id="${trainerModel.idTrainer}">${trainerModel.name}
					</option>
				</trainer:forEach>
			</select>
		</div>
	</div>
	<div class="modal-footer">
		<button type="submit" id="submit-tech-trainer" name="submit-tech-trainer" class="btn btn-primary btn-sm" data-toggle="tooltip" data-placement="top" title="simpan" value="${trainerModel.name})"><i class="fa fa-save"></i></button>
		<button type="button" class="btn btn-normal btn-sm" data-dismiss="modal">Cancel</button>
	</div>
</form>
