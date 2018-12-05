<h4>Delete this Testimony ?</h4>
<form action="#" method="get" id="form-delete-testimony" class="form-horizontal">
	<input type="hidden" id="id" name="idTestimony" value="${testimonyModel.idTestimony}" />
	<div class="form-group">
		<div class="col-md-8">
			<input type="text" id="titleTestimony" name="testimonyTitle" class="form-control" placeholder="Title" value="${testimonyModel.title}" disabled="disabled"/>
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-8">
			<textarea rows="5" cols="10" name="testimonyContent" id="contentTestimony" class="form-control" disabled="disabled">${testimonyModel.content}</textarea>
		</div>
	</div>
	
	<div class="modal-footer">
		<input type="submit" class="btn btn-primary btn-sm" value="Yes">
		<input type="button" class="btn btn-primary btn-sm" data-dismiss="modal" value="Cancel">
	</div>
</form>