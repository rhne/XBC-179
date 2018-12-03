<form action="#" method="get" id="form-add-technology" class="form-horizontal">
	<div class="form-group">
		<div class="col-md-8">
			<input type="text" id="nameTech" name="techName" class="form-control" placeholder="Name">
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-8">
			<input type="text" id="noteTech" name="techNote" class="form-control" placeholder="Notes">
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-8">
			<button type="button" id="btn-add-trainer" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="add new trainer"><i class="fa fa-plus"></i> Trainer</button>
		</div>
	</div>
	
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
	
	<div class="modal fade" id="modal-input">
		<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title"></h4>
			</div>
			<div class="modal-body"></div>
		</div>
	</div>
	</div>
	<td colspan="2"><input type="submit" class="add-technology" value="submit"></td>
</form>

<script>

	listDataTrainer();
	function listDataTrainer(){
		$.ajax({
			url : "technology/listTrainer.html",
			type : "get",
			dataType : "html",
			success : function(result){
				$("#list-data-trainer").html(result);
			}
		})
	}
</script>