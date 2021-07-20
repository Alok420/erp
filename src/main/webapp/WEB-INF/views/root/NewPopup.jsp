<div id="newbox">

   <button style="float: left; background-color:#36eaa2; width: 100px;" type="button" class="btn btn-sm" data-toggle="modal" data-target="#newbox${fn:replace(form.level.chart.name,' ', '_')}${form.level.id}_${i.index}">
      &plus; New
   </button>
   <div class="modal" id="newbox${fn:replace(form.level.chart.name,' ', '_')}${form.level.id}_${i.index}">
      <div class="modal-dialog" style="margin-left:0px!important; margin-left: 1%!important;">
	<div class="modal-content" style="width: 1500px!important; background-color: #009999; ">
	   <div class="modal-header" style="padding: 0px;">
	      <button type="button"  class="btn btn-sm btn-warning close" data-dismiss="modal">&times;</button>
	   </div>
	   <div class="modal-body">

	      <div class="container-fluid" >

		<div class="row">
		   <div class="col-sm-11">
		      <div class="row" style="background-color: #CCFFCC; margin-bottom: 10px;padding: 10px;padding-bottom: 2px">

			<div id="formBox"  style="width: 100%; ">
			   <!-------------------------------------------------------------------form start------------------------------------->
			   <script>
			      $(document).ready(function () {
				$('#addform${level.id}').hide();
			      });
			   </script>
			   <form method="POST" action="" id="rootfd${form.id}${level.id}" enctype="multipart/form-data">
			      <div class="row form-group" style="margin: 0px 10px;">
				<label>Parent Group <span id="levelFormDataId" style="font-weight: bold;"></span>: &nbsp; </label>
				<input style="height: 20px;" onkeyup="popupBoxLevelDropDownChange('popupBoxLevelDropDown${fn:replace(form.level.chart.name,' ', '_')}${form.level.id}_${i.index}', '${form2 eq  null?0:form2.id}', 'rootfd${form.id}${level.id}')" id="popupBoxLevelDropDown${fn:replace(form.level.chart.name,' ', '_')}${form.level.id}_${i.index}" type="text">
			      </div>
			      <div class="row form-group">

				<c:forEach items="${LevelFormFieldService.getRepository().findByLevelForm(form)}" var="field" varStatus="">
				   <c:choose>
				      <c:when test="${field.type=='textarea'}">
					<div class="col-lg-2 mb-2">
					   <strong class="pl-2" style="font-size: 12px;">${field.name}</strong>
					   <textarea class="bg-focus form-control" required name="${field.name}" placeholder="${field.placeholder}" autocomplete="off" style="height: 35px;"></textarea>
					</div>
				      </c:when>
				      <c:otherwise>
					<div class="col-lg-2 mb-2">
					   <strong class="pl-2" style="font-size: 12px;">${field.name}</strong>
					   <input class="bg-focus form-control" required name="${field.name}" type="${field.type}" value="" placeholder="${field.placeholder}" autocomplete="off">
					</div>
				      </c:otherwise>
				   </c:choose>

				</c:forEach>
			      </div>

			      <input type="hidden" name="levelFormId" value="${form.id}">
			      <input type="hidden" name="rootFormData" id="levelFormDataId">
			      <div class="row form-group">
				<div class="col-lg-3">
				   <input type="button" onclick="saveRootData('rootfd${form.id}${level.id}')"  value="Save" class="btn btn-block btn-outline-success">
				</div>
				<div class="col-lg-1">
				   <div style="color: black;" id="saveRootFormData">

				   </div>
				</div>
				<div class="col-lg-8">
				   <button type="button" style="float: right;" class="btn btn-outline-dark btn-sm" data-toggle="modal" data-target="#${fn:replace(form.level.chart.name,' ', '_')}${form.level.id}_${i.index}">
				      &plus; Add field
				   </button>
				</div>
			      </div>
			   </form>

			   <div class="modal" id="${fn:replace(form.level.chart.name,' ', '_')}${form.level.id}_${i.index}">
			      <div class="modal-dialog">
				<div class="modal-content">
				   <div class="modal-header">
				      <h4 class="modal-title">Add fields</h4>
				      <button type="button" class="close" data-dismiss="modal">&times;</button>
				   </div>
				   <div class="modal-body">
				      <form action="../root/level-form-field/create"  method="POST" enctype="multipart/form-data">
					<input type="hidden" value="${form.id}" name="levelForm">
					<div class="form-group">
					   <span class="text-success" for="chart_id">Select input type</span>
					   <select name="type" id="chart_id" class="form-control">
					      <option selected value="text">Text</option>
					      <option selected value="date">Date</option>
					      <option selected value="url">Url</option>
					      <option selected value="email">email</option>
					      <option selected value="textarea">TextArea</option>
					      <option selected value="file">File</option>
					      <option selected value="number">Number</option>
					   </select>
					</div>
					<div class="form-group">
					   <span class="text-success" for="chart_id">Set field name</span>
					   <input  required type="text" id="field_name" class="form-control" name="name">
					</div>
					<div class="form-group">
					   <span class="text-success" for="chart_id">Set placeholder</span>
					   <input required id="placeholder" type="text" class="form-control" name="placeholder">
					</div>
					<button type="submit" class="btn btn-success btn-sm">Submit</button>
				      </form>
				   </div>
				   <div class="modal-footer">
				      <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				   </div>

				</div>
			      </div>
			   </div>
			</div>
		      </div>

		      <div class="row" style="height: 300px; overflow: scroll;">
			<div id="body" data-spy="scroll" data-target="#myScrollspy" data-offset="20" style="width: 100%;">
			   <div class="container-fluid">
			      <div class="row">
				<nav class="col-sm-1" id="myScrollspy" style="background-color: #1560BD;">
				   <ul class="nav nav-pills flex-column">
				      <c:forEach items="${SubMainService.findAllByRootLevelForm(form)}" var="submain">
					<c:choose>
					   <c:when test = "${param.subid ==submain.id}">
					      <li class="nav-item"><a class="nav-link active text-white" href="#section${submain.id}"> ${submain.name} </a> </li>
					   </c:when>
					   <c:otherwise>
					      <li  class="nav-item"><a class="nav-link text-white" href="#section${submain.id}"> ${submain.name}</a> </li>
					   </c:otherwise>
					</c:choose>
				      </c:forEach>
				      <li class="nav-item">
					<button type="button" class="btn btn-outline-light btn-sm" data-toggle="modal" data-target="#addsubmainmodal${form.id}">
					   &plus; Add more
					</button>
					<br>
					<%
					   if (request.getParameter("MainException") != null) {
					%>
					<span class="text-danger bg-white p-1">
					   <%= "Error: " + request.getParameter("MainException")%>
					</span>
					<%
					   }
					%>

					<%
					   if (request.getParameter("MainMessage") != null) {
					%>
					<span class="text-danger bg-white p-1">
					   <%= request.getParameter("MainMessage")%>
					</span>
					<%
					   }
					%>

					<!-- The Modal -->
					<div class="modal" id="addsubmainmodal${form.id}">
					   <div class="modal-dialog">
					      <div class="modal-content">

						<!-- Modal Header -->
						<div class="modal-header">
						   <h4 class="modal-title" style="color: blue;">Add Root Chart</h4>
						   <button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>

						<!-- Modal body -->
						<div class="modal-body">
						   <form action="./../subroot/main/create"  method="POST" enctype="multipart/form-data">
						      <table align="center" width="100%">
							<tr>
							   <td>
							      <div class="text-primary">Name <span class="root_form_errormessage text-danger"></span></div>

							      <div><input type="text" onblur="validaterRootChartForm()" class="form-control" id="add_root_id" name="name">
							      </div>
							   </td>
							   <td>
							      <input type="hidden" name="rootLevelForm" value="${form.id}">
							      <label>&nbsp;&nbsp;&nbsp;</label>
							      <div> <button type="submit" class="btn btn-primary btn-block">Submit</button></div>
							   </td>
							</tr>

						      </table>
						   </form>

						</div>

						<!-- Modal footer -->
						<div class="modal-footer">
						   <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
						</div>

					      </div>
					   </div>
					</div>
				      </li>
				   </ul>
				</nav>
				<div class="col-sm-11" style="background-color: #CCFFCC;">


				   <c:forEach items="${SubMainService.findAllByRootLevelForm(form)}" var="submain" >
				      <div id="section${submain.id}" style="" >
					<div class="container-fluid">
					   <c:set var="sublastlevel" value="${null}" scope="page"></c:set>
					   <ul class="nav nav-tabs">
					      <c:forEach items="${SubLevelService.FindLevelByMain(SubMainService.findById(submain.id))}" var="sublevel" varStatus="subi">
						<c:set var="activelevel" value=""></c:set>

						<c:set var="sublastlevel" value="${sublevel}" scope="page"></c:set>
						<li class="nav-item">

						   <a class="nav-link" data-toggle="tab" href="#sublevel${subi.index}${sublevel.name}">${sublevel.name}</a>
						</li>
					      </c:forEach>
					      <li>

						<button type="button" class="btn btn-outline-dark" data-toggle="modal" data-target="#subaddlevel${submain.id}${form.id}${sublastlevel.id}">
						   &plus; Add level
						</button>
						<!-- The Modal -->
						<div id="subaddlevel${submain.id}${form.id}${sublastlevel.id}" class="modal fade" role="dialog">
						   <div class="modal-dialog">
						      <!-- Modal content-->
						      <div class="modal-content">
							<div class="modal-header">
							   <h4 class="modal-title">Create new level</h4>
							   <button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>
							<div class="modal-body">
							   <form action="../subroot/level/create" onsubmit="return validateLevelForm()" method="POST" enctype="multipart/form-data">

							      <div class="form-group">
								<div class="level_form_errormessage text-danger"></div>
								<span>Name</span>
								<div><input onblur="validateLevelForm()" type="text" id="add_level_id" name="name" class="form-control"></div>
							      </div>
							      <div class="form-group">
								<input name="chart" type="hidden" value="${submain.id}">
							      </div>
							      <div class="form-group">
								<input type="hidden" name="level_id" value="${sublastlevel eq  null?0:sublastlevel.id}">
							      </div>
							      <button type="submit" class="btn btn-success">Submit</button>
							   </form>
							</div>
							<div class="modal-footer">
							   <!--<button type="button" class="btn btn-default" data-dismiss="modal">CloSSSse</button>-->
							</div>
						      </div>

						   </div>
						</div>
					      </li>
					   </ul>

					   <!-- Tab panes -->
					   <div class="tab-content" >

					      <c:forEach items="${SubLevelService.FindLevelByMain(SubMainService.findById(submain.id))}" var="sublevel" varStatus="subi">
						<div style="min-height: 300px;"  id="sublevel${subi.index}${sublevel.name}" class="container tab-pane active"><br>
						   <div>
						      <h3 style="border-top:thin solid #003366; border-radius: 10px; text-align: center; color: #003366;">${submain.name}</h3>

						      <!-------------------------------------------------------------------add sub form------------------------------------->
						      <c:if test="${SubFormService.findByLevel(sublevel).size()<1}">
							<button id="addformbtn" type="button" class="btn btn-success btn-sm" style="float: right;" data-toggle="modal" data-target="#subaddform${form.id}${sublevel.id}">&plus;Add form</button>
							<div id="subaddform${form.id}${sublevel.id}" class="modal fade" role="dialog">
							   <div class="modal-dialog">
							      <!-- Modal content-->
							      <div class="modal-content">
								<div class="modal-header">
								   <button type="button" class="close" data-dismiss="modal">&times;</button>
								   <h4 class="modal-title">Add new form</h4>
								</div>
								<div class="modal-body">
								   <form onsubmit="validateLevelForm()" action="../subroot/level-form/create" method="POST" enctype="multipart/form-data">
								      <div class="level_form_errormessage"></div>

								      <input id="level_id" type="hidden" value="${sublevel.id}" name="level">
								      <div class="form-group">
									<input onblur="" type="text" class="form-control"  placeholder="Add form name">
									<input type="hidden" class="form-control" name="action" value="xyz">
									<input type="hidden" class="form-control" name="method" value="post">
								      </div>
								      <button type="submit" class="btn btn-success">Submit</button>
								   </form>
								</div>
								<div class="modal-footer">
								   <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								</div>
							      </div>

							   </div>
							</div>
						      </c:if>

						      <!-- Modal -->


						      <!-------------------------------------------------------------------end add sub form------------------------------------->
						      <div class="container-fluid">
							<div class="row" style="">
							   <!-------------------------------------------------------------------sub form start------------------------------------->
							   <div id="formBox"  style="padding: 0px; width: 100%;">
							      <c:forEach items="${SubFormService.findByLevel(sublevel)}" var="subform" varStatus="subformindex">

								<script>
								   $(document).ready(function () {
								      $('#subaddform${sublevel.id}').hide();
								   });
								</script>
								<form method="POST" action="" id="formdata${form.id}${sublevel.id}" style="border:thin solid #003366; margin-bottom: 10px;padding: 5px;border-radius: 5px;">
								   <div class="row form-group">
								      <div class="col-lg-12">
									<input type="hidden" class="rootFormDataOptionList" name="rootFormData" id="rootFormDataOptionList">
									<%--    <select class="form-control rootFormDataOptionList" required name="rootFormData" id="rootFormDataOptionList">
									   <option selected disabled>
									      Select any record
									   </option>
									     <c:forEach items="${FormDataService.getRepository().findByLevelForm(form)}" var="row" varStatus="rindex">
									      <option value="${row.id}">
										${row.id}:-
										<c:forEach items="${LevelFormFieldService.getRepository().findByLevelForm(form)}" var="allField">
										   ${FormDataNewObject.stringTOJson(row.jsonvalue).get(allField.name)} -
										</c:forEach>
									      </option>
									   </c:forEach>
									</select>
									--%>
								      </div>
								   </div>
								   <div class="row form-group">
								      <c:forEach items="${SubLevelFormFieldService.getRepository().findByLevelForm(subform)}" var="subfield" varStatus="">
									<c:choose>
									   <c:when test="${subfield.type=='textarea'}">
									      <div class="col-lg-2 mb-2">
										<strong class="pl-2" style="font-size: 12px;">${subfield.name}</strong>
										<textarea class="bg-focus form-control" required name="${subfield.name}" placeholder="${subfield.placeholder}" autocomplete="off" style="height: 35px;"></textarea>
									      </div>
									   </c:when>
									   <c:otherwise>
									      <div class="col-lg-2 mb-2">
										<strong class="pl-2" style="font-size: 12px;">${subfield.name}</strong>
										<input class="bg-focus form-control" required name="${subfield.name}" type="${subfield.type}" value="" placeholder="${subfield.placeholder}" autocomplete="off">
									      </div>
									   </c:otherwise>
									</c:choose>
								      </c:forEach>
								   </div>
								   <input type="hidden" name="levelFormId" value="${subform.id}">
								   <div class="row form-group">
								      <div class="col-lg-3">
									<input type="button" onclick="saveSubRootData('formdata' +${form.id}${sublevel.id})" value="Save" class="btn btn-block btn-outline-success">
								      </div>
								      <div class="col-lg-3" >
									<div id="saveSubRootFormData" style="color: black;"></div>
								      </div>
								      <div class="col-lg-6" >
									<button type="button" style="float: right;" class="btn btn-outline-dark" data-toggle="modal" data-target="#sub${fn:replace(subform.level.chart.name,' ', '_')}${subform.level.id}_${i.index}">
									   &plus; Add field
									</button>
								      </div>
								   </div>

								</form>
								<div class="modal" id="sub${fn:replace(subform.level.chart.name,' ', '_')}${subform.level.id}_${i.index}">
								   <div class="modal-dialog">
								      <div class="modal-content">
									<div class="modal-header">
									   <h4 class="modal-title">Add fields</h4>
									   <button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>
									<div class="modal-body">
									   <form action="../subroot/level-form-field/create"  method="POST" enctype="multipart/form-data">
									      <input type="hidden" value="${subform.id}" name="levelForm">
									      <div class="form-group">
										<span class="text-success" for="chart_id">Select input type</span>
										<select name="type" id="chart_id" class="form-control">
										   <option selected value="text">Text</option>
										   <option selected value="date">Date</option>
										   <option selected value="url">Url</option>
										   <option selected value="email">Email</option>
										   <option selected value="textarea">TextArea</option>
										   <option selected value="file">File</option>
										   <option selected value="number">Number</option>
										</select>
									      </div>
									      <div class="form-group">
										<span class="text-success" for="chart_id">Set field name</span>
										<input  required type="text" id="field_name" class="form-control" name="name">
									      </div>
									      <div class="form-group">
										<span class="text-success" for="chart_id">Set placeholder</span>
										<input required id="placeholder" type="text" class="form-control" name="placeholder">
									      </div>
									      <button type="submit" class="btn btn-success">Submit</button>
									   </form>
									</div>
									<div class="modal-footer">
									   <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
									</div>

								      </div>
								   </div>
								</div>

							      </c:forEach>
							   </div>
							   <!-------------------------------------------------------------------sub form end------------------------------------->
							</div>
						      </div>
						   </div>
						</div>
					      </c:forEach>

					   </div>
					</div>

				      </div>
				   </c:forEach>



				</div>
			      </div>
			   </div>

			</div>

		      </div>
		   </div>
		   <div class="col-sm-1 popuprightsidebar">
		      <ul>

		      </ul>
		   </div>
		</div>

	      </div>
	   </div>
	   <div class="modal-footer" style="padding: 0px;">
	      <button type="button" class="btn btn-danger"style="padding: 1px;" data-dismiss="modal">Close</button>
	   </div>

	</div>
      </div>
   </div>
</div>

