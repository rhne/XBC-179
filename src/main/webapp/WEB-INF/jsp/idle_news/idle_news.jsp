<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">Idle News</h3>
		<div class="box-tools">
			<div class="input-group input-group-sm" style="width: 200px;'">
				<input type="text" id="nameCari" name="table_search" class="form-control pull-right" placeholder="Search by Title">
				<div class="input-group-btn">
					<button type="button" id="button-search" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="search"><i class="fa fa-search"></i></button>
                    <button type="button" id="button-tambah" class="btn btn-primary btn-sm" data-toggle="tooltip" data-placement="top" title="Create Data"><i class="fa fa-user-plus"></i></button>
                </div>
               	
			</div>

		</div>
	</div>
	<div class="box-body">
		<table class="table" id="table-idle-news">
		<thead>
			<tr>
				<td>Title</td>
				<td>Category</td>
				<td>Status</td>
			</tr>
		</thead>
			
			<tbody id="list-data-idle-news">
			
			</tbody>
		</table>
	</div>
</div>
<!-- //POPUP -->
<div class="modal fade" id="modal-input">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title"></h4>
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
<div class="modal fade" id="modal-alert-delete">
	<div class="modal-dialog">
		<div class="alert alert-warning alert-dismissible">
        	<h4 class="modal-title"><i class="icon fa fa-question-circle"></i>Confirmation</h4>
            Are you sure you want to delete?
            <div class="modal-body">
			
			</div>
       	</div>
	</div>
</div>


<script type="text/javascript">
	listDataIdleNews();

	function listDataIdleNews() {
		$.ajax({
			url : "idle_news/list.html",
			type : "get",
			dataType : "html",
			success : function(result) {
				$("#list-data-idle-news").html(result);
			}
		});
	}

	$(document).ready(function() {
		$("#button-tambah").on("click", function() {
			$.ajax({
				url : "idle_news/tambah.html",
				type : "get",
				dataType : "html",
				success : function(result) {
					$("#modal-input").find(".modal-title").html("Form Role Data");
					$("#modal-input").find(".modal-body").html(result);
					$("#modal-input").modal("show");
				}
			});
		});


	$("#modal-input").on("submit", "#form-idle-news-tambah", function() {
		$.ajax({
			url : "idle_news/create.json",
			type : "get",
			dataType : "json",
			data : $(this).serialize(),
			success : function(result) {
				$("#modal-alert").find(".modal-title");  
				$("#modal-alert").modal("show");
				$("#modal-input").modal("hide");
				listDataIdleNews();
			}
		});
		return false;
	});
	
	$("#button-search").on("click", function(){
		var nameCari = document.getElementById("nameCari").value;
		$.ajax({
			url:"idle_news/search/name.html",
			type:"get",
			dataType:"html",
			data:{nameCari:nameCari},
			success: function(result){
				$("#list-data-idle-news").html(result);
			}
		});
		return false;
	});
	$("#list-data-idle-news").on("click", ".btn-delete", function() {
		var Id = $(this).prop('id');
		$.ajax({
			url: "idle_news/delete",
			type: "get",
			dataType: "html",
			data: {
				id: Id
			},
			success: function (result) {
				$("#modal-alert-delete").find(".modal-body").html(result);
				$("#modal-alert-delete").modal("show");
			}
		});
	});
	
	$("#modal-alert-delete").on("submit", "#form-confirm-delete", function() {
		$.ajax({
			url: "idle_news/delete/save.json",
			type: "get",
			dataType: "json",
			data: $(this).serialize(),
			success: function (result) {
				$("#modal-alert-delete").modal("hide");
				listDataIdleNews();
			}
		});
		return false;
	});
	});
</script>