<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<form action="#" method="get" id="form-biodata-tambah"
	class="form-horizontal">
	<div class="form-group">
		<label class="control-label col-md-3" for="name">Name</label>
		<div class="col-md-8">
			<input type="text" id="name" name="name" class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="lastEducation">Last Education</label>
		<div class="col-md-8">
			<input type="text" id="lastEducation" name="lastEducation" class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="educationalLevel">Educational Level</label>
		<div class="col-md-8">
			<input type="text" id="educationalLevel" name="educationalLevel" class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="graduationYear">Graduation Year</label>
		<div class="col-md-8">
			<input type="text" id="graduationYear" name="graduationYear" class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="majors">Majors</label>
		<div class="col-md-8">
			<input type="text" id="majors" name="majors" class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="gpa">GPA</label>
		<div class="col-md-8">
			<input type="text" id="gpa" name="gpa" class="form-control">
		</div>
	</div>
	<div class="modal-footer">
		<button type="submit" class="btn btn-primary btn-sm">Simpan</button>
	</div>
</form>