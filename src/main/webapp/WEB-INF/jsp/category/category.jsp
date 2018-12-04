<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">Category</h3>
		<div class="box-tools">
				<div class="input-group input-group-sm" style="width: 200px;">
				<div class="input-group-btn">
                    <button type="button" id="button-tambah" class="btn btn-primary btn-sm" data-toggle="tooltip" data-placement="top" title="Create Data"><i class="fa fa-user-plus"></i></button>
                </div>
				</div>
		</div>
	</div>
	<div class="box-body">
		<table class="table" id="table-category">
			<thead>
			<tr>
				<th>Code</th>
				<th>Name</th>
				<th>Status</th>
			</tr>
			</thead>
			<tbody id="list-data-category">
			
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
	listDataCategory();

	function listDataCategory() {
		$.ajax({
			url:"category/list.html",
			type:"get",
			dataType:"html",
			success:function(result){
				$("#list-data-category").html(result);
			}
		});
	}
	$(document).ready(function(){
		$("#button-tambah").on("click", function(){
			$.ajax({
				url:"category/tambah.html",
				type:"get",
				dataType:"html",
				success:function(result){
					$("#modal-input").find(".modal-title").html("Form Role Data");
					$("#modal-input").find(".modal-body").html(result);
					$("#modal-input").modal("show");
				}
			});
		});
		
		$("#modal-input").on("submit", "#form-category-tambah", function(){
			$.ajax({
				url:"category/create.json",
				type:"get",
				dataType:"json",
				data:$(this).serialize(),
				success:function(result){
					$("#modal-alert").find(".modal-title");  
					$("#modal-alert").modal("show");
					$("#modal-input").modal("hide");
					listDataCategory();
				}
			});
			return false;
		});
		
	});
</script>