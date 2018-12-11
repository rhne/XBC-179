<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<form action="#" method="get" id="form-monitoring-edit"
	class="form-horizontal">

	<!-- Monitoring ID to Edit -->
	<input type="hidden" id="id" name="id" value="${monitoringModel.id}" />

	<!-- Name -->
	<div class="form-group">
		<label class="control-label col-md-3" for="name">Name</label>
		<div class="col-md-8">
			<input type="text" id="name" name="name" class="form-control"
				value="${monitoringModel.biodataModel.name}" disabled="disabled" required="required">
		</div>
	</div>

	<!-- Idle Date -->
	<div class="form-group">
		<label class="control-label col-md-3" for="idleDate">Idle Date</label>
		<div class="col-md-8">
			<input type="date" id="idleDate" name="idleDate" class="form-control"
				value="${monitoringModel.idleDate}" required="required">
		</div>
	</div>
	
	<!-- Last Project At -->
	<div class="form-group">
		<label class="control-label col-md-3" for="lastProject">Last
			Project at</label>
		<div class="col-md-8">
			<input type="text" id="lastProject" name="lastProject"
				class="form-control" value="${monitoringModel.lastProject}"
				required="required">
		</div>
	</div>
	
	<!-- Idle Reason -->
	<div class="form-group">
		<label class="control-label col-md-3" for="idleReason">Idle
			Reason</label>
		<div class="col-md-8">
			<input type="text" id="idleReason" name="idleReason"
				class="form-control" value="${monitoringModel.idleReason}">
		</div>
	</div>
	
	<!-- Submit Button -->
	<div class="modal-footer">
		<button type="submit" class="btn btn-primary btn-sm">Save</button>
	</div>
</form>