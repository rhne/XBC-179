<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<form id="form-tambah-question" class="form-horizontal" >
	<select id="questionId" name="questionId">
		<c:forEach items="${questionModelList}" var="questionModel" varStatus="number">
			<option value='{
				"id": "${questionModel.id}",
				"question": "${questionModel.question}"
			}'>${questionModel.question}</option>
		</c:forEach>
	</select>
	
	<div class="modal-footer" style="border-top: 0 none;">
		<button type="submit" class="btn btn-primary btn-sm">Save</button>
		<button type="button" class="btn btn-normal btn-sm" data-dismiss="modal">Cancel</button>
	</div>
</form>
