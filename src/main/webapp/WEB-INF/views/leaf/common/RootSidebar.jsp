<ul>
  <c:forEach items="${MainService.findAllMain()}" var="main">   

    <c:choose>
      <c:when test = "${param.id ==main.id}">
        <a style="" href="/leaf/Dashboard?id=${main.id}"><li> ${main.name} </li> </a> 
      </c:when>
      <c:otherwise>
        <a href="/leaf/Dashboard?id=${main.id}"><li > ${main.name} </li> </a> 
      </c:otherwise>
    </c:choose>
  </c:forEach>
  <li>

    <button type="button" class="btn btn-outline-light m-1" data-toggle="modal" data-target="#addmainmodal">
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
    <div class="modal" id="addmainmodal">
      <div class="modal-dialog">
        <div class="modal-content">

          <!-- Modal Header -->
          <div class="modal-header">
            <h4 class="modal-title" style="color: blue;">Add Root Chart</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
          </div>

          <!-- Modal body -->
          <div class="modal-body">
            <form action="../leaf/main/create" onsubmit="return validaterRootChartForm()"  method="POST" enctype="multipart/form-data">
              <table align="center" width="100%">
                <tr>
                  <td>
                    <div class="text-primary">Name <span class="root_form_errormessage text-danger"></span></div>

                    <div><input type="text" onblur="validaterRootChartForm()" class="form-control" id="add_root_id" name="name">  
                    </div>
                  </td>
                  <td>
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
