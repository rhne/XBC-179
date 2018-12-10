<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<form action="#" method="get" id="form-biodata-edit"
	class="form-horizontal">

	<!-- Biodata ID To Edit -->
	<input type="hidden" id="id" name="id" value="${biodataModel.id}" />

	<!-- Name -->
	<div class="form-group">
		<label class="control-label col-md-3" for="name">Name</label>
		<div class="col-md-8">
			<input type="text" id="name" name="name" class="form-control"
				value="${biodataModel.name}" required="required">
		</div>
	</div>

	<!-- Last Education -->
	<div class="form-group">
		<label class="control-label col-md-3" for="lastEducation">Last
			Education</label>
		<div class="col-md-8">
			<input type="text" id="lastEducation" name="lastEducation"
				value="${biodataModel.lastEducation}" class="form-control"
				required="required">
		</div>
	</div>

	<!-- Educational Level -->
	<div class="form-group">
		<label class="control-label col-md-3" for="educationalLevel">Educational
			Level</label>
		<div class="col-md-8">
			<input type="text" id="educationalLevel" name="educationalLevel"
				value="${biodataModel.educationalLevel}" class="form-control"
				required="required">
		</div>
	</div>

	<!-- Graduation Year -->
	<div class="form-group">
		<label class="control-label col-md-3" for="graduationYear">Graduation
			Year</label>
		<div class="col-md-8">
			<input type="text" id="graduationYear" name="graduationYear"
				value="${biodataModel.graduationYear}" class="form-control"
				required="required">
		</div>
	</div>

	<!-- Majors -->
	<div class="form-group">
		<label class="control-label col-md-3" for="majors">Majors</label>
		<div class="col-md-8">
			<input type="text" id="majors" name="majors"
				value="${biodataModel.majors}" class="form-control"
				required="required">
		</div>
	</div>

	<!-- GPA -->
	<div class="form-group">
		<label class="control-label col-md-3" for="gpa">GPA</label>
		<div class="col-md-8">
			<input type="text" id="gpa" name="gpa" value="${biodataModel.gpa}"
				class="form-control" required="required">
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
		<label class="control-label col-md-3" for="bootcampTestType">Bootcamp
			Test Type</label>
		<div class="col-md-8">
			<select id="bootcampTestType" name="bootcampTestType"
				class="form-control">
				<c:forEach items="${bootcampTestTypeModelList}"
					var="bootcamptesttypeModel">
					<option value="${bootcamptesttypeModel.id}">${bootcamptesttypeModel.name}</option>
				</c:forEach>
			</select>
		</div>
	</div>

	<!-- 4 box -->
	<div class="form-group">
		<label class="control-label col-md-3" for="box"></label>
		<div class="col-md-8">
			<!-- IQ -->
			<div class="col-md-3">
				<input type="text" id="iq" name="iq" class="form-control"
					placeholder="IQ" value="${biodataModel.iq}">
			</div>
			<!-- DU -->
			<div class="col-md-3">
				<input type="text" id="du" name="du" class="form-control"
					placeholder="DU" value="${biodataModel.du}">
			</div>
			<!-- NL -->
			<div class="col-md-3">
				<input type="text" id="nl" name="nl" class="form-control"
					placeholder="NL" value="${biodataModel.nestedLogic}">
			</div>
			<!-- JT -->
			<div class="col-md-3">
				<input type="text" id="jt" name="jt" class="form-control"
					placeholder="JT" value="${biodataModel.joinTable}">
			</div>
		</div>
	</div>

	<!-- Arithmetic -->
	<div class="form-group">
		<label class="control-label col-md-3" for="arithmetic">Arithmetic</label>
		<div class="col-md-8">
			<input type="text" id="arithmetic" name="arithmetic"
				class="form-control" placeholder="Arithmetic"
				value="${biodataModel.arithmetic}">
		</div>
	</div>

	<!-- TRO -->
	<div class="form-group">
		<label class="control-label col-md-3" for="tro">TRO</label>
		<div class="col-md-8">
			<input type="text" id="tro" name="tro" class="form-control"
				placeholder="TRO" value="${biodataModel.tro}">
		</div>
	</div>

	<!-- Interviewer -->
	<div class="form-group">
		<label class="control-label col-md-3" for="interviewer">Interviewer</label>
		<div class="col-md-8">
			<input type="text" id="interviewer" name="interviewer"
				class="form-control" placeholder="Interviewer"
				value="${biodataModel.interviewer}">
		</div>
	</div>

	<!-- Notes -->
	<div class="form-group">
		<label class="control-label col-md-3" for="notes">Notes</label>
		<div class="col-md-8">
			<textarea id="notes" name="notes" class="form-control"
				placeholder="Notes" value="${biodataModel.notes}"></textarea>
		</div>
	</div>

	<!-- Submit Button -->
	<div class="modal-footer">
		<button type="submit" class="btn btn-primary btn-sm">Save</button>
	</div>
</form>