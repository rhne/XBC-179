<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<form action="#" method="get" id="form-assignment-edit"
	class="form-horizontal">
	
	<input type="hidden" id="id" name="id" value="${assignmentModel.id}" />
	
	<div class="form-group">
	<label class="control-label col-md-3" for="name">Name</label>
		<div class="col-md-8">
			<input type="text" id="name" name="name" class="form-control" value="${assignmentModel.biodataModel.name}" disabled="disabled">
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-md-3" for="title">Title</label>
		<div class="col-md-8">
			<input type="text" id="title" name="title" class="form-control" value="${assignmentModel.title}">
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-md-3" for="startDate">Start Date</label>
		<div class="col-md-8">
			<input type="date" id="startDate" name="startDate" class="form-control" value="${assignmentModel.startDate}">
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-md-3" for="endDate">End Date</label>
		<div class="col-md-8">
			<input type="date" id="endDate" name="endDate" class="form-control" value="${assignmentModel.endDate}">
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-md-3" for="deskripsi">Description</label>
		<div class="col-md-8">
			<textarea id="deskripsi" name="deskripsi" class="form-control" value="${assignmentModel.description}"></textarea> 
		</div>
	</div>
	
	<div class="modal-footer">
		<button type="submit" class="btn btn-primary btn-sm">Save</button>
	</div>
</form>