<form action="#" method="get" id="form-add-testimony" class="form-horizontal" onsubmit="return validation();">
	<div class="form-group">
		<div class="col-md-8">
			<input type="text" id="titleTestimony" name="testimonyTitle" class="form-control" placeholder="Title">
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-8">
			<textarea rows="5" cols="10" name="testimonyContent" id="contentTestimony" class="form-control" placeholder="Content"></textarea>
		</div>
	</div>
	<input type="hidden" id="statusTrainer" name="trainerStatus" value="1">
	
	<div class="modal-footer">
		<input type="submit" class="btn btn-primary btn-sm" value="save">
		<input type="button" class="btn btn-primary btn-sm" data-dismiss="modal" value="cancel">
	</div>
</form>

<script type="text/javascript">

	function validation(){
		var title = document.getElementById("titleTestimony");
		if (title.value == ""){
			alert("Please fill Title !");
			return false;
		}
			return true;
	}
	
</script>