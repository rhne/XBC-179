<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="box box-danger">
	<div class="box-header with-border">
		<h3 class="box-title">Menu Access</h3>
		<div class="box-tools">
			<div class="input-group input-group-sm" style="width: 200px;'">
				<select class="form-control" id="nameCari" name="table_search" class="form-control pull-right" >
					<c:forEach items="${roleModelList}" var="roleModel">
						<option value="${roleModel.id}">${roleModel.name}</option>		
					</c:forEach>
				</select>
				<div class="input-group-btn">
                    <button type="button" id="button-tambah" class="btn btn-primary btn-sm" data-toggle="tooltip" data-placement="top" title="Create Data"><i class="fa fa-user-plus"></i></button>
                </div>
               	
			</div>
		</div>
	</div>
	<div class="box-body">
		<table class="table table-striped table-hover" id="table-menu-akses">
			<thead>
			<tr>
				<th>Role</th>
				<th>Menu</th>
			</tr>
			</thead>
			<tbody id="list-data-menu-akses">
			
			</tbody>
		</table>
	</div>
	
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

<div class="modal fade" id = "modal-alert1">
	<div class="modal-dialog">
		<div class="alert alert-success alert-dismissible">
        	<h4 class="modal-title"><i class="icon fa fa-check"></i>Success!</h4>
            Data Successfully Added ...
       	</div>
	</div>
</div>

<div class="modal fade" id = "modal-alert2">
	<div class="modal-dialog">
		<div class="alert alert-success alert-dismissible">
        	<h4 class="modal-title"><i class="icon fa fa-check"></i>Success!</h4>
            Data Successfully Updated ...
       	</div>
	</div>
</div>

<div class="modal fade" id="modal-delete">
	<div class="modal-dialog">
		<div class="alert alert-warning alert-dismissible">
        	<h4 class="modal-title"><i class="icon fa fa-question-circle"></i>Confirmation</h4>
            
            <div class="modal-body">
			
			</div>
       	</div>
	</div>
</div>
</div>

<script>
	listDataMenuAkses();

	function listDataMenuAkses() {
		$.ajax({
			url:"menuaccess/list.html",
			type:"get",
			dataType:"html",
			success:function(result){
				$("#list-data-menu-akses").html(result);
			}
		});
	}
	$(document).ready(function(){
		$("#button-tambah").on("click", function(){
			$.ajax({
				url:"menuaccess/tambah.html",
				type:"get",
				dataType:"html",
				success:function(result){
					$("#modal-input").find(".modal-title").html("Form Menu Access");
					$("#modal-input").find(".modal-body").html(result);
					$("#modal-input").modal("show");
				}
			});
		});
		
		$("#modal-input").on("submit", "#form-menu-akses-tambah", function(){
			$.ajax({
				url:"menuaccess/create.json",
				type:"get",
				dataType:"json",
				data:$(this).serialize(),
				success:function(result){
					$("#modal-alert1").find(".modal-title");  
					$("#modal-alert1").modal("show");
					$("#modal-input").modal("hide");
					listDataMenuAkses();
				}
			});
			return false;
		});
		
		/* $("#nameCari").on("load", function(){
			var nameCari = document.getElementById("nameCari").value;
			$.ajax({
				url:"menuaccess/search/name.html",
				type:"get",
				dataType:"html",
				data:{nameCari:nameCari},
				success: function(result){
					$("#list-data-menu-akses").html(result);
				}
			});
			return false;
		}); */
		
		function showDetail(str) {
			  var xhttp; 
			  if (str == "") {
			    document.getElementById("nameCari").innerHTML = "";
			    return;
			  }
			  xhttp = new XMLHttpRequest();
			  xhttp.onreadystatechange = function() {
			    if (this.readyState == 4 && this.status == 200) {
			    document.getElementById("nameCari").innerHTML = this.responseText;
			    }
			  };
			  xhttp.open("GET", "menuaccess/search/name.html?q="+str, true);
			  xhttp.send();
			}
		
		$("#list-data-menu-akses").on("click", "#btn-delete", function(){
			var id = $(this).val();
			$.ajax({
				url:"menuaccess/delete.html",
				type:"get",
				dataType:"html",
				data: {id:id},
				success:function(result){
					$("#modal-delete").find(".modal-body").html(result);
					$("#modal-delete").modal("show");
				}
			});
		});
		
		$("#modal-delete").on("submit","#form-delete", function(){
			$.ajax({
				url:"menuaccess/delete/save.json",
				type:"get",
				dataType:"json",
				data:$(this).serialize(),
				success: function(result){
					$("#modal-delete").modal("hide");
					listDataMenuAkses();
				}
			});
			return false;
		});
	});
</script>