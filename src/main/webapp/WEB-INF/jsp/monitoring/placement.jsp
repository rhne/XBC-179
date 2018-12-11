<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<form action="#" method="get" id="form-monitoring-placement"
	class="form-horizontal">
	
	<!-- Monitoring ID To Placement -->
	<input type="hidden" id="id" name="id" value="${monitoringModel.id}" />
	
	<!-- Placement Date -->
	<div class="form-group">
		<label class="control-label col-md-3" for="placementDate">Placement Date</label>
		<div class="col-md-8">
			<input type="date" id="placementDate" name="placementDate" class="form-control" required="required">
		</div>
	</div>
	
	<!-- Placement At -->
	<div class="form-group">
		<label class="control-label col-md-3" for="placementAt">Placement At</label>
		<div class="col-md-8">
			<input type="text" id="placementAt" name="placementAt" class="form-control" required="required">
		</div>
	</div>
	
	<!-- Notes -->
	<div class="form-group">
		<label class="control-label col-md-3" for="notes">Notes</label>
		<div class="col-md-8">
			<textarea id="notes" name="notes" class="form-control"></textarea> 
		</div>
	</div>
	
	<!-- Submit Button -->
	<div class="modal-footer">
		<button type="submit" class="btn btn-primary btn-sm">Save</button>
	</div>
</form>