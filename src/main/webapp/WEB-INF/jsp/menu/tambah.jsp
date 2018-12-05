<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<form action = "#" method = "get" id="form-menu-tambah" class="form-horizontal">
	<div class="form-group">
		<label class="control-label col-md-3" for="kode">Code</label>
		<div class="col-md-8">
			<input type="text" id="kode" name="kode" value="${codeAuto}" class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="title">Title</label>
		<div class="col-md-8">
			<input type="text" id="title" name="title" class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="description">Description</label>
		<div class="col-md-8">
			<textarea id="description" name="description" class="form-control"></textarea> 
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="imgurl">Image URL</label>
		<div class="col-md-8">
			<input type="text" id="imgurl" name="imgurl" class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="menuorder">Menu Order</label>
		<div class="col-md-8">
			<input type="text" id="menuorder" name="menuorder" class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="parent">Menu Parent</label>
		<div class="col-md-8">
			<select class="form-control" id="parent" name="parent">
				<c:forEach items="${menuModelList}" var="menuModel">
					<option value="${menuModel.id}">${menuModel.title}</option>		
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3" for="menuurl">Menu URL</label>
		<div class="col-md-8">
			<input type="text" id="menuurl" name="menuurl" class="form-control">
		</div>
	</div>

	<div class="modal-footer">
		<button type="submit" class="btn btn-primary btn-sm">Save</button>
	</div>
</form>