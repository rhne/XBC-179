<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">Question Data</h3>
		<div class="box-tools">
				<div class="input-group input-group-sm" style="width: 200px;">
				<div class="input-group-btn">
                    <button type="button" id="button-tambah" class="btn btn-primary btn-sm" data-toggle="tooltip" data-placement="top" title="Create Data"><i class="fa fa-plus"> New</i></button>
                </div>
				</div>
		</div>
	</div>
	<div class="box-body">
		<table class="table" id="table-user">
			<thead>
			<tr>
				<th>No.</th>
				<th>Question</th>
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
            Are you sure you want to delete?
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
			url:"question/list.html",
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
				url:"question/tambah.html",
				type:"get",
				dataType:"html",
				success:function(result){
					$("#modal-input").find(".modal-title").html("Question");
					$("#modal-input").find(".modal-body").html(result);
					$("#modal-input").modal("show");
				}
			});
		});
		
		$("#modal-input").on("submit", "#form-question-tambah", function(){
			$.ajax({
				url: "question/create.json",
				type: "post",
				dataType: "json",
				data: $(this).serialize(),
				success: function(result){
					$("#modal-alert1").find(".modal-title");  
					$("#modal-alert1").modal("show");
					$("#modal-input").modal("hide");
					listData();
				}
			});
			return false;
		});

		$("#list-data").on("click", ".btn-delete", function() {
			var questionId = $(this).prop('id');
			$.ajax({
				url: "question/delete",
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
		
		$("#modal-alert-delete").on("submit", "#form-confirm-delete", function() {
			$.ajax({
				url: "question/delete/save.json",
				type: "post",
				dataType: "json",
				data: $(this).serialize(),
				success: function (result) {
					$("#modal-alert-delete").modal("hide");
					listData();
				}
			});
			return false;
		});
	});
</script>