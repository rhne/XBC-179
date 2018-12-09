<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="list"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<form action="#" method="get" id="form-add-participant" class="form-horizontal">
	<input type="hidden" id="id" name="idBatch" value="${batchModel.batchId}" />
	<div class="form-group">
		<label class="control-label col-md-3" for="idParticipant">Participant</label>
		<div class="col-md-8">
			<select class="form-control" id="idParticipant" name="idParticipant">
				<list:forEach items="${biodataModelList}" var="biodataModel">
					<option selected disabled hidden>-Select Participant-</option>
					<option value="${biodataModel.id}">${biodataModel.name}</option>
				</list:forEach>
			</select>
		</div>
	</div>
	
	<div class="modal-footer">
		<input type="submit" class="btn btn-primary btn-sm" value="Add">
		<input type="button" class="btn btn-default btn-sm" data-dismiss="modal" value="Cancel">
	</div>
</form>