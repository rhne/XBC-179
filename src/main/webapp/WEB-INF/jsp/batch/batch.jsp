<div class="box box-danger">
	<div class="box-header with-border">
		<h3 class="box-title">BATCH</h3>
		<div class="box-tools">
			<div class="input-group input-group-sm" style="width: 200px;'">
				<input type="text" id="txt-search" name="search-box" class="form-control pull-right" placeholder="Search by Technology / Name">
				<div class="input-group-btn">
					<button type="button" id="btn-search" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="search"><i class="fa fa-search"></i></button>
					<button type="button" id="btn-add" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="add new"><i class="fa fa-plus"></i></button>
				</div>
			</div>
		</div>
	</div>
	<div class="box-body">
		<table class="table table-striped table-hover" id="batch-table">
			<thead>
				<tr>
					<td>TECHNOLOGY</td>
					<td>NAME</td>
					<td>Batch</td>
					<td></td>
				</tr>
			</thead>
			
			<tbody id="list-data-batch"></tbody>
		</table>
	</div>
</div>

<div class="modal fade" id="modal-input">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header" style="background-color:#605ca8;">
				<h4 class="modal-title" style="color:white;"></h4>
			</div>
			<div class="modal-body"></div>
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
			url:"Batch/addBatch.html",
			type: "get",
			dataType: "html",
			success: function(result){
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
				$("#modal-input").modal("hide");
				alert("Data sucessfully added!");
				listDataBatch();
			}
		});
		return false;
	});

</script>