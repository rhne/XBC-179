<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<form action="#" method="get" id="form-monitoring-tambah"
	class="form-horizontal">
	
	<!-- Biodata Name from ID -->
	<div class="form-group">
		<label class="control-label col-md-3" for="testId">Name</label>
		<div class="col-md-8">
			<select id="testId" name="testId" class="form-control" required="required">
				<option value="" disabled selected></option>
				<c:forEach items="${biodataModelList}" var="biodataModel">
					<option value="${biodataModel.id}">${biodataModel.name}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	
	<!-- Idle Date -->
	<div class="form-group">
		<label class="control-label col-md-3" for="idleDate">Idle Date</label>
		<div class="col-md-8">
			<input type="date" id="idleDate" name="idleDate" class="form-control" required="required" placeholder="Idle Date">
		</div>
	</div>
	
	<!-- Last Project At -->
	<div class="form-group">
		<label class="control-label col-md-3" for="lastProject">Last
			Project at</label>
		<div class="col-md-8">
			<input type="text" id="lastProject" name="lastProject"
				class="form-control" required="required" placeholder="Last Project At">
		</div>
	</div>
	
	<!-- Idle Reason -->
	<div class="form-group">
		<label class="control-label col-md-3" for="idleReason">Idle
			Reason</label>
		<div class="col-md-8">
			<input type="text" id="idleReason" name="idleReason"
				class="form-control" required="required" placeholder="Idle Reason">
		</div>
	</div>
	
	<!-- Submit Button -->
	<div class="modal-footer">
		<button type="submit" class="btn btn-primary btn-sm">Save</button>
	</div>
</form>