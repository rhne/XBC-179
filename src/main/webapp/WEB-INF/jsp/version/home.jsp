<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">Version Data</h3>
		<div class="box-tools">
				<div class="input-group input-group-sm" style="width: 200px;">
				<div class="input-group-btn">
                    <button type="button" id="button-tambah" class="btn btn-primary btn-sm pull-right" data-toggle="tooltip" title="Create Data"><i class="fa fa-plus"> New</i></button>
                </div>
				</div>
		</div>
	</div>
	<div class="box-body">
		<table class="table" id="table-user">
			<thead>
			<tr>
				<th>No.</th>
				<th>Version</th>
				<th>Created On</th>
				<th>Is Delete</th>
			</tr>
			</thead>
			<tbody id="list-data">
			
			</tbody>
		</table>
	</div>
	
<div class="modal fade" id = "modal-input">
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

<div class="modal fade" id = "modal-alert1">
	<div class="modal-dialog">
		<div class="alert alert-success alert-dismissible">
        	<h4 class="modal-title"><i class="icon fa fa-check"></i>Success!</h4>
            Data Successfully Added ...
       	</div>
	</div>
</div>

<div class="modal fade" id="modal-alert-delete">
	<div class="modal-dialog">
		<div class="alert alert-warning alert-dismissible">
        	<h4 class="modal-title"><i class="icon fa fa-question-circle"></i>Confirmation</h4>
            
            <div class="modal-body">
			
			</div>
       	</div>
	</div>
</div>
</div>

<script>
	listData();

	function listData() {
		$.ajax({
			url:"version/list.html",
			type:"get",
			dataType:"html",
			success:function(result){
				$("#list-data").html(result);
			}
		});
	}
	
	$(document).ready(function(){
		$("#button-tambah").on("click", function(){
			$.ajax({
				url:"version/tambah",
				type:"get",
				dataType:"html",
				success:function(result){
					$("#modal-input").find(".modal-title").html("Version");
					$("#modal-input").find(".modal-body").html(result);
					$("#modal-input").modal("show");
				}
			});
		});
		
		//REGION MODAL QUESTION
		$("#modal-input").on("click", "#btn-tambah-question" ,function() {
			$.ajax({
				url:"version/tambahquestion",
				type:"get",
				dataType:"html",
				success:function(result){
					$("#modal-input-question").find(".modal-title").html("Add Question");
					$("#modal-input-question").find(".modal-body").html(result);
					$("#modal-input-question").modal("show");
				}
			});
		});
		
		$("#modal-input").on("click", ".btn-delete", function() {
			var questionId = $(this).prop('id');
			alert(questionId);
			$.ajax({
				url: "version/deletequestion",
				type: "get",
				dataType: "html",
				data: {
					id: questionId
				},
				success: function (result) {
					$("#modal-alert-delete").find(".modal-body").html(result);
					$("#modal-alert-delete").modal("show");
				}
			});
		});
		//END REGION MODAL QUESTION
	});
</script>