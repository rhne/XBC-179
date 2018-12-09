<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<form id="form-tambah-version" class="form-horizontal">
<div class="form-group" style="padding: 20px;">
	<%-- <input type="hidden" value="${versionModel}" id="versionModel"> --%>
	<label>Version Tambah.2</label>
	<input id="version" name="version" class="form-control" disabled="disabled" value="${latestVersion}">
	<br/>
	<button type="button" id="btn-tambah-question" class="btn btn-primary btn-sm">+ Question</button>
	<br/>
	<label style="padding-top: 24px;">Question</label>
	<div>
		<table class="table" id="table-user">
			<thead>
			<tr>
				<th>No.</th>
				<th>Question</th>
			</tr>
			</thead>
			<tbody id="list-data-question">
			
			</tbody>
		</table>
	</div>
	<div class="modal-footer" style="border-top: 0 none;">
		<button type="submit" class="btn btn-primary btn-sm">Save</button>
		<button type="button" class="btn btn-normal btn-sm" data-dismiss="modal">Cancel</button>
	</div>
</div>
</form>

<script type="text/javascript">
	var questionArray = new Array();
	/* listDataQuestion();
	
	function listDataQuestion() {
		$.ajax({
			url:"question/list.html",
			type:"get",
			dataType:"html",
			success:function(result){
				$("#list-data-question").html(result);
				//alert(result);
			}
		});
	} */
	
	
</script>