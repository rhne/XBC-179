<div class="box box-danger">
	<div class="box-header with-border">
		<h3 class="box-title" align="center">BATCH</h3>
		<div class="box-tools">
			<div class="input-group input-group-sm" style="width: 200px;'">
				<input type="text" id="txt-search" name="search-box" class="form-control pull-right" placeholder="Search by Name">
				<div class="input-group-btn">
					<button type="button" id="btn-search" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="search"><i class="fa fa-search"></i></button>
					<button type="button" id="btn-add" class="btn btn-primary btn-sm" data-toggle="tooltip" data-placement="bottom" title="add new"><i class="fa fa-plus"></i></button>
				</div>
			</div>
		</div>
	</div>
	<div class="box-body">
		<table class="table table-striped table-hover" id="batch-table">
			<thead>
				<tr>
					<td><b>TECHNOLOGY</b></td>
					<td><b>NAME</b></td>
					<td><b>TRAINER</b></td>
					<td></td>
				</tr>
			</thead>
			
			<tbody id="list-data-batch"></tbody>
		</table>
	</div>

<div class="modal fade" id="modal-input">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header" style="background-color:#605ca8;">
				<h4 class="modal-title" style="color:white;"></h4>
			<div class="modal-body"></div>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id = "modal-alert-add">
	<div class="modal-dialog">
		<div class="alert alert-success alert-dismissible">
        	<h4 class="modal-title"><i class="icon fa fa-check"></i>Added !</h4>
            Data successfully added
       	</div>
	</div>
</div>

<div class="modal fade" id = "modal-alert-edit">
	<div class="modal-dialog">
		<div class="alert alert-warning alert-dismissible">
        	<h4 class="modal-title"><i class="icon fa fa-check"></i>Updated !</h4>
            Data successfully sdited
       	</div>
	</div>
</div>

<div class="modal fade" id = "modal-alert-add-participant">
	<div class="modal-dialog">
		<div class="alert alert-success alert-dismissible">
        	<h4 class="modal-title"><i class="icon fa fa-check"></i>Added !</h4>
            Participant successfully added
       	</div>
	</div>
</div>
</div>

<script>
	listDataBatch();
	function listDataBatch(){
		$.ajax({
			url : "batch/listBatch.html",
			type : "get",
			dataType : "html",
			success : function(result){
				$("#list-data-batch").html(result);
			}
		});
	}
	
	$("#btn-add").on("click", function() {
		$.ajax({
			url:"batch/addBatch.html",
			type: "get",
			dataType: "html",
			success: function(result){
				$("#modal-input").find(".modal-title").html("Add New Batch");
				$("#modal-input").find(".modal-body").html(result);
				$("#modal-input").modal("show");
			}
		});
	});
	
	$("#modal-input").on("submit", "#form-add-batch", function(){
		$.ajax({
			url : "batch/addBatch/save.json",
			type : "get",
			dataType : "json",
			data : $(this).serialize(),
			success : function(result){
				$("#modal-alert-add").find(".modal-title");  
				$("#modal-alert-add").modal("show");
				$("#modal-input").modal("hide");
				listDataBatch();
			}
		});
		return false;
	});
	
	$("#list-data-batch").on("click", ".btn-edit", function() {
		var idEdit = $(this).prop('id');
		$.ajax({
			url:"batch/editBatch.html",
			type: "get",
			dataType: "html",
			data : {idEdit : idEdit},
			success: function(result){
				$("#modal-input").find(".modal-title").html("Edit Batch");
				$("#modal-input").find(".modal-body").html(result);
				$("#modal-input").modal("show");
			}
		});
	});
	
	$("#modal-input").on("submit", "#form-edit-batch", function(){
		$.ajax({
			url : "batch/editBatch/save.json",
			type : "get",
			dataType : "json",
			data : $(this).serialize(),
			success : function(result){
				$("#modal-alert-edit").find(".modal-title");  
				$("#modal-alert-edit").modal("show");
				$("#modal-input").modal("hide");
				listDataBatch();
			}
		});
		return false;
	});

	$("#btn-search").click(function(){
		var search = $("#txt-search").val();
		$.ajax({
			url : "batch/searchBatch/nameTech.html",
			type : "get",
			dataType : "html",
			data : {searchnameTech : search},
			success : function(result){
				$("#list-data-batch").html(result);
			}
		});
		return false;
	});
	
	$("#list-data-batch").on("click", ".btn-add-participant", function() {
		var idAdd = $(this).prop('id');
		$.ajax({
			url:"batch/addParticipant.html",
			type: "get",
			dataType: "html",
			data : {idAdd : idAdd},
			success: function(result){
				$("#modal-input").find(".modal-title").html("Add Batch Participant");
				$("#modal-input").find(".modal-body").html(result);
				$("#modal-input").modal("show");
			}
		});
	});
	
	$("#modal-input").on("submit", "#form-add-participant", function(){
		$.ajax({
			url : "batch/addParticipant/save.json",
			type : "get",
			dataType : "json",
			data : $(this).serialize(),
			success : function(result){
				$("#modal-alert-add-participant").find(".modal-title");  
				$("#modal-alert-add-participant").modal("show");
				$("#modal-input").modal("hide");
				listDataBatch();
			}
		});
		return false;
	});
</script>