<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<form id="form-question-tambah" class="form-horizontal" onsubmit="return validasi_input();">
<div class="form-group" style="padding: 20px;">
	<label>Version</label>
	<input id="version" name="version" class="form-control" disabled="disabled">
	<br/>
	<button type="button" id="btn-tambah-question" class="btn btn-primary btn-sm">+ Question</button>
	<br/>
	<label style="padding-top: 24px;">Question</label>
	<div>
		<table class="table" id="table-user">
			<thead>
			<tr>
				<th>No.</th>
				<th>Question</th>
				<th>Created On</th>
				<th>Is Delete</th>
			</tr>
			</thead>
			<tbody id="list-data-question">
			
			</tbody>
		</table>
	</div>
	<div class="modal-footer" style="border-top: 0 none;">
		<button type="submit" class="btn btn-primary btn-sm">Save</button>
		<button type="button" class="btn btn-normal btn-sm" data-dismiss="modal">Cancel</button>
	</div>
</div>
</form>

<div class="modal fade" id="modal-input-question">
	<div class="modal-dialog">
		<div class = "modal-content">
			<div class="modal-header" style="background-color:#3c8dbc;">
				<h4 class="modal-title" style="color:white;"></h4>
			</div>
			
			<div class="modal-body">
			
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">

	listDataQuestion();
	
	function listDataQuestion() {
		$.ajax({
			url:"question/list.html",
			type:"get",
			dataType:"html",
			success:function(result){
				$("#list-data-question").html(result);
				alert(result);
			}
		});
	}
	
	$(document).ready(function(){
		$("#btn-tambah-question").on("click", function(){
			$.ajax({
				url:"question/tambah.html",
				type:"get",
				dataType:"html",
				success:function(result){
					$("#modal-input-question").find(".modal-title").html("Question");
					$("#modal-input-question").find(".modal-body").html(result);
					$("#modal-input-question").modal("show");
				}
			});
		});
	});
	
	
	function validasi_input(){
		var question = document.getElementById("question");
  		if (question.value == ""){
    		alert("Cie mikir? Isi dong");
    		return false;
  		}
		return true;
	}
	
</script>