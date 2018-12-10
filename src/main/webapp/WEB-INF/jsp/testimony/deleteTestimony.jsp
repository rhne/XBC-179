<h4>Are you sure want to delete this ?</h4>
<form action="#" method="get" id="form-delete-testimony" class="form-horizontal">
	<input type="hidden" id="id" name="idTestimony" value="${testimonyModel.idTestimony}" />
	<input type="hidden" id="titleTestimony" name="testimonyTitle" value="${testimonyModel.title}" />
	<input type="hidden" id="contentTestimony" name="testimonyContent" value="${testimonyModel.content}" />
	
	<div class="form-group">
			<label class="control-label col-md-3" for="titleTestimony">Title</label>
			<div class="col-md-8">
				<input type="text" style="outline : 0px; background-color: orange; color: white" id="titleTestimony" name="testimonyTitle" class="form-control" placeholder="Title" value="${testimonyModel.title}" disabled="disabled"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-3" for="contentTestimony">Content</label>
			<div class="col-md-8">
				<textarea rows="5" cols="10" style="outline : 0px; background-color: orange; color: white" name="testimonyContent" id="contentTestimony" class="form-control" disabled="disabled">${testimonyModel.content}</textarea>
			</div>
	</div>

	
	<div class="modal-footer">
		<input type="submit" class="btn btn-danger btn-sm" value="Yes">
		<input type="button" class="btn btn-warning btn-sm" data-dismiss="modal" value="Cancel">
	</div>
</form>