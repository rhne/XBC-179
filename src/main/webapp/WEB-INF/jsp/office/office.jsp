<div class="box box-danger">
	<div class="box-header with-border">
		<h3 class="box-title">Office</h3>
		<div class="box-tools">
			<div class="input-group input-group-sm" style="width: 200px;'">
				<input type="text" id="nameCari" name="table_search" class="form-control pull-right" placeholder="Search by Name">
				<div class="input-group-btn">
					<button type="button" id="button-search" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="search"><i class="fa fa-search"></i></button>
                    <button type="button" id="button-tambah" class="btn btn-primary btn-sm" data-toggle="tooltip" data-placement="top" title="Create Data"><i class="fa fa-user-plus"></i></button>
                </div>
		</div>
	</div>
	<div class="box-body">
		<table class="table table-striped table-hover" id="table-office">
			<thead>
			<tr>
				<th>Office Name</th>
				<th>Phone</th>
				<th>Email</th>
				<th>Status</th>
			</tr>
			</thead>
			<tbody id="list-data-office">
			
			</tbody>
		</table>
	</div>
	
	<!-- pop up -->
<div class="modal fade" id = "modal-input">
	<div class="modal-dialog">
		<div class = "modal-content">
			<div class="modal-header" style="background-color:#605ca8;">
				<h4 class="modal-title" style="color:white;"></h4>
			</div>
			
			<div class="modal-body">
			
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id = "modal-room">
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
            Are you sure you want to delete?
            <div class="modal-body">
			
			</div>
       	</div>
	</div>
</div>
<div class="modal fade" id="modal-alert-delete-room">
	<div class="modal-dialog">
		<div class="alert alert-warning alert-dismissible">
        	<h4 class="modal-title"><i class="icon fa fa-question-circle"></i>Warning!</h4>
            Data Successfully Deleted ...
            <div class="modal-body">
			
			</div>
       	</div>
	</div>
</div>
</div>
</div>
<script>
var roomArray = new Array;
	listDataOffice();
	
	function listDataOffice() {
		$.ajax({
			url:"office/list.html",
			type:"get",
			dataType:"html",
			success:function(result){
				$("#list-data-office").html(result);
			}
		});
	}

	
	$(document).ready(function(){
		$("#button-tambah").on("click", function(){
			$.ajax({
				url:"office/tambah.html",
				type:"get",
				dataType:"html",
				success:function(result){
					$("#modal-input").find(".modal-title").html("Form Tambah Office");
					$("#modal-input").find(".modal-body").html(result);
					$("#modal-input").modal("show");
				}
			});
		});
		
		$("#modal-input").on("submit", "#form-office-tambah", function(){
			//alert(JSON.stringify(office));
			$.ajax({
				url:"office/create.json",
				type:"get",
				dataType:"json",
				data: {
					name: $("#office-name").val(),
					phone: $("#phone").val(),
					email: $("#email").val(),
					address: $("#address").val(),
					notes: $("#office-notes").val(),
					rooms: JSON.stringify(roomArray)
				},
				success:function(result){
					$("#modal-alert1").find(".modal-title");  
					$("#modal-alert1").modal("show");
					listDataOffice();
				}
			});
			return false;
		});
		$("#modal-input").on("click","#button-tambah2", function(){
			$.ajax({
				url:"office/room.html",
				type:"get",
				dataType:"html",
				success:function(result){
					$("#modal-room").find(".modal-title").html("Form Room");
					$("#modal-room").find(".modal-body").html(result);
					$("#modal-room").modal("show");
				}
			});
		});
		$("#list-data-office").on("click", ".btn-edit", function() {
			
			var Id = $(this).prop('id');
			$.ajax({
				url : "office/edit.html",
				type : "get",
				dataType : "html",
				data : {
					id : Id
				},
				success : function(result) {
					
					$("#modal-input").find(".modal-title").html("Form Edit Office");
					$("#modal-input").find(".modal-body").html(result);
					$("#modal-input").modal("show");
					listDataRoomDB();
				}
			});
		});

		$("#modal-input").on("submit","#form-office-edit",function() {
			$.ajax({
				url:"office/edit/save.json",
				type:"get",
				dataType:"json",
				data: {
					id: $("#id").val(),
					name: $("#office-name").val(),
					phone: $("#phone").val(),
					email: $("#email").val(),
					address: $("#address").val(),
					notes: $("#office-notes").val(),
					rooms: JSON.stringify(roomArray)
				},
				success:function(result){
					$("#modal-alert1").find(".modal-title");  
					$("#modal-alert1").modal("show");
					listDataOffice();
				}
			});
			return false;
				});
	
		$("#button-search").on("click", function(){
			var nameCari = document.getElementById("nameCari").value;
			$.ajax({
				url:"office/search/name.html",
				type:"get",
				dataType:"html",
				data:{nameCari:nameCari},
				success: function(result){
					$("#list-data-office").html(result);
				}
			});
			return false;
		});
		
		$("#list-data-office").on("click", ".btn-deactivate", function() {
			var Id = $(this).prop('id');
			$.ajax({
				url: "office/delete",
				type: "get",
				dataType: "html",
				data: {
					id: Id
				},
				success: function (result) {
					$("#modal-alert-delete").find(".modal-body").html(result);
					$("#modal-alert-delete").modal("show");
				}
			});
		});
		
		$("#modal-alert-delete").on("submit", "#form-confirm-delete", function() {
			$.ajax({
				url: "office/delete/save.json",
				type: "get",
				dataType: "json",
				data: $(this).serialize(),
				success: function (result) {
					$("#modal-alert-delete").modal("hide");
					listDataOffice();
				}
			});
			return false;
		});
		
		$("#modal-input").on("click", ".btn-delete", function(){
			var roomId = JSON.parse($(this).prop('id'));
			roomArray.pop(roomId);
			populateRoomListTable();
			$("#modal-alert-delete-room").modal("show");
		});
		

		$("#modal-room").on("submit","#form-room-tambah", function(){
			var room = {
				code: $("#code").val(),
				name: $("#name").val(),
				capacity: $("#capacity").val(),
				projector: $("#projector").val(),
				notes: $("#notes").val()
			};
			roomArray.push(room);
			populateRoomListTable();
			$("#modal-alert1").modal("show");
			$("#modal-room").modal("hide");
			return false;
		});
	
	
	function populateRoomListTable() {
		var roomListTable = '<tr></tr>';
		
		for(i=0; i<roomArray.length; i++) {
			roomListTable += '<tr><td>' + roomArray[i]['code'] + '</td>';
			roomListTable += '<td>' + roomArray[i]['name'] + '</td>';
			roomListTable += '<td>' + roomArray[i]['capacity'] + '</td>';
			roomListTable += '<td><div class="btn-group"> <button type="button" class="btn btn-normal dropdown-toggle" data-toggle="dropdown"> <span class="fa fa-bars"></span> <span class="sr-only">Toggle Dropdown</span> </button> <ul class="dropdown-menu" role="menu"> <li><a ';
			roomListTable += 'id=' + JSON.stringify(roomArray[i]);
			roomListTable += ' class="btn-delete">Delete</a></li> </ul></div></td>';
			roomListTable += '</tr>';
		}
		
		$("#modal-input").find("#list-data-room").html(roomListTable);
	}
	});
</script>