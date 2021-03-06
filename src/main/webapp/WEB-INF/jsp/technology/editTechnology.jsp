<form action="#" method="get" id="form-edit-technology" class="form-horizontal">
	<input type="hidden" id="id" name="idTechnology" value="${technologyModel.id}" />
	<div class="form-group">
		<label class="control-label col-md-3" for="nameTech">Name</label>
		<div class="col-md-8">
			<input type="text" id="nameTech" name="techName" class="form-control" value="${technologyModel.name}">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="noteTech">Notes</label>
		<div class="col-md-8">
			<input type="text" id="noteTech" name="techNote" class="form-control" value="${technologyModel.notes}">
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

<div class="modal fade" id="modal-delete">
	<div class="modal-dialog">
		<div class="alert alert-warning alert-dismissible">
        	<h4 class="modal-title"><i class="icon fa fa-question-circle"></i>Confirmation</h4>
            Are you sure you want to delete?
            <div class="modal-body">
			
			</div>
       	</div>
	</div>
</div>

<script>
	
	listDataTrainer();
	var arrayTrainer = new Array;
	
	function listDataTrainer(){
		$.ajax({
			url : "technology/listTechTrainer.html",
			type : "get",
			dataType : "html",
			data : { idTech : $("#id").val() },
			success : function(result){
				$("#list-data-trainer").html(result);
			}
		});
	}
	
	$("#modal-input").on("click", "#btn-add-trainer", function() {
		$.ajax({
			url:"technology/addTechTrainer.html",
			type: "get",
			dataType: "html",
			success: function(result){
				$("#modal-input-trainer").find(".modal-title").html("Select Trainer");
				$("#modal-input-trainer").find(".modal-body").html(result);
				$("#modal-input-trainer").modal("show");
			}
		});
	});
	
	function listTrainer(){
		var htmlSyntax = "<tr></tr>";
		
		for(i = 0; i < arrayTrainer.length; i++){
			htmlSyntax = htmlSyntax + '<tr><td>' + arrayTrainer[i]['name']+ '</td>';
			htmlSyntax = htmlSyntax + '<td></td>';
			htmlSyntax = htmlSyntax + '<td>Active</td>';
			htmlSyntax = htmlSyntax + '<td> <div class="btn-group">';
			htmlSyntax = htmlSyntax + '<button type="button" class="btn btn-normal dropdown-toggle" data-toggle="dropdown">';
			htmlSyntax = htmlSyntax + '<span class="fa fa-bars"></span> <span class="sr-only">Toggle Dropdown</span></button>';
			htmlSyntax = htmlSyntax + '<ul class="dropdown-menu" role="menu">';
			htmlSyntax = htmlSyntax + '<li><a id={"id":' + '"' + arrayTrainer[i]['id'] + '","name":'+ '"' + arrayTrainer[i]['name'] + '"}';
			htmlSyntax = htmlSyntax + ' class="btn-edit">Edit</a></li>';
			htmlSyntax = htmlSyntax + '<li><a id={"id":' + '"' + arrayTrainer[i]['id'] + '","name":'+ '"' + arrayTrainer[i]['name'] + '"}'; 
			htmlSyntax = htmlSyntax + ' class="btn-delete-arr">Delete</a></li>';
			htmlSyntax = htmlSyntax + '<li class="divider"></li></ul></div></td></tr>';
			
		}
		var html = $("#modal-input").find("#list-data-trainer").html();
		html = $("#modal-input").find("#list-data-trainer").html(html+htmlSyntax);
	}
	

	$("#list-data-trainer").on("submit", "#form-add-tech-trainer", function(){
		
		var newIdTrainer = $("#idTrainer").val();
		arrayTrainer.push(JSON.parse(newIdTrainer));
		//alert(newIdTrainer);
		listTrainer();
		$("#modal-input-trainer").modal("hide");
		return false;
		});
	
	//delete data from array
	$("#list-data-trainer").on("click", ".btn-delete-arr", function(){
		var deletedId = $(this).prop('id');
		var jsonId = JSON.parse(deletedId);
//		alert(deletedId);
		arrayTrainer.pop(jsonId);
		listDataTrainer();
	});
	
	
	//delete data from list
	 $("#modal-input").on("click", ".btn-delete-list", function(){
			var idDelete = $(this).prop('id');
			//alert(idDelete);
			$.ajax({
				url : "technology/deleteTrainer/save.json",
				type : "get",
				dataType : "json",
				data : {idTech : idDelete},
				success : function(result){
					//alert("deleted");
					listDataTrainer();
				}
		}); return false;
	 });
	
</script>