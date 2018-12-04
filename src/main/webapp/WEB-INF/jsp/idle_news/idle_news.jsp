<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">Idle News</h3>
		<div class="box-tools">
			<div class="input-group input-group-sm" style="width: 200px;">
				<input type="text" id="kodeCari" name="table_search" class="form-control pull-right" placeholder="Search">
				<div class="input-group-btn">
                    <button type="button" id="btn-search" class="btn btn-default"><i class="fa fa-search"></i></button>
                    <button type="button" id="button-tambah" class="btn btn-primary btn-sm"><i class="fa fa-user-plus"></i></button>
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
</script>