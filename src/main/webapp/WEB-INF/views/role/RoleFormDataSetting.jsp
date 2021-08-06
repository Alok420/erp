<%-- 
    Document   : update
    Created on : 4 Aug, 2020, 8:32:35 AM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Show all</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  </head>
  <body>
    <%@include file="../common/header.jsp" %>


    <div class="container">
      <h3 style="text-align: center;">All field list</h3>
      <button type="button" class="btn btn-info" data-toggle="modal" data-target="#createForm">Create new form</button>

      <!-- Modal -->
      <div id="createForm" class="modal fade" role="dialog">
        <div class="modal-dialog">

          <!-- Modal content-->
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title">Create new form</h4>
            </div>
            <div class="modal-body">
              <form action="../level-form/create" method="POST" enctype="multipart/form-data">

                <div class="form-group">
                  <label for="chart_id">Select Root chart</label>
                  <select name="chart_id" id="chart_id" class="form-control">
                    <option selected>Select branch chart</option>
                    <c:forEach items="${Charts}" var="chart">
                      <option value="${chart.id}">${chart.name}</option>
                    </c:forEach>
                  </select>
                </div>

                <div class="form-group">
                  <label for="pwd">Select level</label>
                  <select name="level" id="level_id" class="form-control">

                  </select>
                </div>

                <div class="form-group">
                  <label for="form_action">Form Action </label>
                  <input type="text" class="form-control" id="form_action" name="action">
                </div>
                <div class="form-group">
                  <label for="form_action">Form method </label>
                  <select name="method" class="form-control">
                    <option value="GET">Get</option>
                    <option value="POST">Post</option>
                  </select>
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

      <div id="accordion">
        <c:forEach items="${LevelForms.getRepository().findAll()}" var="levelform" varStatus="i">     
          <div class="card">
            <div class="card-header">
              <a class="card-link" data-toggle="collapse" href="#collapse${i.index}">
                ${levelform.level.chart.name} | ${levelform.level.name} |  Form ${i.index}
              </a>
              <a href="../level-from/delete?id=${levelform.id}" style="font-size: 20px; float: right; color: orangered;font-weight: bold;">
                &times;
              </a>
            </div>
            <div id="collapse${i.index}" class="collapse" data-parent="#accordion">
              <div class="card-body">

                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#${levelform.level.chart.name}${levelform.level.id}_${i.index}">
                  Add fields
                </button>


                <div class="modal" id="${levelform.level.chart.name}${levelform.level.id}_${i.index}">
                  <div class="modal-dialog">
                    <div class="modal-content">
                      <div class="modal-header">
                        <h4 class="modal-title">Add fields</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                      </div>
                      <div class="modal-body">
                        <form action="../level-form-field/create" method="POST" enctype="multipart/form-data">
                          <input type="hidden" value="${levelform.id}" name="levelForm">
                          <div class="form-group">
                            <label for="chart_id">Select input type</label>
                            <select name="type" id="chart_id" class="form-control">
                              <option selected value="text">Text</option>
                              <option selected value="password">Password</option>
                              <option selected value="number">Number</option>
                            </select>
                          </div>
                          <div class="form-group">
                            <label for="chart_id">Set field name</label>
                            <input type="text" class="form-control" name="name">
                          </div>
                          <div class="form-group">
                            <label for="chart_id">Set placeholder</label>
                            <input type="text" class="form-control" name="placeholder">
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
                <c:forEach items="${LevelFormFieldService.getRepository().findByLevelForm(levelform)}" var="form" varStatus="i">     
                  <div class="row text-center mt-4">
                    <div class="col-sm-1">${i.index}</div>
                    <div class="col-sm-7"><input type="${form.type}" class="form-control"></div>
                    <div class="col-sm-4">
                      <a href="../level-form-field/delete?id=${form.id}" style="font-size: 20px; color: orangered;font-weight: bold;">
                        &times;
                      </a>
                    </div>
                  </div>
                </c:forEach>
              </div>
            </div>
          </div>
        </c:forEach>


      </div>
    </div>
    <script>
      $(document).ready(function () {
        $('#chart_id').on('change', function (e) {
          var optionSelected = $("option:selected", this);
          var valueSelected = this.value;
          setData(valueSelected);
        });


      });
      function setData(id) {
        $.get("getlevels/",
                {
                  id: id
                },
                function (obj, status) {
                  var obj = JSON.parse(JSON.stringify(obj));
                  $('#level_id').empty();
                  for (var i = 0; i < obj.length; i++) {
                    $('#level_id').append($('<option>', {value: obj[i].id, text: obj[i].name}));
                  }
                });
      }
    </script>
  </body>
</html>
