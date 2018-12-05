<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<form id="form-question-tambah" class="form-horizontal" onsubmit="return validasi_input();">
<div class="form-group" style="padding: 20px;">
	<label>Version</label>
	<textarea id="question" name="question" class="form-control" style="resize:vertical" rows="3"></textarea>
	
	<div class="modal-footer">
		<button type="submit" class="btn btn-primary btn-sm">Save</button>
		<button type="button" class="btn btn-normal btn-sm" data-dismiss="modal">Cancel</button>
	</div>
</div>
</form>

<script type="text/javascript">

	function validasi_input(){
		var question = document.getElementById("question");
  		if (question.value == ""){
    		alert("Cie mikir? Isi dong");
    		return false;
  		}
		return true;
	}
	
</script>