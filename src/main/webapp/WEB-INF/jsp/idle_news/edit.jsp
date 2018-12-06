<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<form action="#" method="get" id="form-idle-news-edit"
	class="form-horizontal">
	<input type="hidden" id="id" name="id" value="${idlenewsModel.id}" />
		<div class="form-group">
			<label class="control-label col-md-3" for="title">Title</label>
			<div class="col-md-8">
				<Input type="text" id="title" name="title" class="form-control" value="${idlenewsModel.title}" >
			</div>
		</div>
		<div class="form-group">
		<label class="control-label col-md-3" for="category">Category</label>
		<div class="col-md-8">
			<select id="idCategory" name="idCategory" class="form-control">
				<c:forEach items="${categoryModelList}" var="categoryModel">
					<option value="${categoryModel.id}">${categoryModel.name}</option>
				</c:forEach>
			</select>
		</div>
	</div>
		<div class="form-group">
			<label class="control-label col-md-3" for="content">Content</label>
			<div class="col-md-8">
				<TextArea id="content" name="content" class="form-control">${idlenewsModel.content}</TextArea>
			</div>
		</div>
		<div class="modal-footer">
			<button type="submit" class="btn btn-primary btn-sm">Simpan</button>
		</div>
</form>