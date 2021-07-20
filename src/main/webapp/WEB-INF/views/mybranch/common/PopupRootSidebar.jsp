
<div class="col-sm-12 text-left" style=" background-color: #1560bd; margin-left: 0px ; padding: 0px 1px 0px 4px; font-size: 10px; letter-spacing: 2px;  color: white ">
   <div style="height: 20px; font-size: 13px; color: #dcdcdc;  text-align: center; margin-top: 5px">Root Chart</div>
   <ul>
      <c:forEach items="${SubMainService.findAllByMyBranchLevelForm(form)}" var="submain">
         <c:choose>
            <c:when test = "${param.subid ==submain.id}">
               <a style="" href="/mybranch/Dashboard?id=${param.id}&subid=${submain.id}"><li style="width: 250px; list-style: none; color: white; padding: 5px;background-color: white; color: black;"> ${submain.name} </li> </a>

            </c:when>
            <c:otherwise>
               <a href="/mybranch/Dashboard?id=${param.id}&subid=${submain.id}"><li style="list-style: none; color: white; padding: 5px"> ${submain.name} </li> </a>
            </c:otherwise>
         </c:choose>
      </c:forEach>
      <li>

         <button type="button" class="btn btn-outline-light m-1" data-toggle="modal" data-target="#addsubmainmodal">
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
         <div class="modal" id="addsubmainmodal">
            <div class="modal-dialog">
               <div class="modal-content">

                  <!-- Modal Header -->
                  <div class="modal-header">
                     <h4 class="modal-title" style="color: blue;">Add Root Chart</h4>
                     <button type="button" class="close" data-dismiss="modal">&times;</button>
                  </div>

                  <!-- Modal body -->
                  <div class="modal-body">
                     <form action="../submybranch/main/create" onsubmit="return validaterRootChartForm()"  method="POST" enctype="multipart/form-data">
                        <table align="center" width="100%">
                           <tr>
                              <td>
                                 <div class="text-primary">Name <span class="root_form_errormessage text-danger"></span></div>

                                 <div><input type="text" onblur="validaterRootChartForm()" class="form-control" id="add_root_id" name="name">
                                 </div>
                              </td>
                              <td>
                                 <input type="hidden" name="mybranchLevelForm" value="${form.id}">
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
</div>