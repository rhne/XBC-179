<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<form action="#" method="get" id="form-biodata-edit"
	class="form-horizontal">

	<!-- Biodata ID -->
	<input type="hidden" id="id" name="id" value="${biodataModel.id}" />

	<!-- Name -->
	<div class="form-group">
		<label class="control-label col-md-3" for="name">Name</label>
		<div class="col-md-8">
			<input type="text" id="name" name="name" class="form-control" value="${biodataModel.name}" disabled="disabled">
		</div>
	</div>

	<!-- Last Education -->
	<div class="form-group">
		<label class="control-label col-md-3" for="lastEducation">Last Education</label>
		<div class="col-md-8">
			<input type="text" id="lastEducation" name="lastEducation" value="${biodataModel.name}" class="form-control">
		</div>
	</div>

	<!-- Educational Level -->
	<div class="form-group">
		<label class="control-label col-md-3" for="educationalLevel">Educational Level</label>
		<div class="col-md-8">
			<input type="text" id="educationalLevel" name="educationalLevel" value="${biodataModel.educationalLevel}" class="form-control">
		</div>
	</div>

	<!-- Graduation Year -->
	<div class="form-group">
		<label class="control-label col-md-3" for="graduationYear">Graduation Year</label>
		<div class="col-md-8">
			<input type="text" id="graduationYear" name="graduationYear" value="${biodataModel.graduationYear}"
				class="form-control">
		</div>
	</div>

	<!-- Majors -->
	<div class="form-group">
		<label class="control-label col-md-3" for="majors">Majors</label>
		<div class="col-md-8">
			<input type="text" id="majors" name="majors" value="${biodataModel.majors}" class="form-control">
		</div>
	</div>

	<!-- GPA -->
	<div class="form-group">
		<label class="control-label col-md-3" for="gpa">GPA</label>
		<div class="col-md-8">
			<input type="text" id="gpa" name="gpa" value="${biodataModel.gpa}" class="form-control">
		</div>
	</div>

	<!-- Gender -->
	<div class="form-group">
		<label class="control-label col-md-3" for="gender">Gender</label>
		<div class="col-md-8">
			<input type="radio" id="male" name="gender" value="male" />Male <input
				type="radio" id="female" name="gender" value="female" />Female
		</div>
	</div>

	<!-- Bootcamp Test Type -->
	<div class="form-group">
		<label class="control-label col-md-3" for="bootcampTestType">Bootcamp Test Type</label>
		<div class="col-md-8">
			<select id="bootcampTestType" name="bootcampTestType"
				class="form-control">
				<c:forEach items="${bootcamptesttypeModelList}" var="bootcamptesttypeModel">
					<option value="${bootcamptesttypeModel.id}">${bootcamptesttypeModel.name}</option>
				</c:forEach>
			</select>
		</div>
	</div>

	<!-- 4 box -->
	<div class="form-group">
		<label class="control-label col-md-3" for="box"></label>
		<div class="col-md-8">
			<div class="col-md-4">
				<input type="text" id="iq" name="iq" class="form-control">
			</div>
			<div class="col-md-2">
				<input type="text" id="du" name="du" class="form-control">
			</div>
			<div class="col-md-2">
				<input type="text" id="nl" name="nl" class="form-control">
			</div>
			<div class="col-md-2">
				<input type="text" id="jt" name="jt" class="form-control">
			</div>
		</div>
	</div>

	<!-- Arithmetic -->
	<div class="form-group">
		<label class="control-label col-md-3" for="arithmetic">Arithmetic</label>
		<div class="col-md-8">
			<input type="text" id="arithmetic" name="arithmetic"
				class="form-control">
		</div>
	</div>

	<!-- TRO -->
	<div class="form-group">
		<label class="control-label col-md-3" for="tro">TRO</label>
		<div class="col-md-8">
			<input type="text" id="tro" name="tro" class="form-control">
		</div>
	</div>

	<!-- Interviewer -->
	<div class="form-group">
		<label class="control-label col-md-3" for="interviewer">Interviewer</label>
		<div class="col-md-8">
			<input type="text" id="interviewer" name="interviewer"
				class="form-control">
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