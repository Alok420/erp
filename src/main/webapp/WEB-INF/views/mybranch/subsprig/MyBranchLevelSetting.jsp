<%-- 
    Document   : show
    Created on : 4 Aug, 2020, 8:31:49 AM
    Author     : acer
--%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

    <div class="jumbotron text-center">
      <h1>All level list</h1>
    </div>
    <div class="container-fluid">
      <form action="../level/create"  class="text-center" method="POST" enctype="multipart/form-data" style="background-color: beige;">
        <table width="100%" >
          <tr>
            <td>
              <label>Name</label>
              <div><input type="text" name="name" class="form-control"></div>
            </td>
            <td>
              <label>RootChart ID</label>
              <div>
                <select name="chart" id="chart_id" class="form-control">
                  <option selected>Select branch chart</option>
                  <c:forEach items="${Charts}" var="chart">
                    <option value="${chart.id}">${chart.name}</option>
                  </c:forEach>
                </select>
              </div>
            </td>
            <td>

              <div>
                <label for="pwd">Select level</label>
                <select name="level_id" id="level_id" class="form-control">
               
                </select>
              </div>
            </td>
          </tr>
          <tr>
            <td colspan="2" class="text-center">
              <button type="submit" class="btn btn-primary">Submit</button>
            </td>
          </tr>
        </table>
      </form>
      <table class="table table-condensed tble-bordered">
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Root Chart id</th>
          <th>Parent level id</th>

        </tr>
        <c:forEach items="${Levels}" var="level1">     
          <tr>
            <td>${level1.id}</td>
            <td>${level1.name}</td>
            <td>${level1.chart.id}</td>
            <td>${level1.level_id}</td>
            <td><a href="../level/delete?id=${level1.id}"><button>delete</button></a></td>
          </tr>
        </c:forEach>



      </table>
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
