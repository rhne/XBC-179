<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">User Data</h3>
		<div class="box-tools">
			<div class="input-group input-group-sm" style="width: 200px;'">
				<input type="text" id="nameCari" name="table_search" class="form-control pull-right" placeholder="Search by Username">
				<div class="input-group-btn">
					<button type="button" id="button-search" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="search"><i class="fa fa-search"></i></button>
                    <button type="button" id="button-tambah" class="btn btn-primary btn-sm" data-toggle="tooltip" data-placement="top" title="Create Data"><i class="fa fa-user-plus"></i></button>
                </div>
               	
			</div>
		</div>
	</div>
	<div class="box-body">
		<table class="table" id="table-user">
			<thead>
			<tr>
				<th>Username</th>
				<th>Role</th>
				<th>Status</th>
			</tr>
			</thead>
			<tbody id="list-data-akun">
			
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

<div class="modal fade" id = "modal-alert2">
	<div class="modal-dialog">
		<div class="alert alert-success alert-dismissible">
        	<h4 class="modal-title"><i class="icon fa fa-check"></i>Success!</h4>
            Data Successfully Updated ...
       	</div>
	</div>
</div>

<div class="modal fade" id="modal-deactivate">
	<div class="modal-dialog">
		<div class="alert alert-warning alert-dismissible">
        	<h4 class="modal-title"><i class="icon fa fa-question-circle"></i>Confirmation</h4>
            
            <div class="modal-body">
			
			</div>
       	</div>
	</div>
</div>
</div>

<script>
	listDataAkun();

	function listDataAkun() {
		$.ajax({
			url:"user/list.html",
			type:"get",
			dataType:"html",
			success:function(result){
				$("#list-data-akun").html(result);
			}
		});
	}
	$(document).ready(function(){
		$("#button-tambah").on("click", function(){
			$.ajax({
				url:"user/tambah.html",
				type:"get",
				dataType:"html",
				success:function(result){
					$("#modal-input").find(".modal-title").html("Add User");
					$("#modal-input").find(".modal-body").html(result);
					$("#modal-input").modal("show");
				}
			});
		});
		
		$("#modal-input").on("submit", "#form-akun-tambah", function(){
			$.ajax({
				url:"user/create.json",
				type:"get",
				dataType:"json",
				data:$(this).serialize(),
				success:function(result){
					$("#modal-alert1").find(".modal-title");  
					$("#modal-alert1").modal("show");
					$("#modal-input").modal("hide");
					listDataAkun();
				}
			});
			return false;
		});
		
		$("#button-search").on("click", function(){
			var nameCari = document.getElementById("nameCari").value;
			$.ajax({
				url:"user/search/name.html",
				type:"get",
				dataType:"html",
				data:{nameCari:nameCari},
				success: function(result){
					$("#list-data-akun").html(result);
				}
			});
			return false;
		});
		
		$("#list-data-akun").on("click", "#btn-edit",function(){
			var id = $(this).val();
			$.ajax({
				url:"user/edit.html",
				type:"get",
				dataType:"html",
				data: {id:id},
				success: function(result){
					$("#modal-input").find(".modal-title").html("Form Edit Data");
					$("#modal-input").find(".modal-body").html(result);
					$("#modal-input").modal("show");
				}
			});
		});
		
		$("#modal-input").on("submit","#form-akun-edit", function(){
			$.ajax({
				url:"user/edit/save.json",
				type:"get",
				dataType:"json",
				data:$(this).serialize(),
				success: function(result){
					$("#modal-alert2").find(".modal-title");  
					$("#modal-alert2").modal("show");
					$("#modal-input").modal("hide");
					listDataAkun();
				}
			});
			return false;
		});
		
		$("#list-data-akun").on("click", "#btn-deactivate", function(){
			var id = $(this).val();
			$.ajax({
				url:"user/deactivate.html",
				type:"get",
				dataType:"html",
				data: {id:id},
				success:function(result){
					$("#modal-deactivate").find(".modal-body").html(result);
					$("#modal-deactivate").modal("show");
				}
			});
		});
		
		$("#modal-deactivate").on("submit","#form-deactivate", function(){
			$.ajax({
				url:"user/deactivate/save.json",
				type:"get",
				dataType:"json",
				data:$(this).serialize(),
				success: function(result){
					$("#modal-deactivate").modal("hide");
					listDataAkun();
				}
			});
			return false;
		});
	});
</script>