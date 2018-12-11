<div class="box box-danger">
	<div class="box-header with-border">
		<h3 class="box-title">IDLE MONITORING</h3>
		<div class="box-tools">
			<div class="input-group input-group-sm" style="width: 200px;">
				<input type="text" id="nameCari" name="table-search"
					class="form-control pull-right" placeholder="Search by Name">
				<div class="input-group-btn">
					<button type="button" id="button-search" class="btn btn-default"
						data-toggle="tooltip" data-placement="bottom" title="search">
						<i class="fa fa-search"></i>
					</button>
					<button type="button" id="button-tambah"
						class="btn btn-primary btn-sm" data-toggle="tooltip"
						data-placement="top" title="Create Data">
						<i class="fa fa-plus-square"></i>
					</button>
				</div>
			</div>
		</div>
	</div>
	<div class="box-body">
		<table class="table table-striped table-hover" id="table-monitoring">
			<thead>
				<tr>
					<th>Name</th>
					<th>Idle Date</th>
					<th>Placement Date</th>
				</tr>
			</thead>
			<tbody id="list-data-monitoring">

			</tbody>
		</table>
	</div>

	<div class="modal fade" id="modal-input">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" style="background-color: #605ca8;">
					<h4 class="modal-title" style="color: white;"></h4>
				</div>

				<div class="modal-body"></div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="modal-alert1">
		<div class="modal-dialog">
			<div class="alert alert-success alert-dismissible">
				<h4 class="modal-title">
					<i class="icon fa fa-check"></i>Success!
				</h4>
				Data Successfully Added ...
			</div>
		</div>
	</div>

	<div class="modal fade" id="modal-alert2">
		<div class="modal-dialog">
			<div class="alert alert-success alert-dismissible">
				<h4 class="modal-title">
					<i class="icon fa fa-check"></i>Success!
				</h4>
				Data Successfully Updated ...
			</div>
		</div>
	</div>

	<div class="modal fade" id="modal-alert-delete">
		<div class="modal-dialog">
			<div class="alert alert-warning alert-dismissible">
				<h4 class="modal-title">
					<i class="icon fa fa-question-circle"></i>Confirmation
				</h4>

				<div class="modal-body"></div>
			</div>
		</div>
	</div>
	
</div>



<script>
	listDataMonitoring();

	function listDataMonitoring() {
		$.ajax({
			url : "monitoring/list.html",
			type : "get",
			dataType : "html",
			success : function(result) {
				$("#list-data-monitoring").html(result);
			}
		});
	}
	$(document).ready(
			function() {
				$("#button-tambah").on(
						"click",
						function() {
							$.ajax({
								url : "monitoring/tambah.html",
								type : "get",
								dataType : "html",
								success : function(result) {
									$("#modal-input").find(".modal-title")
											.html("IDLE MONITORING");
									$("#modal-input").find(".modal-body").html(
											result);
									$("#modal-input").modal("show");
								}
							});
						});

				$("#modal-input").on("submit", "#form-monitoring-tambah",
						function() {
							$.ajax({
								url : "monitoring/create.json",
								type : "get",
								dataType : "json",
								data : $(this).serialize(),
								success : function(result) {
									$("#modal-alert1").find(".modal-title");
									$("#modal-alert1").modal("show");
									$("#modal-input").modal("hide");
									listDataMonitoring();
								}
							});
							return false;
						});

				$("#button-search").on("click", function() {
					var nameCari = document.getElementById("nameCari").value;
					$.ajax({
						url : "monitoring/search/name.html",
						type : "get",
						dataType : "html",
						data : {
							nameCari : nameCari
						},
						success : function(result) {
							$("#list-data-monitoring").html(result);
						}
					});
					return false;
				});

				$("#list-data-monitoring").on(
						"click",
						"#btn-edit",
						function() {
							var id = $(this).val();
							$.ajax({
								url : "monitoring/edit.html",
								type : "get",
								dataType : "html",
								data : {
									id : id
								},
								success : function(result) {
									$("#modal-input").find(".modal-title")
											.html("EDIT MONITORING");
									$("#modal-input").find(".modal-body").html(
											result);
									$("#modal-input").modal("show");
								}
							});
						});

				$("#modal-input").on("submit", "#form-monitoring-edit",
						function() {
							$.ajax({
								url : "monitoring/edit/save.json",
								type : "get",
								dataType : "json",
								data : $(this).serialize(),
								success : function(result) {
									$("#modal-alert2").find(".modal-title");
									$("#modal-alert2").modal("show");
									$("#modal-input").modal("hide");
									listDataMonitoring();
								}
							});
							return false;
						});

				$("#list-data-monitoring").on(
						"click",
						"#btn-placement",
						function() {
							var id = $(this).val();
							$.ajax({
								url : "monitoring/placement.html",
								type : "get",
								dataType : "html",
								data : {
									id : id
								},
								success : function(result) {
									$("#modal-input").find(".modal-title")
											.html("INPUT PLACEMENT");
									$("#modal-input").find(".modal-body").html(
											result);
									$("#modal-input").modal("show");
								}
							});
						});

				$("#modal-input").on("submit", "#form-monitoring-placement",
						function() {
							$.ajax({
								url : "monitoring/placement/save.json",
								type : "get",
								dataType : "json",
								data : $(this).serialize(),
								success : function(result) {
									$("#modal-input").modal("hide");
									listDataMonitoring();
								}
							});
							return false;
						});

				$("#list-data-monitoring").on(
						"click",
						"#btn-delete",
						function() {
							var id = $(this).val();
							$.ajax({
								url : "monitoring/delete.html",
								type : "get",
								dataType : "html",
								data : {
									id : id
								},
								success : function(result) {
									$("#modal-alert-delete")
											.find(".modal-body").html(result);
									$("#modal-alert-delete").modal("show");
								}
							});
						});

				$("#modal-alert-delete").on("submit", "#form-confirm-delete",
						function() {
							$.ajax({
								url : "monitoring/delete/save.json",
								type : "get",
								dataType : "json",
								data : $(this).serialize(),
								success : function(result) {
									$("#modal-alert-delete").modal("hide");
									listDataMonitoring();
								}
							});
							return false;
						});
				
				/* Search Monitoring By Name */
				$("#button-search").on("click", function() {
					var nameCari = document.getElementById("nameCari").value;
					$.ajax({
						url : "monitoring/search/name.html",
						type : "get",
						dataType : "html",
						data : {
							nameCari : nameCari
						},
						success : function(result) {
							$("#list-data-monitoring").html(result);
						}
					});
					return false;
				});

			});
</script>