<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">BIODATA</h3>
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

	<!-- Table Header List -->
	<div class="box-body">
		<table class="table" id="table-biodata">
			<thead>
				<tr>
					<th>Name</th>
					<th>Majors</th>
					<th>GPA</th>
				</tr>
			</thead>
			<tbody id="list-data-biodata">

			</tbody>
		</table>
	</div>

	<!-- Modal Input -->
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

	<!-- Modal Alert Added -->
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

	<!-- Modal Alert Updated -->
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

	<!-- Modal Alert Deactivated -->
	<div class="modal fade" id="modal-deactivate">
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
	listDataBiodata();

	function listDataBiodata() {
		$.ajax({
			url : "biodata/list.html",
			type : "get",
			dataType : "html",
			success : function(result) {
				$("#list-data-biodata").html(result);
			}
		});
	}
	$(document).ready(
			function() {

				/* Add Popup Show */
				$("#button-tambah").on(
						"click",
						function() {
							$.ajax({
								url : "biodata/tambah.html",
								type : "get",
								dataType : "html",
								success : function(result) {
									$("#modal-input").find(".modal-title")
											.html("Form Biodata");
									$("#modal-input").find(".modal-body").html(
											result);
									$("#modal-input").modal("show");
								}
							});
						});

				/* Add Biodata */
				$("#modal-input").on("submit", "#form-biodata-tambah",
						function() {
							$.ajax({
								url : "biodata/create.json",
								type : "get",
								dataType : "json",
								data : $(this).serialize(),
								success : function(result) {
									$("#modal-alert1").find(".modal-title");
									$("#modal-alert1").modal("show");
									$("#modal-input").modal("hide");
									listDataBiodata();
								}
							});
							return false;
						});

				/* Search Biodata By Name */
				$("#button-search").on("click", function() {
					var nameCari = document.getElementById("nameCari").value;
					$.ajax({
						url : "biodata/search/name.html",
						type : "get",
						dataType : "html",
						data : {
							nameCari : nameCari
						},
						success : function(result) {
							$("#list-data-biodata").html(result);
						}
					});
					return false;
				});

				/* Edit Popup Show */
				$("#list-data-biodata").on(
						"click",
						"#btn-edit",
						function() {
							var id = $(this).val();
							$.ajax({
								url : "biodata/edit.html",
								type : "get",
								dataType : "html",
								data : {
									id : id
								},
								success : function(result) {
									$("#modal-input").find(".modal-title")
											.html("Edit Biodata");
									$("#modal-input").find(".modal-body").html(
											result);
									$("#modal-input").modal("show");
								}
							});
						});

				/* Edit Biodata */
				$("#modal-input").on("submit", "#form-biodata-edit",
						function() {
							$.ajax({
								url : "biodata/edit/save.json",
								type : "get",
								dataType : "json",
								data : $(this).serialize(),
								success : function(result) {
									$("#modal-alert2").find(".modal-title");
									$("#modal-alert2").modal("show");
									$("#modal-input").modal("hide");
									listDataBiodata();
								}
							});
							return false;
						});

				/* Deactivate Popup Show */
				$("#list-data-biodata").on(
						"click",
						"#btn-deactivate",
						function() {
							var id = $(this).val();
							$.ajax({
								url : "biodata/deactivate.html",
								type : "get",
								dataType : "html",
								data : {
									id : id
								},
								success : function(result) {
									$("#modal-deactivate").find(".modal-body")
											.html(result);
									$("#modal-deactivate").modal("show");
								}
							});
						});

				/* Deactivate Biodata */
				$("#modal-deactivate").on("submit", "#form-deactivate",
						function() {
							$.ajax({
								url : "biodata/deactivate/save.json",
								type : "get",
								dataType : "json",
								data : $(this).serialize(),
								success : function(result) {
									$("#modal-deactivate").modal("hide");
									listDataBiodata();
								}
							});
							return false;
						});
			});
</script>