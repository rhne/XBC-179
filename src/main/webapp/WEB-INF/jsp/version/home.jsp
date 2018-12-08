<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">Version Data</h3>
		<div class="box-tools">
				<div class="input-group input-group-sm" style="width: 200px;">
				<div class="input-group-btn">
                    <button type="button" id="button-tambah" class="btn btn-primary btn-sm pull-right" data-toggle="tooltip" title="Create Data"><i class="fa fa-plus"> New</i></button>
                </div>
				</div>
		</div>
	</div>
	<div class="box-body">
		<table class="table" id="table-user">
			<thead>
			<tr>
				<th>No.</th>
				<th>Version</th>
				<th>Created On</th>
				<th>Is Delete</th>
			</tr>
			</thead>
			<tbody id="list-data">
			
			</tbody>
		</table>
	</div>
	
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

<div class="modal fade" id="modal-input-question">
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

<div class="modal fade" id = "modal-alert1">
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
            
            <div class="modal-body">
				Are you sure you want to delete?
				<div class="modal-footer" style="border-top: 0 none;padding-bottom: 0px;">
					<button type="submit" id="btn-confirm-delete" class="btn btn-outline">Yes</button>
					<button type="button" data-dismiss="modal" class="btn btn-outline">No</button>
				</div>
			</div>
       	</div>
	</div>
</div>
</div>

<script>
	var questionArray = new Array;
	var selectedVersionId;
	listData();
	
	window.alert_ = window.alert;
	window.alert = function() {
	    alert_.apply(window,arguments)
	};

	function listData() {
		$.ajax({
			url:"version/list.html",
			type:"get",
			dataType:"html",
			success:function(result){
				$("#list-data").html(result);
			}
		});
	}
	
	$(document).ready(function(){
		$("#button-tambah").on("click", function(){
			$.ajax({
				url:"version/tambah",
				type:"get",
				dataType:"html",
				success:function(result){
					$("#modal-input").find(".modal-title").html("Version");
					$("#modal-input").find(".modal-body").html(result);
					$("#modal-input").modal("show");
				}
			});
		});
		
		//REGION MODAL QUESTION
		$("#modal-input").on("click", "#btn-tambah-question" ,function() {
			
			$.ajax({
				url:"version/tambahquestion",
				type:"get",
				dataType:"html",
				success:function(result){
					$("#modal-input-question").find(".modal-title").html("Add Question");
					$("#modal-input-question").find(".modal-body").html(result);
					$("#modal-input-question").modal("show");
				}
			});
		});
		
		$("#modal-input").on("click", ".btn-delete-question", function() {
			var questionId = JSON.parse($(this).prop('id'));
			
			questionArray.pop(questionId);
			populateQuestionListTable();
		});
		
		$("#modal-input-question").on("submit", "#form-tambah-question", function () {
			var selectedQuestion = $("#questionId").val();
			//questionArray.push(JSON.parse(selectedQuestion));
			questionArray.push(JSON.parse(selectedQuestion));
			//alert(JSON.parse('{"id": 5, "q": "a"}')['q']);   //working syntax
			//alert(JSON.parse(selectedQuestion)['id']);
			//alert(questionArray[0]['id']);
			populateQuestionListTable();
			$("#modal-input-question").modal("hide");
			return false;
		});
		//END REGION MODAL QUESTION
		
		$("#modal-input").on("submit", "#form-tambah-version", function () {
			alert(JSON.stringify(questionArray));
			$("#modal-input").modal("hide");
			$.ajax({
				url: "version/create",
				type: "get",
				dataType: "json",
				data: {
					questions: JSON.stringify(questionArray)
				},
				success: function (result) {
					
				}
			});
			return false;
		});
	});
	
	function populateQuestionListTable() {
		var questionListTable = '<tr></tr>';
		
		for(i=0; i<questionArray.length; i++) {
			questionListTable += '<tr><td>' + (i+1) + '</td>';
			questionListTable += '<td>' + questionArray[i]['question'] + '</td>';
			questionListTable += '<td><div class="btn-group"> <button type="button" class="btn btn-normal dropdown-toggle" data-toggle="dropdown"> <span class="fa fa-bars"></span> <span class="sr-only">Toggle Dropdown</span> </button> <ul class="dropdown-menu" role="menu"> <li><a ';
			questionListTable += 'id={"id":' + '"' + questionArray[i]['id'] + '","question":'+ '"' + questionArray[i]['question'] + "\"}";
			questionListTable += ' class="btn-delete-question">Delete Question</a></li> </ul></div></td>';
			questionListTable += '</tr>';
		}
		
		$("#modal-input").find("#list-data-question").html(questionListTable);
	}
	
	$("#list-data").on("click", ".btn-delete", function() {
		selectedVersionId = $(this).prop('id');
		$("#modal-alert-delete").modal("show");
	});
	
	$("#modal-alert-delete").on("click", "#btn-confirm-delete", function () {
		$.ajax({
			url: "version/delete/save.json",
			type: "get",
			dataType: "json",
			data: {
				id: selectedVersionId
			},
			success: function (result) {
				$("#modal-alert-delete").modal("hide");
				listData();
			}
		});
	});
	
</script>