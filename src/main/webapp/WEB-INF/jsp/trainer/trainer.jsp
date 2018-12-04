<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">TRAINER</h3>
		<div class="box-tools">
			<div class="input-group input-group-sm" style="width: 200px;'">
				<input type="text" id="txt-search" name="search-box" class="form-control pull-right" placeholder="Search by Name">
				<div class="input-group-btn">
					<button type="button" id="btn-search" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="search"><i class="fa fa-search"></i></button>
					<button type="button" id="btn-add" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="add new"><i class="fa fa-plus"></i></button>
				</div>
			</div>
		</div>
	</div>
	<div class="box-body">
		<table class="table" id="trainer-table">
			<thead>
				<tr>
					<td>NAME</td>
					<td>STATUS</td>
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
			<div class="modal-header">
				<h4 class="modal-title"></h4>
			</div>
			<div class="modal-body"></div>
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
				$("#modal-input").modal("hide");
				alert("Data sucessfully added!");
				listDataTrainer();
			}
		});
		return false;
	});

</script>