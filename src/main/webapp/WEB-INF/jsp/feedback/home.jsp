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

<script type="text/javascript">
showTambahFeedback();
	function showTambahFeedback() {
		$("#modal-input").find(".modal-title").html("Version");
		$("#modal-input").find(".modal-body").load("tambah.html");
		$("#modal-input").modal("show");
	}
</script>