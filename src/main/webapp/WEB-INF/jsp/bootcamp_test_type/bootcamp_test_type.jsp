<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">Bootcamp Test Type</h3>
		<div class="box-tools">
			<div class="input-group input-group-sm" style="width: 200px;'">
				<input type="text" id="nameCari" name="table_search" class="form-control pull-right" placeholder="Search by Name">
				<div class="input-group-btn">
					<button type="button" id="button-search" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="search"><i class="fa fa-search"></i></button>
                    <button type="button" id="button-tambah" class="btn btn-primary btn-sm" data-toggle="tooltip" data-placement="top" title="Create Data"><i class="fa fa-user-plus"></i></button>
                </div>
               	
			</div>
		</div>
	</div>
	<div class="box-body">
		<table class="table" id="table-bootcamp-test-type">
			<thead>
			<tr>
				<th>Name</th>
				<th>Created By</th>
				<th>Status</th>
			</tr>
			</thead>
			<tbody id="list-data-bootcamp-test-type">
			
			</tbody>
		</table>
	</div>
	
	<!-- pop up -->
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

<div class="modal fade" id = "modal-alert">
	<div class="modal-dialog">
		<div class="alert alert-success alert-dismissible">
        	<h4 class="modal-title"><i class="icon fa fa-check"></i>Success!</h4>
            Data Successfully Added ...
       	</div>
	</div>
</div>
</div>

<script>
	listDataBootcampTestType();

	function listDataBootcampTestType() {
		$.ajax({
			url:"bootcamp_test_type/list.html",
			type:"get",
			dataType:"html",
			success:function(result){
				$("#list-data-bootcamp-test-type").html(result);
			}
		});
	}
	$(document).ready(function(){
		$("#button-tambah").on("click", function(){
			$.ajax({
				url:"bootcamp_test_type/tambah.html",
				type:"get",
				dataType:"html",
				success:function(result){
					$("#modal-input").find(".modal-title").html("Form Role Data");
					$("#modal-input").find(".modal-body").html(result);
					$("#modal-input").modal("show");
				}
			});
		});
		
		$("#modal-input").on("submit", "#form-bootcamp-test-type-tambah", function(){
			$.ajax({
				url:"bootcamp_test_type/create.json",
				type:"get",
				dataType:"json",
				data:$(this).serialize(),
				success:function(result){
					$("#modal-alert").find(".modal-title");  
					$("#modal-alert").modal("show");
					$("#modal-input").modal("hide");
					listDataBootcampTestType();
				}
			});
			return false;
		});
		$("#button-search").on("click", function(){
			var nameCari = document.getElementById("nameCari").value;
			$.ajax({
				url:"bootcamp_test_type/search/name.html",
				type:"get",
				dataType:"html",
				data:{nameCari:nameCari},
				success: function(result){
					$("#list-data-bootcamp-test-type").html(result);
				}
			});
			return false;
		});
	});
</script>