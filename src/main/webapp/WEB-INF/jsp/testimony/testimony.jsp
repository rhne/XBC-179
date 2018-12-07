<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">TESTIMONY</h3>
		<div class="box-tools">
			<div class="input-group input-group-sm" style="width: 200px;'">
				<input type="text" id="txt-search" name="search-box" class="form-control pull-right" placeholder="Search by Title">
				<div class="input-group-btn">
					<button type="button" id="btn-search" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="search"><i class="fa fa-search"></i></button>
					<button type="button" id="btn-add" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="add new"><i class="fa fa-plus"></i></button>
				</div>
			</div>
		</div>
	</div>
	<div class="box-body">
		<table class="table" id="testimony-table">
			<thead>
				<tr>
					<td>TITLE</td>
					<td></td>
				</tr>
			</thead>
			
			<tbody id="list-data-testimony"></tbody>
		</table>
	</div>
</div>

<div class="modal fade" id="modal-input">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title"></h4>
			</div>
			<div class="modal-body"></div>
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

<div class="modal fade" id = "modal-alert-delete">
	<div class="modal-dialog">
		<div class="alert alert-danger alert-dismissible">
        	<h4 class="modal-title"><i class="icon fa fa-check"></i>Success!</h4>
            Data Successfully Deleted !
       	</div>
	</div>
</div>

<script>
	listDataTestimony();
	function listDataTestimony(){
		$.ajax({
			url : "testimony/listTestimony.html",
			type : "get",
			dataType : "html",
			success : function(result){
				$("#list-data-testimony").html(result);
			}
		});
	}
	
	$(document).ready(function(){
	$("#btn-add").on("click", function() {
		alert("add new");
		$.ajax({
			url:"testimony/addTestimony.html",
			type: "get",
			dataType: "html",
			success: function(result){
				$("#modal-input").find(".modal-body").html(result);
				$("#modal-input").modal("show");
			}
		});
	});
	
	$("#modal-input").on("submit", "#form-add-testimony", function(){
		validation();
		$.ajax({
			url : "testimony/addTestimony/save.json",
			type : "get",
			dataType : "json",
			data : $(this).serialize(),
			success : function(result){
				$("#modal-alert-add").find(".modal-title");  
				$("#modal-alert-add").modal("show");
				$("#modal-input").modal("hide");
				listDataTestimony();
			}
		});
		return false;
	});
	
	$("#list-data-testimony").on("click", ".btn-edit", function(){
		var idEdit = $(this).prop('id');
		$.ajax({
			url : "testimony/editTestimony.html",
			type : "get",
			dataType : "html",
			data : {idEdit : idEdit},
			success : function(result){
				$("#modal-input").find(".modal-body").html(result);
				$("#modal-input").modal("show");
			}
		});
	});
	
	$("#modal-input").on("submit", "#form-edit-testimony", function(){
		$.ajax({
			url : "testimony/editTestimony/save.json",
			type : "get",
			dataType : "json",
			data : $(this).serialize(),
			success : function(result){
				$("#modal-alert-update").find(".modal-title");  
				$("#modal-alert-update").modal("show");
				$("#modal-input").modal("hide");
				listDataTestimony();
			}
		});
		return false;
	});
	
	$("#btn-search").click(function(){
		var title = $("#txt-search").val();
		$.ajax({
			url : "testimony/searchTestimony/title.html",
			type : "get",
			dataType : "html",
			data : {searchTitle : title},
			success : function(result){
				$("#list-data-testimony").html(result);
			}
		});
		return false;
	});
	
	$("#list-data-testimony").on("click", ".btn-delete", function(){
		var idDelete = $(this).prop('id');
		$.ajax({
			url : "testimony/deleteTestimony.html",
			type : "get",
			dataType : "html",
			data : {idDelete : idDelete},
			success : function(result){
				$("#modal-input").find(".modal-body").html(result);
				$("#modal-input").modal("show");
			}
		});
	});
	
	$("#modal-input").on("submit", "#form-delete-testimony", function(){
		$.ajax({
			url : "testimony/deleteTestimony/save.json",
			type : "get",
			dataType : "json",
			data : $(this).serialize(),
			success : function(result){
				$("#modal-alert-delete").find(".modal-title");  
				$("#modal-alert-delete").modal("show");
				$("#modal-input").modal("hide");
				listDataTestimony();
			}
		});
		return false;
	});
	
});
</script>