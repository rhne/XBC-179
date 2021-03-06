<div class="box box-danger">
	<div class="box-header with-border">
		<h3 class="box-title">TRAINER</h3>
		<div class="box-tools">
			<div class="input-group input-group-sm" style="width: 200px;'">
				<input type="text" id="txt-search" name="search-box" class="form-control pull-right" placeholder="Search by Name">
				<div class="input-group-btn">
					<button type="button" id="btn-search" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="search"><i class="fa fa-search"></i></button>
					<button type="button" id="btn-add" class="btn btn-primary" data-toggle="tooltip" data-placement="bottom" title="add new"><i class="fa fa-plus"></i></button>
				</div>
			</div>
		</div>
	</div>
	<div class="box-body">
		<table class="table table-striped table-hover" id="trainer-table">
			<thead>
				<tr>
					<td><b>NAME</b></td>
					<td><b>STATUS</b></td>
					<td></td>
				</tr>
			</thead>
			
			<tbody id="list-data-trainer"></tbody>
		</table>
	</div>
</div>

<div class="modal fade" id="modal-input">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header" style="background-color:#605ca8;">
				<h4 class="modal-title" style="color: white;"></h4>
			</div>
			<div class="modal-body"></div>
		</div>
	</div>
</div>

<div class="modal fade" id="modal-deactive">
	<div class="modal-dialog">
		<div class="alert alert-warning alert-dismissible">
        	<h4 class="modal-title"><i class="icon fa fa-question-circle"></i>Deactive</h4>
            <div class="modal-body">
			</div>
       	</div>
	</div>
</div>

<div class="modal fade" id="modal-alert-deactive">
	<div class="modal-dialog">
		<div class="alert alert-danger alert-dismissible">
        	<h4 class="modal-title"><i class="icon fa fa-question-circle"></i>Success !</h4>
        	Data Successfully Deactivated
            <div class="modal-body">
			
			</div>
       	</div>
	</div>
</div>

<div class="modal fade" id = "modal-alert-add">
	<div class="modal-dialog">
		<div class="alert alert-success alert-dismissible">
        	<h4 class="modal-title"><i class="icon fa fa-check"></i>Success!</h4>
            Data Successfully Added !
       	</div>
	</div>
</div>

<div class="modal fade" id = "modal-alert-update">
	<div class="modal-dialog">
		<div class="alert alert-warning alert-dismissible">
        	<h4 class="modal-title"><i class="icon fa fa-check"></i>Success!</h4>
            Data Successfully Updated !
       	</div>
	</div>
</div>

<script>
	listDataTrainer();
	function listDataTrainer(){
		$.ajax({
			url : "trainer/listTrainer.html",
			type : "get",
			dataType : "html",
			success : function(result){
				$("#list-data-trainer").html(result);
			}
		});
	}
	
	$("#btn-add").on("click", function() {
		$.ajax({
			url:"trainer/addTrainer.html",
			type: "get",
			dataType: "html",
			success: function(result){
				$("#modal-input").find(".modal-title").html("Add Trainer");
				$("#modal-input").find(".modal-body").html(result);
				$("#modal-input").modal("show");
			}
		});
	});
	
	$("#modal-input").on("submit", "#form-add-trainer", function(){
		$.ajax({
			url : "trainer/addTrainer/save.json",
			type : "get",
			dataType : "json",
			data : $(this).serialize(),
			success : function(result){
				$("#modal-alert-add").find(".modal-title");
				$("#modal-alert-add").modal("show");
				$("#modal-input").modal("hide");
				listDataTrainer();
			}
		});
		return false;
	});

	$("#btn-search").click(function(){
		var name = $("#txt-search").val();
		$.ajax({
			url : "trainer/searchTrainer/name.html",
			type : "get",
			dataType : "html",
			data : {searchName : name},
			success : function(result){
				$("#list-data-trainer").html(result);
			}
		});
		return false;
	});
	
	$("#list-data-trainer").on("click", ".btn-edit", function(){
		var idEdit = $(this).prop('id');
		$.ajax({
			url : "trainer/editTrainer.html",
			type : "get",
			dataType : "html",
			data : {idEdit : idEdit},
			success : function(result){
				$("#modal-input").find(".modal-title").html("Edit Trainer")
				$("#modal-input").find(".modal-body").html(result);
				$("#modal-input").modal("show");
			}
		});
	});
	
	$("#modal-input").on("submit", "#form-edit-trainer", function(){
		$.ajax({
			url : "trainer/editTrainer/save.json",
			type : "get",
			dataType : "json",
			data : $(this).serialize(),
			success : function(result){
				$("#modal-alert-update").find(".modal-title");  
				$("#modal-alert-update").modal("show");
				$("#modal-input").modal("hide");
				listDataTrainer();
			}
		});
		return false;
	});
	
	$("#list-data-trainer").on("click", ".btn-deactive", function(){
		var idTrainer = $(this).prop('id');
		$.ajax({
			url : "trainer/deactiveTrainer.html",
			type : "get",
			dataType : "html",
			data : {idDeactive : idTrainer},
			success : function(result){ 
				$("#modal-deactive").modal("show");
				$("#modal-deactive").find(".modal-body").html(result);
			}
		});
	});
	
	$("#modal-deactive").on("submit", "#form-deactive-trainer", function(){
		$.ajax({
			url : "trainer/deactiveTrainer/save.json",
			type : "get",
			dataType : "json",
			data : $(this).serialize(),
			success : function(result){
				$("#modal-alert-deactive").find(".modal-title")
				$("#modal-alert-deactive").modal("show");
				$("#modal-deactive").modal("hide");
				listDataTrainer();
			}
		});
		return false;
	});
	
</script>