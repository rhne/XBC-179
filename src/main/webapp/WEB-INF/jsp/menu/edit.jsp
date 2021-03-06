<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<form action = "#" method = "get" id="form-menu-edit" class="form-horizontal">
	<input type="hidden" id="id" name="id" value="${menuModel.id}">
	<div class="form-group">
		<label class="control-label col-md-3" for="kode">Code</label>
		<div class="col-md-8">
			<input type="hidden" id="kode" name="kode" value="${menuModel.kode}">
			<input type="text" id="kodedis" name="kodedis" value="${menuModel.kode}" class="form-control" disabled="disabled">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="title">Title</label>
		<div class="col-md-8">
			<input type="text" id="title" name="title" class="form-control" value="${menuModel.title}">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="description">Description</label>
		<div class="col-md-8">
			<textarea id="description" name="description" class="form-control">${menuModel.description}</textarea> 
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="imgurl">Image URL</label>
		<div class="col-md-8">
			<input type="text" id="imgurl" name="imgurl" class="form-control" value="${menuModel.imgurl}">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="menuorder">Menu Order</label>
		<div class="col-md-8">
			<input type="text" id="menuorder" name="menuorder" class="form-control" value="${menuModel.menuorder}">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="menuparent">Menu Parent</label>
		<div class="col-md-8">
			<select class="form-control" id="menuparent" name="menuparent">
				<option value="0"> 0 </option>
				<c:forEach items="${menuModelList}" var="menuModel">
					<option value="${menuModel.id}">${menuModel.title}</option>		
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="menuurl">Menu URL</label>
		<div class="col-md-8">
			<input type="text" id="menuurl" name="menuurl" class="form-control" value="${menuModel.menuurl}">
		</div>
	</div>

	<div class="modal-footer">
		<button type="submit" class="btn btn-primary btn-sm">Save</button>
		<button type="button" class="btn btn-warning btn-sm" data-dismiss="modal">Cancel</button>
	</div>
</form>