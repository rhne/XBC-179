<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<form action="#" method="get" id="form-assignment-tambah"
	class="form-horizontal">
	<div class="form-group">
		<label class="control-label col-md-3" for="testId">Name</label>
		<div class="col-md-8">
			<select id="testId" name="testId" class="form-control">
				<c:forEach items="${biodataModelList}" var="biodataModel">
					<option value="${biodataModel.id}">${biodataModel.name}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="title">Title</label>
		<div class="col-md-8">
			<input type="text" id="title" name="title" class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="startDate">Start Date</label>
		<div class="col-md-8">
			<input type="date" id="startDate" name="startDate" class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="endDate">End Date</label>
		<div class="col-md-8">
			<input type="date" id="endDate" name="endDate" class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="deskripsi">Description</label>
		<div class="col-md-8">
			<textarea id="deskripsi" name="deskripsi" class="form-control"></textarea> 
		</div>
	</div>
	<div class="modal-footer">
		<button type="submit" class="btn btn-primary btn-sm">Simpan</button>
	</div>
</form>