<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<form id="form-tambah-question" class="form-horizontal" >
	<input type="hidden" id="versionId" name="versionId" value="${versionId}">
	<div class="form-group" style="margin-left: 0px;">
		<label>Test</label> <br/>
		<select id="questionId[]" name="questionId">
			<c:forEach items="${testModelList}" var="testModel" varStatus="number">
				<option value="${testModel.id}">${testModel.name}</option>
			</c:forEach>
		</select>
	</div>
	
	<c:forEach items="${questionModelList}" var="questionModel" varStatus="number">
		<label>${number.count}. ${questionModel.question}</label>
		<textarea rows="3" class="form-control" id="${questionModel.id}" name="${questionModel.id}"
		style="resize:vertical"></textarea>
	</c:forEach>
	
	<div class="modal-footer" style="border-top: 0 none;">
		<button type="submit" class="btn btn-primary btn-sm">Save</button>
		<button type="button" class="btn btn-normal btn-sm" data-dismiss="modal">Cancel</button>
	</div>
</form>
