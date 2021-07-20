<div  class="modal updatepopupbox" id="updatebox${fn:replace(form.level.chart.name,' ', '_')}${form.level.id}_${i.index}${row.id}">
   <div  class="modal-dialog" style="margin-left:0px!important; margin-left: 1%!important;">
      <div class="modal-content" style="box-shadow: 0 10px 29px 0 rgba(68, 88, 144, 0.1);width: 1500px!important; background-color: #009999!important; ">
	<div class="modal-header" style="padding: 0px;">
	   <button type="button" class="btn btn-danger close"  data-dismiss="modal">&times;</button>
	</div>
	<div class="modal-body">
	   <div class="container-fluid">
	      <div class="row">
		<div class="col-sm-11">
		   <div class="row" style="background-color: #CCFFCC; margin-bottom: 10px;padding: 10px;padding-bottom: 2px;">
		      <div id="formBox"  style="width: 100%;">

			<!-------------------------------------------------------------------form start------------------------------------->

			<form method="POST" action="" id="rootfdupdate${fn:replace(form.level.chart.name,' ', '_')}${form.level.id}_${i.index}${row.id}" enctype="multipart/form-data">
			   <div class="row form-group">
			      <c:forEach items="${LevelFormFieldService.getRepository().findByLevelForm(form)}" var="field" varStatus="">

				<c:choose>
				   <c:when test="${field.type=='textarea'}">
				      <div class="col-lg-2 mb-2">
					<strong class="pl-2" style="color: black;" >${field.name}</strong>
					<textarea id="inputfield${level.id}${field.id}" class="bg-focus form-control" required name="${field.name}" placeholder="${field.placeholder}" autocomplete="off">${FormDataNewObject.stringTOJson(row.jsonvalue).get(field.name)}</textarea>
					<script>
					   document.getElementById("inputfield${level.id}${field.id}").value = "${not empty FormDataNewObject.stringTOJson(row.jsonvalue).get(field.name)?FormDataNewObject.stringTOJson(row.jsonvalue).get(field.name):''}";
					</script>
				      </div>

				   </c:when>
				   <c:otherwise>
				      <div class="col-lg-2 mb-2">
					<strong class="pl-2" style="color: black;">${field.name}</strong>
					<input id="inputfield${level.id}${field.id}" class="bg-focus form-control" required name="${field.name}" type="${field.type}" value="${FormDataNewObject.stringTOJson(row.jsonvalue).get(field.name)}" placeholder="${field.placeholder}" autocomplete="off">
					<c:if test="${field.type=='file'}">
					   <a download href="${FormDataNewObject.stringTOJson(row.jsonvalue).get(field.name)}"><img height="40"  src="${FormDataNewObject.stringTOJson(row.jsonvalue).get(field.name)}"></a>
					</c:if>
					<script>
					   document.getElementById("inputfield${level.id}${field.id}").value = "${not empty FormDataNewObject.stringTOJson(row.jsonvalue).get(field.name)?FormDataNewObject.stringTOJson(row.jsonvalue).get(field.name):''}";
					</script>
				      </div>
				   </c:otherwise>
				</c:choose>

			      </c:forEach>
			   </div>
			   <input type="hidden" name="levelFormId" value="${form.id}">
			   <input type="hidden" name="formDataId" value="${row.id}">

			   <div class="row form-group">
			      <div class="col-lg-3">
				<input type="button" onclick="updateRootData('rootfdupdate${fn:replace(form.level.chart.name,' ', '_')}${form.level.id}_${i.index}${row.id}', 'saveRootFormDataupdatebox${fn:replace(form.level.chart.name,' ', '_')}${form.level.id}_${i.index}${row.id}')"  value="Save" class="btn btn-block btn-outline-success">

			      </div>
			      <div class="col-lg-1">
				<div style="color: black;" id="saveRootFormDataupdatebox${fn:replace(form.level.chart.name,' ', '_')}${form.level.id}_${i.index}${row.id}"></div>
			      </div>
			      <div class="col-lg-8">
				<button type="button" style="float: right;" class="btn btn-outline-dark btn-sm" data-toggle="modal" data-target="#${fn:replace(form.level.chart.name,' ', '_')}${form.level.id}_${i.index}${row.id}">
				   &plus; Add field
				</button>
			      </div>
			   </div>
			</form>

			<div class="modal" id="${fn:replace(form.level.chart.name,' ', '_')}${form.level.id}_${i.index}${row.id}">
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
					   <li class="nav-item"><a class="nav-link active text-white" href="#section${submain.id}${form.id}${form.level.id}_${i.index}${row.id}"> ${submain.name} </a> </li>
					</c:when>
					<c:otherwise>
					   <li  class="nav-item"><a class="nav-link text-white" href="#section${submain.id}${form.id}${form.level.id}_${i.index}${row.id}"> ${submain.name}</a> </li>
					</c:otherwise>
				      </c:choose>
				   </c:forEach>
				   <li class="nav-item">
				      <button type="button" class="btn btn-outline-light btn-sm" data-toggle="modal" data-target="#addsubmainmodal2${form.level.id}${form.id}${row.id}">
					&plus; Add more
				      </button>
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
				      <div class="modal" id="addsubmainmodal2${form.level.id}${form.id}${row.id}">
					<div class="modal-dialog">
					   <div class="modal-content">

					      <!-- Modal Header -->
					      <div class="modal-header">
						<h4 class="modal-title" style="color: blue;">Add Root Chart</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					      </div>

					      <!-- Modal body -->
					      <div class="modal-body">
						<form action="../subroot/main/create" onsubmit="return validaterRootChartForm()"  method="POST" enctype="multipart/form-data">

						   <div class="text-primary">Name <span class="root_form_errormessage text-danger"></span></div>
						   <div>
						      <input type="text" onblur="validaterRootChartForm()" class="form-control" id="add_root_id" name="name">
						      <input type="hidden" name="rootLevelForm" value="${form.id}">
						   </div>
						   <div>
						      <button type="submit" class="btn btn-primary btn-block">Submit</button>
						   </div>
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
			      <div class="col-sm-11" >
				<c:forEach items="${SubMainService.findAllByRootLevelForm(form)}" var="submain" >
				   <div id="section${submain.id}${form.id}${form.level.id}_${i.index}${row.id}" style="background-color: #CCFFCC;" >
				      <div class="container-fluid">
					<c:set var="sublastlevel" value="${null}" scope="page"></c:set>
					<ul class="nav nav-tabs">
					   <c:forEach items="${SubLevelService.FindLevelByMain(SubMainService.findById(submain.id))}" var="sublevel" varStatus="subi">
					      <c:set var="activelevel" value=""></c:set>

					      <c:set var="sublastlevel" value="${sublevel}" scope="page"></c:set>
					      <li class="nav-item">

						<a class="nav-link" data-toggle="tab" href="#sublevel${subi.index}${sublevel.name}${row.id}">${sublevel.name}</a>
					      </li>
					   </c:forEach>
					   <li>

					      <button type="button" class="btn btn-outline-dark" data-toggle="modal" data-target="#subaddlevel${submain.id}${form.id}${sublastlevel.id}${row.id}">
						&plus; Add level
					      </button>
					      <!-- The Modal -->
					      <div id="subaddlevel${submain.id}${form.id}${sublastlevel.id}${row.id}" class="modal fade" role="dialog">
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
					<div class="tab-content" >
					   <c:forEach items="${SubLevelService.FindLevelByMain(SubMainService.findById(submain.id))}" var="sublevel" varStatus="subi">
					      <div style="min-height: 300px;"  id="sublevel${subi.index}${sublevel.name}${row.id}" class="container tab-pane active"><br>
						<div>
						   <h3 style="border-top:thin solid #003366; border-radius: 10px; text-align: center; color: #003366;">${submain.name}</h3>
						   <!-------------------------------------------------------------------add sub form------------------------------------->
						   <c:if test="${SubFormService.findByLevel(sublevel).size()<1}">
						      <button id="addformbtn" type="button" class="btn btn-success btn-sm" style="float: right;" data-toggle="modal" data-target="#subaddform${form.id}${sublevel.id}${row.id}">&plus;Add form</button>
						      <div id="subaddform${form.id}${sublevel.id}${row.id}" class="modal fade" role="dialog">
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
						   <div class="container-fluid">
						      <div class="row" style="background-color: white;">
							<!-------------------------------------------------------------------sub form start------------------------------------->
							<div id="formBox"  style="padding: 0px; width: 100%;">
							   <c:forEach items="${SubFormService.findByLevel(sublevel)}" var="subform" varStatus="subformindex">

							      <script>
								$(document).ready(function () {
								   $('#subaddform${form.id}${sublevel.id}${row.id}').hide();
								});
							      </script>
							      <form method="POST" action="" id="formdataupdate${form.id}${sublevel.id}${subform.id}${row.id}">
								<div class="row form-group">
								   <div class="col-lg-12">
								      <input type="hidden" class="rootFormDataOptionList2" name="rootFormData" value="${row.id}">
								   </div>
								</div>
								<div class="row form-group">
								   <c:forEach items="${SubLevelFormFieldService.getRepository().findByLevelForm(subform)}" var="subfield" varStatus="">
								      <c:choose>
									<c:when test="${subfield.type=='textarea'}">
									   <div class="col-lg-2 mb-2">
									      <strong class="pl-2" style="font-size: 12px; color: black;">${subfield.placeholder}</strong>
									      <textarea class="bg-focus form-control" required name="${subfield.name}" placeholder="${subfield.placeholder}" autocomplete="off" style="height: 35px;"></textarea>
									   </div>
									</c:when>
									<c:otherwise>
									   <div class="col-lg-2 mb-2">
									      <strong class="pl-2" style="font-size: 12px;color: black;">${subfield.placeholder}</strong>
									      <input class="bg-focus form-control" required name="${subfield.name}" type="${subfield.type}" value="" placeholder="${subfield.placeholder}" autocomplete="off">
									   </div>
									</c:otherwise>
								      </c:choose>
								   </c:forEach>
								</div>
								<input type="hidden" name="levelFormId" value="${subform.id}">
								<div class="row form-group">
								   <div class="col-lg-3">
								      <input type="button" onclick="saveSubRootData2('formdataupdate${form.id}${sublevel.id}${subform.id}${row.id}')" value="Save" class="btn btn-block btn-outline-success">
								   </div>
								   <div class="col-lg-3">
								      <div id="saveSubRootFormData2" style="color: black;"></div>
								   </div>
								   <div class="col-lg-6">
								      <button style="float: right;" type="button" class="btn btn-outline-dark" data-toggle="modal" data-target="#sub${fn:replace(subform.level.chart.name,' ', '_')}${subform.level.id}_${i.index}${row.id}">
									&plus; Add field
								      </button>
								   </div>
								</div>

							      </form>
							      <div class="modal" id="sub${fn:replace(subform.level.chart.name,' ', '_')}${subform.level.id}_${i.index}${row.id}">
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
							      <!------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
							      <div style="background-color: #003366; padding: 5px;border-radius: 5px;">
								<table id="subtable${sublevel.id}${subform.id}${row.id}" class="display nowrap" style="width:100%;color: black;" >
								   <thead>
								      <tr>
									<th>ID</th>
								   <c:forEach items="${SubLevelFormFieldService.getRepository().findByLevelForm(subform)}" var="suballField" varStatus="subj">
								      <th>
									${suballField.name}
								      </th>
								   </c:forEach>
								   <th>Parent level</th>
								   <th>Chart</th>
								   <th>Parent data id</th>
								   <th>Action</th>
								   </tr>
								   </thead>
								   <tbody>
								   <c:forEach items="${SubFormDataService.getRepository().findByRootFormData(row)}" var="subrow" varStatus="subrindex">
								      <tr>
									<td>${subrow.id}</td>
								      <c:forEach items="${SubLevelFormFieldService.getRepository().findByLevelForm(subform)}" var="suballField" varStatus="subj">
									<td>
									<c:choose>
									   <c:when test="${suballField.type=='file'}">
									      <a href="${SubFormDataNewObject.stringTOJson(subrow.jsonvalue).get(suballField.name)}">
										<c:out default="None" escapeXml="true" value="${not empty SubFormDataNewObject.stringTOJson(subrow.jsonvalue).get(suballField.name) ?SubFormDataNewObject.stringTOJson(subrow.jsonvalue).get(suballField.name) : ''}" />
									      </a>
									   </c:when>
									   <c:otherwise>
									      ${SubFormDataNewObject.stringTOJson(subrow.jsonvalue).get(suballField.name)}
									   </c:otherwise>
									</c:choose>
									</td>
								      </c:forEach>
								      <td>${SubLevelService.findOneById(sublevel.level_id).getName()}</td>
								      <td>${subrow.levelForm.level.chart.name}</td>
								      <td>${subrow.rootFormData.id}</td>
								      <td>
									<a href="../subroot/level-form-data/delete/?id=${subrow.id}" onclick="return confirm('Are you sure? you want to delete this record')" class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></a>
									<button class="btn btn-sm btn-success" data-toggle="modal" data-target="#subDataUpdateModal${sublevel.id}${subform.id}${row.id}${subrow.id}"><i class="fa fa-edit"></i></button>

									<div class="modal" id="subDataUpdateModal${sublevel.id}${subform.id}${row.id}${subrow.id}">
									   <div class="modal-dialog">
									      <div class="modal-content">
										<div class="modal-header">
										   <h4 class="modal-title text-primary">Update sub data</h4>
										   <button type="button" class="close" data-dismiss="modal">&times;</button>
										</div>
										<div class="modal-body">
										   <form action=""  method="POST" enctype="multipart/form-data" id="updateSubFormId${sublevel.id}${subform.id}${row.id}${subrow.id}">
										      <input type="hidden" name="id" value="${subrow.id}">
										      <c:forEach items="${SubLevelFormFieldService.getRepository().findByLevelForm(subform)}" var="suballField" varStatus="subj">
											<c:choose>
											   <c:when test="${suballField.type=='textarea'}">
											      <div class="col-lg-12 mb-2">
												<strong class="pl-2" style="color: black;" >${suballField.name}</strong>
												<textarea id="inputfield${sublevel.id}${field.id}" class="bg-focus form-control" required name="${suballField.name}" placeholder="${field.placeholder}" autocomplete="off">${FormDataNewObject.stringTOJson(row.jsonvalue).get(suballField.name)}</textarea>
												<script>
												   document.getElementById("inputfield${sublevel.id}${suballField.id}").value = "${not empty FormDataNewObject.stringTOJson(subrow.jsonvalue).get(suballField.name)?FormDataNewObject.stringTOJson(subrow.jsonvalue).get(suballField.name):''}";
												</script>
											      </div>
											   </c:when>
											   <c:otherwise>
											      <div class="col-lg-12 mb-2">
												<strong class="pl-2" style="color: black;">${suballField.name}</strong>
												<input id="inputfield${sublevel.id}${field.id}" class="bg-focus form-control" required name="${suballField.name}" type="${subfield.type}" value="${FormDataNewObject.stringTOJson(subrow.jsonvalue).get(suballField.name)}" placeholder="${suballField.placeholder}" autocomplete="off">
												<c:if test="${suballField.type=='file'}">
												   <a href="${FormDataNewObject.stringTOJson(subrow.jsonvalue).get(suballField.name)}"><img height="40"  src="${FormDataNewObject.stringTOJson(row.jsonvalue).get(suballField.name)}"></a>
												</c:if>
												<script>
												   document.getElementById("inputfield${sublevel.id}${suballField.id}").value = "${not empty FormDataNewObject.stringTOJson(subrow.jsonvalue).get(suballField.name)?FormDataNewObject.stringTOJson(subrow.jsonvalue).get(suballField.name):''}";
												</script>
											      </div>
											   </c:otherwise>
											</c:choose>
										      </c:forEach>
										      <input type="hidden" name="levelFormId" value="${sublevel.id}">
										      <input type="hidden" name="formDataId" value="${subform.id}">
										      <button type="button" onclick="updateSubData('updateSubFormId${sublevel.id}${subform.id}${row.id}${subrow.id}')" class="btn btn-success btn-sm">Submit</button> <span class="text-success p2" id="UpdateMessage"></span>
										   </form>
										</div>
										<div class="modal-footer">
										   <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
										</div>

									      </div>
									   </div>
									</div>
									</tr>
								   </c:forEach>
								   </tbody>
								   <tfoot>
								      <tr>
									<th>ID</th>
								   <c:forEach items="${SubLevelFormFieldService.getRepository().findByLevelForm(subform)}" var="suballField" varStatus="subj">
								      <th>
									${suballField.name}
								      </th>
								   </c:forEach>
								   <th>Parent level</th>
								   <th>Chart</th>
								   <th>Parent data id</th>
								   <th>Action</th>
								   </tr>
								   </tfoot>
								</table>
								<script>
								   $(document).ready(function () {
								      $('#subtable${sublevel.id}${subform.id}${row.id}').DataTable({
									dom: 'Bfrtip',
									buttons: [
									   'copy', 'csv', 'excel', 'pdf', 'print'
									]
								      });
								   });
								</script>
							      </div>

							   </c:forEach>
							</div>
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
		<div class="col-sm-1">

		</div>
	      </div>
	   </div>
	</div>
	<div class="modal-footer" style="padding: 0px;">
	   <button type="button" class="btn btn-danger" data-dismiss="modal" style="padding: 1px;margin: 0px;">Close</button>
	</div>


      </div>
   </div>

</div>
