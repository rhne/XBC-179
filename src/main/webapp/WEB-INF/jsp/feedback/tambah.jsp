<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<form id="form-tambah-feedback" class="form-horizontal" >
	<input type="hidden" id="versionId" name="versionId" value="${versionId}">
	<div class="form-group" style="margin-left: 0px;">
		<label>Test</label> <br/>
		<select id="testId" name="testId">
			<c:forEach items="${testModelList}" var="testModel" varStatus="number">
				<option value="${testModel.id}">${testModel.name}</option>
			</c:forEach>
		</select>
	</div>
	
	<c:forEach items="${questionModelList}" var="questionModel" varStatus="number">
		<label>${number.count}. ${questionModel.question}</label>
		<textarea rows="3" class="form-control question" id="${questionModel.id}" name="${questionModel.id}"
		style="resize:vertical"></textarea>
	</c:forEach>
	
	<div class="modal-footer" style="border-top: 0 none;">
		<button type="submit" class="btn btn-primary btn-sm">Save</button>
		<button type="button" class="btn btn-normal btn-sm" data-dismiss="modal">Cancel</button>
	</div>
</form>

<div class="modal fade" id = "modal-alert1">
	<div class="modal-dialog">
		<div class="alert alert-success alert-dismissible">
        	<h4 class="modal-title"><i class="icon fa fa-check"></i>Success!</h4>
            Data Successfully Added ...
       	</div>
	</div>
</div>

<script type="text/javascript">
	
	$("#form-tambah-feedback").on("submit", function () {
		//alert(JSON.stringify($("#form-tambah-feedback").form));
		if($("#testId").val() == null) {
			alert("Test tidak boleh kosong!");
			return false;
		}
		var questionArray = new Array;
		$(".question").each(function (i) {
			var object = {
				questionId: $(this).prop('id'),
				answer: $(this).val()
			};
			questionArray.push(object);
		});
		
		var dataObject = {
			test: {
				id: $("#testId").val(),
			},
			feedback: questionArray
		}
		//alert(JSON.stringify(dataObject));
		
		$.ajax({
			url: "feedback/create.json",
			type: "get",
			dataType: "json",
			data: {
				versionId: $("#versionId").val(),
				testId: $("#testId").val(),
				data: JSON.stringify(dataObject)
			},
			success: function () {
				$("#modal-alert1").find(".modal-title"); 
				$("#modal-alert1").modal("show");
				alert("Tersimpan");
			}
		});
		location.reload();
	});

</script>