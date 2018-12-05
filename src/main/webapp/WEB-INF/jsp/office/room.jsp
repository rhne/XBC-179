<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<form action="#" method="get" id="form-office-room"
	class="form-horizontal">
		<div class="form-group">
			<label class="control-label col-md-3" for="code">Code</label>
			<div class="col-md-8">
				<input type="text" id="code" name="code" class="form-control" value="${autoCode}">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-3" for="name">Name</label>
			<div class="col-md-8">
				<input type="text" id="name" name="name" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-3" for="capacity">Capacity</label>
			<div class="col-md-8">
				<input type="text" id="capacity" name="capacity" class="form-control">
			</div>
		</div>
			<div class="form-group">
	<label class="control-label col-md-3" for="token">Any Projector</label>
		<div class="col-md-8">
			<input type="radio" id="true" name="projector" value="1"/>True 
			<input type="radio" id="false" name="projector" value="0"/>False
		</div>
	</div>
		<div class="form-group">
			<label class="control-label col-md-3" for="notes">Notes</label>
			<div class="col-md-8">
				<TextArea id="notes" name="notes" class="form-control"></TextArea>
			</div>
		</div>
		<div class="form-group">
		<label class="control-label col-md-3" for="office">Office</label>
		<div class="col-md-8">
			<select id="idOffice" name="idOffice" class="form-control">
				<c:forEach items="${officeModelList}" var="officeModel">
					<option value="${officeModel.id}">${officeModel.name}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<button type="submit" id="button-tambah-room" class="btn btn-primary btn-sm" data-toggle="tooltip" data-placement="top" title="Create Room"><i class="fa fa-user-plus"></i>Tambah</button>
			
</form>
<script>
$(document).ready(function(){
	$("#form-office-room").on("submit", function(){
		$.ajax({
			url:"office/create_room.json",
			type:"get",
			dataType:"json",
			data:$(this).serialize(),
			success:function(result){
				$("#modal-alert1").find(".modal-title");  
				$("#modal-alert1").modal("show");
				$("#modal-input").modal("hide");
				listDataRoom();
			}
		});
		return false;
	});
	
});
</script>