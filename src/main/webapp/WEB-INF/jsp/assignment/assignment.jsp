<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">ASSIGNMENT</h3>
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
		<table class="table" id="table-assignment">
			<thead>
				<tr>
					<th>Name</th>
					<th>Start Date</th>
					<th>End Date</th>
				</tr>
			</thead>
			<tbody id="list-data-assignment">

			</tbody>
		</table>
	</div>

	<div class="modal fade" id="modal-input">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" style="background-color: #3c8dbc;">
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
	listDataAssignment();

	function listDataAssignment() {
		$.ajax({
			url : "assignment/list.html",
			type : "get",
			dataType : "html",
			success : function(result) {
				$("#list-data-assignment").html(result);
			}
		});
	}
	$(document).ready(
			function() {
				$("#button-tambah").on(
						"click",
						function() {
							$.ajax({
								url : "assignment/tambah.html",
								type : "get",
								dataType : "html",
								success : function(result) {
									$("#modal-input").find(".modal-title")
											.html("Form Assignment");
									$("#modal-input").find(".modal-body").html(
											result);
									$("#modal-input").modal("show");
								}
							});
						});

				$("#modal-input").on("submit", "#form-assignment-tambah",
						function() {
							$.ajax({
								url : "assignment/create.json",
								type : "get",
								dataType : "json",
								data : $(this).serialize(),
								success : function(result) {
									$("#modal-alert1").find(".modal-title");
									$("#modal-alert1").modal("show");
									$("#modal-input").modal("hide");
									listDataAssignment();
								}
							});
							return false;
						});
				
				/* Search Assignment By Name */
				$("#button-search").on("click", function() {
					var nameCari = document.getElementById("nameCari").value;
					$.ajax({
						url : "assignment/search/name.html",
						type : "get",
						dataType : "html",
						data : {
							nameCari : nameCari
						},
						success : function(result) {
							$("#list-data-assignment").html(result);
						}
					});
					return false;
				});
				
				$("#list-data-assignment").on(
						"click",
						"#btn-edit",
						function() {
							var id = $(this).val();
							$.ajax({
								url : "assignment/edit.html",
								type : "get",
								dataType : "html",
								data : {
									id : id
								},
								success : function(result) {
									$("#modal-input").find(".modal-title")
											.html("Form Edit Assignment");
									$("#modal-input").find(".modal-body").html(
											result);
									$("#modal-input").modal("show");
								}
							});
						});

				$("#modal-input").on("submit", "#form-assignment-edit",
						function() {
							$.ajax({
								url : "assignment/edit/save.json",
								type : "get",
								dataType : "json",
								data : $(this).serialize(),
								success : function(result) {
									$("#modal-alert2").find(".modal-title");
									$("#modal-alert2").modal("show");
									$("#modal-input").modal("hide");
									listDataAssignment();
								}
							});
							return false;
						});

				$("#list-data-assignment").on(
						"click",
						"#btn-delete",
						function() {
							var id = $(this).val();
							$.ajax({
								url : "assignment/delete.html",
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
								url : "assignment/delete/save.json",
								type : "get",
								dataType : "json",
								data : $(this).serialize(),
								success : function(result) {
									$("#modal-alert-delete").modal("hide");
									listDataAssignment();
								}
							});
							return false;
						});
				
				$("#list-data-assignment").on(
						"click",
						"#btn-hold",
						function() {
							var id = $(this).val();
							$.ajax({
								url : "assignment/hold.html",
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

				$("#modal-alert-delete").on("submit", "#form-confirm-hold",
						function() {
							$.ajax({
								url : "assignment/hold/save.json",
								type : "get",
								dataType : "json",
								data : $(this).serialize(),
								success : function(result) {
									$("#modal-alert-delete").modal("hide");
									listDataAssignment();
								}
							});
							return false;
						});
				
				$("#list-data-assignment").on(
						"click",
						"#btn-done",
						function() {
							var id = $(this).val();
							$.ajax({
								url : "assignment/done.html",
								type : "get",
								dataType : "html",
								data : {
									id : id
								},
								success : function(result) {
									$("#modal-input").find(".modal-title")
											.html("Mark As Done");
									$("#modal-input").find(".modal-body").html(
											result);
									$("#modal-input").modal("show");
								}
							});
						});

				$("#modal-input").on("submit", "#form-assignment-done",
						function() {
							$.ajax({
								url : "assignment/done/save.json",
								type : "get",
								dataType : "json",
								data : $(this).serialize(),
								success : function(result) {
									$("#modal-input").modal("hide");
									listDataAssignment();
								}
							});
							return false;
						});
				
				$("#list-data-assignment").on(
						"click",
						"#btn-edit",
						function() {
							var id = $(this).val();
							$.ajax({
								url : "assignment/edit.html",
								type : "get",
								dataType : "html",
								data : {
									id : id
								},
								success : function(result) {
									$("#modal-input").find(".modal-title")
											.html("Form Edit Assignment");
									$("#modal-input").find(".modal-body").html(
											result);
									$("#modal-input").modal("show");
								}
							});
						});

				$("#modal-input").on("submit", "#form-assignment-edit",
						function() {
							$.ajax({
								url : "assignment/edit/save.json",
								type : "get",
								dataType : "json",
								data : $(this).serialize(),
								success : function(result) {
									$("#modal-alert2").find(".modal-title");
									$("#modal-alert2").modal("show");
									$("#modal-input").modal("hide");
									listDataAssignment();
								}
							});
							return false;
						});

			});
</script>