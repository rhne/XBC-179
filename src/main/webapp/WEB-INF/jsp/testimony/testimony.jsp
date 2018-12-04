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

<script>
	listDatatestimony();
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
	
	$("#btn-add").on("click", function() {
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
		$.ajax({
			url : "testimony/addTestimony/save.json",
			type : "get",
			dataType : "json",
			data : $(this).serialize(),
			success : function(result){
				$("#modal-input").modal("hide");
				alert("Data sucessfully added!");
				listDataTestimony();
			}
		});
		return false;
	});

</script>