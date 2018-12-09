<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">CLASS</h3>
		<div class="box-tools">
			<div class="input-group input-group-sm" style="width: 200px;'">
				<input type="text" id="txt-search" name="search-box" class="form-control pull-right" placeholder="Search by Batch">
				<div class="input-group-btn">
					<button type="button" id="btn-search" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="search"><i class="fa fa-search"></i></button>
				</div>
			</div>
		</div>
	</div>
	<div class="box-body">
		<table class="table" id="clazz-table">
			<thead>
				<tr>
					<td><b>BATCH</b></td>
					<td><b>NAME</b></td>
					<td></td>
				</tr>
			</thead>
			
			<tbody id="list-data-clazz"></tbody>
		</table>
	</div>
</div>

<div class="modal fade" id="modal-delete">
	<div class="modal-dialog">
		<div class="alert alert-warning alert-dismissible">
        	<h4 class="modal-title"><i class="icon fa fa-question-circle"></i>Delete</h4>
            <div class="modal-body">
			</div>
       	</div>
	</div>
</div>

<div class="modal fade" id = "modal-alert-delete">
	<div class="modal-dialog">
		<div class="alert alert-danger alert-dismissible">
        	<h4 class="modal-title"><i class="icon fa fa-check"></i>Deleted !</h4>
            Data successfully deleted
       	</div>
	</div>
</div>

<script>
	listDataClazz();
	function listDataClazz(){
		$.ajax({
			url : "clazz/listClazz.html",
			type : "get",
			dataType : "html",
			success : function(result){
				$("#list-data-clazz").html(result);
			}
		});
	}

	$("#btn-search").click(function(){
		var batch = $("#txt-search").val();
		$.ajax({
			url : "clazz/searchClazz/batch.html",
			type : "get",
			dataType : "html",
			data : {search : batch},
			success : function(result){
				$("#list-data-class").html(result);
			}
		});
		return false;
	});
	
	$("#list-data-clazz").on("click", ".btn-delete", function() {
		var idDelete = $(this).prop('id');
		$.ajax({
			url:"clazz/deleteParticipant.html",
			type: "get",
			dataType: "html",
			data : {idClazz : idDelete},
			success: function(result){
				$("#modal-delete").find(".modal-body").html(result);
				$("#modal-delete").modal("show");
			}
		});
	});
	
	$("#modal-delete").on("submit", "#form-delete-participant", function(){
		$.ajax({
			url : "clazz/deleteParticipant/save.json",
			type : "get",
			dataType : "json",
			data : $(this).serialize(),
			success : function(result){
				$("#modal-alert-delete").find(".modal-title");  
				$("#modal-alert-delete").modal("show");
				$("#modal-delete").modal("hide");
				listDataClazz();
			}
		});
		return false;
	});
	
	$("#btn-search").click(function(){
		var search = $("#txt-search").val();
		$.ajax({
			url : "clazz/searchClazz/batch.html",
			type : "get",
			dataType : "html",
			data : {batch : search},
			success : function(result){
				$("#list-data-clazz").html(result);
			}
		});
		return false;
	});
</script>