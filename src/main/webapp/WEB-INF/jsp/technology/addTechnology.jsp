<form action="#" method="get" id="form-add-technology" class="form-horizontal">
	<div class="form-group">
		<label class="control-label col-md-3" for="nameTech">Name</label>
		<div class="col-md-8">
			<input type="text" id="nameTech" name="techName" class="form-control" placeholder="Name">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="noteTech">Notes</label>
		<div class="col-md-8">
			<input type="text" id="noteTech" name="techNote" class="form-control" placeholder="Notes">
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-8">
			<button type="button" id="btn-add-trainer" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="add new trainer"><i class="fa fa-plus"></i> Trainer</button>
		</div>
	</div>
	<input type="hidden" id="statusTech" name="techStatus" value="1">

	<div class="box-body">
		<table class="table" id="trainer-table">
			<thead>
				<tr>
					<td>NAME</td>
					<td>CREATED BY</td>
					<td>STATUS</td>
					<td></td>
				</tr>
				<tbody id="list-data-trainer"></tbody>
			</thead>
		</table>
	</div>

	<div class="modal-footer" style="border-top: 0 none;">
		<button type="submit" class="btn btn-primary btn-sm">Save</button>
		<button type="button" class="btn btn-normal btn-sm" data-dismiss="modal">Cancel</button>
	</div>
</form>

<div class="modal fade" id="modal-input-trainer">
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


<script>

	function listDataTrainer(){
		$.ajax({
			url : "technology/listTechTrainer.html",
			type : "get",
			dataType : "html",
			success : function(result){
				$("#list-data-trainer").html(result);
			}
		});
	}
	
</script>