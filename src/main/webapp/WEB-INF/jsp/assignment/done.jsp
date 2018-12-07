<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<form action="#" method="get" id="form-assignment-done"
	class="form-horizontal">
	<input type="hidden" id="id" name="id" value="${assignmentModel.id}" />
	<div class="form-group">
		<label class="control-label col-md-3" for="realizationDate">Realization Date</label>
		<div class="col-md-8">
			<input type="date" id="realizationDate" name="realizationDate" class="form-control">
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-md-3" for="notes">Notes</label>
		<div class="col-md-8">
			<textarea id="notes" name="notes" class="form-control"></textarea> 
		</div>
	</div>
	<div class="modal-footer">
		<button type="submit" class="btn btn-primary btn-sm">Save</button>
	</div>
</form>