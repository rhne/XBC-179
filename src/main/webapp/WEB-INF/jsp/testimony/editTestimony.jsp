<form action="#" method="get" id="form-edit-testimony" class="form-horizontal">
	<input type="hidden" id="id" name="idTestimony" value="${testimonyModel.idTestimony}" />
	<div class="form-group">
		<label class="control-label col-md-3" for="titleTestimony">Title</label>
		<div class="col-md-8">
			<input type="text" id="titleTestimony" name="testimonyTitle" class="form-control" placeholder="Title" value="${testimonyModel.title}" required="required"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="contentTestimony">Content</label>
		<div class="col-md-8">
			<textarea rows="5" cols="10" name="testimonyContent" id="contentTestimony" class="form-control">${testimonyModel.content}</textarea>
		</div>
	</div>
	
	<div class="modal-footer">
		<input type="submit" class="btn btn-primary btn-sm" value="Save">
		<input type="button" class="btn btn-default btn-sm" data-dismiss="modal" value="Cancel">
	</div>
</form>