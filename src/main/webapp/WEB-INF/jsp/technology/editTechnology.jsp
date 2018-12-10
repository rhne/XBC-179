<form action="#" method="get" id="form-add-technology" class="form-horizontal">
	<input type="hidden" id="id" name="idTechnology" value="${technologyModel.idTech}" />
	<div class="form-group">
		<div class="col-md-8">
			<input type="text" id="nameTech" name="techName" class="form-control" value="${technologyModel.name}">
		</div>
	</div>
	<div class="form-group">
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

<div class="modal fade" id="modal-edit">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header" style="background-color:#605ca8;">
				<h4 class="modal-title" style="color: white;"></h4>
			</div>
			<div class="modal-body"></div>
		</div>
	</div>
</div>

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
	
	var arrayTrainer = new Array;
	
	listDataTrainer();
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
	
	/* $("#modal-edit").on("click", "#btn-add-trainer", function() {
		$.ajax({
			url:"technology/addTechTrainer.html",
			type: "get",
			dataType: "html",
			success: function(result){
				$("#modal-input-trainer").find(".modal-title").html("Select Trainer")
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
			htmlSyntax = htmlSyntax + ' class="btn-delete">Delete</a></li>';
			htmlSyntax = htmlSyntax + '<li class="divider"></li></ul></div></td></tr>';
			
		}
		$("#modal-edit").find("#list-data-trainer").html(htmlSyntax);
	}


	$("#modal-edit").on("submit", "#form-add-tech-trainer", function(){
		
		var newIdTrainer = $("#idTrainer").val();
		arrayTrainer.push(JSON.parse(newIdTrainer));
		alert(newIdTrainer);
		listDataTrainer();
		listTrainer();
		$("#modal-input-trainer").modal("hide");
		return false;
		});
	
	$("#modal-edit").on("click", ".btn-delete", function(){
		var jsonId = JSON.parse($(this).prop('id'));
		alert(jsonId);
		var trainerId = jsonId;
		alert(trainerId);
		arrayTrainer.pop(trainerId);
		listDataTrainer();
		listTrainer();
	}); */
	
</script>