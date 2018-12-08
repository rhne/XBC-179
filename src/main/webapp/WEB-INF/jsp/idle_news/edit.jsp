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
			<button type="submit" class="btn btn-primary btn-sm" onclick="return validasi_input();">Simpan</button>
			<button type="button" class="btn btn-danger btn-sm" data-dismiss="modal">Cancel</button>
		</div>
</form>
<script type="text/javascript">

function validasi_input(){
	var title = document.getElementById("title");
	var content = document.getElementById("content");
		if (title.value == ""){
		alert("Title Is Still Empty :v");
		return false;
		}else if (content.value == ""){
		alert("Content Is Still Empty :v");
		return false;
		}
	return true;
}
	
</script>