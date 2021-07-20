<%--
    Document   : visitor
    Created on : Aug 28, 2020, 10:08:50 AM
    Author     : Ramesh
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
  <head>
    <title>G-ERP Account </title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../css/bootstrap.css"/>
    <link rel="stylesheet" href="../../css/Mystyle.css"/>
    <link rel="stylesheet" href="../../icofont/icofont.css"/>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css"/>
    <link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.6.4/css/buttons.dataTables.min.css"/>
    <script type="text/javascript" src="../../js/jquery-3.3.1.js"></script>
    <script>
      function getFieldData(id) {
        var data = $('#' + id).val();
        return data;
      }
      function textWithSpace(data) {
        var re = /^[a-zA-Z ]+$/;
        return re.test(data);
      }
      function text(data) {
        var re = /^[a-zA-Z]+$/;
        return re.test(data);
      }
      function textWithNumber(data) {
        var re = /^[a-z0-9-]+$/i;
        return re.test(data);
      }
      function dob(data) {
        var re = /^\d{2}([./-])\d{2}\1\d{4}$/;
        fields["dob"] = re.test(data);
      }
      function number(data) {
        var pattern = /^\d+$/;
        return pattern.test(data);
      }
      function validateEmail(data) {
        var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return re.test(data);
      }
      function Contact_number(data) {
        var pattern = new RegExp("^([0|\+[0-9]{1,5})?([7-9][0-9]{9})$");
        return pattern.test(data);
      }
      function validate(fields) {
        var finallyreturn = true;
        fname(getFieldData("fname"));
        lname(getFieldData("lname"));
        //                dob(getFieldData("dob"));
        filterPhone(getFieldData('mobile'));
        validateEmail(getFieldData('email'));
        ValidateUsername(getFieldData('username'));
        ValidatePassword(getFieldData('password'));
        confirm_password(getFieldData('password'), getFieldData('confirmpassword'));
        for (var key in fields) {
          if (fields.hasOwnProperty(key)) {
            console.log(key + "--" + fields[key]);
            if (fields[key] === false) {
              finallyreturn = false;
              $('.errormessage').text(key.toString().toUpperCase() + " is invalid");
              $("#" + key.toString()).css("border", "thin solid red");
              $("#" + key.toString()).css("box-shadow", "1px 1px 10px red");
              return false;
            } else {
              finallyreturn = true
              $("#" + key.toString()).css("border", "thin solid green");
              $("#" + key.toString()).css("box-shadow", "1px 1px 10px green");
              $('.errormessage').text(key.toString().toUpperCase() + " valid");

            }
          }
        }
        return finallyreturn;
      }
      function validateLevelForm() {
        var level_fields = {
          add_level_id: textWithNumber(getFieldData("add_level_id"))
        };

        var finallyreturn = true;
        for (var key in level_fields) {
          if (level_fields.hasOwnProperty(key)) {
            console.log(key + "--" + level_fields[key]);
            if (level_fields[key] === false) {
              finallyreturn = false;
              $('.level_form_errormessage').text("Field is invalid".toUpperCase());
              $("#" + key.toString()).css("border", "thin solid red");
              $("#" + key.toString()).css("box-shadow", "1px 1px 10px red");
              return false;
            } else {
              finallyreturn = true
              $("#" + key.toString()).css("border", "thin solid green");
              $("#" + key.toString()).css("box-shadow", "1px 1px 10px green");
              $('.level_form_errormessage').text("Field is valid ".toUpperCase());

            }
          }
        }
        return finallyreturn;
      }
      function validaterRootChartForm() {
        var level_fields = {
          add_flower_id: text(getFieldData("add_flower_id"))
        };

        var finallyreturn = true;
        for (var key in level_fields) {
          if (level_fields.hasOwnProperty(key)) {
            console.log(key + "--" + level_fields[key]);
            if (level_fields[key] === false) {
              finallyreturn = false;
              $('.flower_form_errormessage').text("Field is invalid".toUpperCase());
              $("#" + key.toString()).css("border", "thin solid red");
              $("#" + key.toString()).css("box-shadow", "1px 1px 10px red");
              return false;
            } else {
              finallyreturn = true
              $("#" + key.toString()).css("border", "thin solid green");
              $("#" + key.toString()).css("box-shadow", "1px 1px 10px green");
              $('.flower_form_errormessage').text("Field is valid ".toUpperCase());

            }
          }
        }
        return finallyreturn;
      }
      function validaterAddFields() {
        var level_fields = {
          field_name: text(getFieldData("field_name")),
          placeholder: text(getFieldData("placeholder"))
        };

        var finallyreturn = true;
        for (var key in level_fields) {
          if (level_fields.hasOwnProperty(key)) {
            console.log(key + "--" + level_fields[key]);
            if (level_fields[key] === false) {
              finallyreturn = false;
              $('.flower_form_errormessage').text("Field is invalid".toUpperCase());
              $("#" + key.toString()).css("border", "thin solid red");
              $("#" + key.toString()).css("box-shadow", "1px 1px 10px red");
              return false;
            } else {
              finallyreturn = true
              $("#" + key.toString()).css("border", "thin solid green");
              $("#" + key.toString()).css("box-shadow", "1px 1px 10px green");
              $('.flower_form_errormessage').text("Field is valid ".toUpperCase());

            }
          }
        }
        return finallyreturn;
      }
    </script>
    <style type="text/css">
      input[type="search"]{
        background-color: whitesmoke!important;
        color: black;
        border-radius: 100px;
        padding-left: 10px;
      }
      .dataTables_wrapper{
        border: 2px solid #19BB2E;
        border-radius: 2px;
        padding: 10px;
      }
    </style>
  </head>
  <body>

    <%@include file="../common/header.jsp"%>

    <div class="container-fluid" style="background-color: whitesmoke; height: 70px; border-bottom: 1px solid #d7d8d9">
      <div class="row">
        <div class="col-sm-1" style=" background-color: #1560bd; height: 70px; margin-left: 0px ; padding: 0px 1px 0px 4px; font-size: 10px; letter-spacing: 2px;  color: white; line-height: 12px; border-right: 1px #1560bd solid">
          <div style="background-color: whitesmoke; height: 70px; font-size: 13px; color: #dcdcdc;  text-align: center"> <a href="#" ><img src="images/Logo.png" alt=""/> </a></div>
        </div>
        <div class="col-sm-11">
          <div class="row" style="height: 37px">
          </div>
        </div>
      </div>
    </div>
    <div class="container-fluid" style="background-color: transparent">
      <div class="row">
        <!----------------------------Left Side bar----------->
        <%@include file="common/RootSidebar.jsp" %>
        <!----------------------------Left Side bar----------->
        <div class="col-11 container-fluid" style="background-color: white; height: 635px;overflow: scroll">
          <!--******************************************Tab wrap*********************************************************************************************-->
          <div class="row">
            <div class="container" style=" background: whitesmoke;  margin: 0px 0px 0px 0px; padding: 2px; height: 577px">
              <span class="text-danger bg-white">
                <%                  if (request.getParameter("LevelException") != null) {
                    out.print("Error: " + request.getParameter("LevelException"));
                  }
                %>
              </span>
              <span class="text-danger bg-white">
                <%
                  if (request.getParameter("LevelMessage") != null) {
                    out.print("Message: " + request.getParameter("LevelMessage"));
                  }
                %>
              </span>

              <ul class="tab-wrap DataTab">
                <!-------------Level-1  Start--------------------->
                <c:set var="checked" value="checked"></c:set>

                <c:forEach items="${LevelService.FindLevelByMain(MainService.findById(param.id))}" var="level" varStatus="i">

                  <c:set var="lastlevel" value="${level}" scope="page"></c:set>
                    <li>
                    <c:if test="${not empty sessionScope['active_level']}">
                      <c:set var="checked" value=""></c:set>
                      <c:if test="${sessionScope['active_level'] == i.index}" >
                        <c:set var="checked" value="checked"></c:set>
                      </c:if>
                    </c:if>
                    <input type="radio" id="tab-${i.index}" ${checked} onclick="changeLevel(${i.index})" name="tab"/>
                    <label for="tab-${i.index}"> <p tabindex="${i.index}">${level.name}</p> </label>
                    <!-----------Backend Server site Data fetch showing  row column start---------------------->
                    ,<div class="tab-content tab-content1 show">
                      <div  style="letter-spacing: 1px; margin-top: 5px">
                        <section class="panel">
                          <div class="panel-body" style="color:black;">
                            <!-------------------------------------------------------------------add form------------------------------------->
                            <c:if test="${FormService.findByLevel(level).size()<1}">
                              <button id="addformbtn" type="button" class="btn btn-success btn-sm" style="float: right;" data-toggle="modal" data-target="#addform${level.id}">&plus;Add form</button>
                            </c:if>

                            <!-- Modal -->
                            <div id="addform${level.id}" class="modal fade" role="dialog">
                              <div class="modal-dialog">
                                <!-- Modal content-->
                                <div class="modal-content">
                                  <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Add new form</h4>
                                  </div>
                                  <div class="modal-body">
                                    <form onsubmit="validateLevelForm()" action="../flower/level-form/create" method="POST" enctype="multipart/form-data">
                                      <div class="level_form_errormessage"></div>

                                      <input id="level_id" type="hidden" value="${level.id}" name="level">
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
                            <!-------------------------------------------------------------------end add form------------------------------------->

                            <c:forEach items="${FormService.findByLevel(level)}" var="form" varStatus="formindex">
                              <script>
                                $(document).ready(function () {
                                  $('#addform${level.id}').hide();
                                });
                              </script>
                              <form method="POST" action="../flower/level-form-data/create" style="border: 2px solid #19BB2E; border-radius: 2px; padding: 10px;">
                                <div class="row form-group">
                                  <c:forEach items="${LevelFormFieldService.getRepository().findByLevelForm(form)}" var="field" varStatus="">
                                    <div class="col-lg-3 mb-2">
                                      <input class="bg-focus form-control" required name="${field.name}" type="${field.type}" value="" placeholder="${field.placeholder}" autocomplete="off">
                                    </div>
                                  </c:forEach>
                                </div>
                                <input type="hidden" name="levelFormId" value="${form.id}">
                                <div class="row form-group">
                                  <div class="col-lg-3">
                                    <input type="submit" value="Save" class="btn btn-block btn-outline-success">
                                  </div>
                                </div>

                                <button type="button" class="btn btn-outline-dark" data-toggle="modal" data-target="#${fn:replace(form.level.chart.name,' ', '_')}${form.level.id}_${i.index}">
                                  &plus; Add field
                                </button>
                              </form>

                              <div class="modal" id="${fn:replace(form.level.chart.name,' ', '_')}${form.level.id}_${i.index}">
                                <div class="modal-dialog">
                                  <div class="modal-content">
                                    <div class="modal-header">
                                      <h4 class="modal-title">Add fields</h4>
                                      <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    </div>
                                    <div class="modal-body">
                                      <form action="../flower/level-form-field/create"  method="POST" enctype="multipart/form-data">
                                        <input type="hidden" value="${form.id}" name="levelForm">
                                        <div class="form-group">
                                          <span class="text-success" for="chart_id">Select input type</span>
                                          <select name="type" id="chart_id" class="form-control">
                                            <option selected value="text">Text</option>
                                            <option selected value="date">Date</option>
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
                            </div>
                          </section>
                        </div>

                        <div>
                          <table id="table${level.id}" class="display nowrap" style="width:100%;color: black;" >
                            <thead>
                              <tr>
                                <th>ID</th>
                                  <c:forEach items="${LevelFormFieldService.getRepository().findByLevelForm(form)}" var="allField" varStatus="j">
                                  <th>
                                    ${allField.name}
                                  </th>
                                </c:forEach>
                                <th>Parent level</th>
                                <th>Parent Chart</th>
                                <th>Action</th>
                              </tr>
                            </thead>
                            <tbody>
                              <c:forEach items="${FormDataService.getRepository().findByLevelForm(form)}" var="row" varStatus="rindex">
                                <tr>
                                  <td>${row.id}</td>
                                  <c:forEach items="${LevelFormFieldService.getRepository().findByLevelForm(form)}" var="allField" varStatus="j">
                                    <td>
                                      ${FormDataNewObject.stringTOJson(row.jsonvalue).get(allField.name)}
                                    </td>
                                  </c:forEach>
                                  <td>${LevelService.findOneById(level.level_id).getName()}</td>
                                  <td>${row.levelForm.level.chart.name}</td>
                                  <td><a href="../flower/level-form-data/delete/?id=${row.id}" class="btn btn-danger">Delete</a></td>
                                </tr>
                              </c:forEach>
                            </tbody>
                            <tfoot>
                              <tr>
                                <th>ID</th>
                                  <c:forEach items="${LevelFormFieldService.getRepository().findByLevelForm(form)}" var="allField" varStatus="j">
                                  <th>
                                    ${allField.name}
                                  </th>
                                </c:forEach>
                                <th>Parent level</th>
                                <th>Parent Chart</th>
                                <th>Action</th>
                              </tr>
                            </tfoot>
                          </table>
                          <script>
                            $(document).ready(function () {
                              $('#table${level.id}').DataTable({
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
                    <!-----------Backend Server site Data fetch showing  row column end---------------------->
                  </li>
                  <c:if test="${i.index ge 0}">
                    <c:set var="checked" value="unchecked"></c:set>
                  </c:if>
                </c:forEach>
                <!-------------------------------------------------------------add level ---------------------------------------------------------------->
                <li data-toggle="modal" data-target="#addlevel">
		 <label>
                    &plus; Add level
                  </label>
                  <!-- The Modal -->
                  <div id="addlevel" class="modal fade" role="dialog">
                    <div class="modal-dialog">

                      <!-- Modal content-->
                      <div class="modal-content">
                        <div class="modal-header">
                          <h4 class="modal-title">Create new level</h4>

                          <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <div class="modal-body">
                          <form action="../flower/level/create" onsubmit="return validateLevelForm()" method="POST" enctype="multipart/form-data">

                            <div class="form-group">
                              <div class="level_form_errormessage text-danger"></div>
                              <span>Name</span>
                              <div><input onblur="validateLevelForm()" type="text" id="add_level_id" name="name" class="form-control"></div>
                            </div>
                            <div class="form-group">
                              <input name="chart" type="hidden" value="${param['id']}">
                            </div>
                            <div class="form-group">
                              <input type="hidden" name="level_id" value="${lastlevel eq  null?0:lastlevel.id}">
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
                  <script>
//                    $(document).ready(function () {
//                      $('#chart_id').on('change', function (e) {
//                        var optionSelected = $("option:selected", this);
//                        var valueSelected = this.value;
//                        setData(valueSelected);
//                      });
//
//
//                    });
//                    function setData(id) {
//                      $.post("../settings/getlevels/" + id,
//                              {
//                                id: id
//                              },
//                              function (obj, status) {
//                                var obj = JSON.parse(JSON.stringify(obj));
//                                $('#level_id').empty();
//                                for (var i = 0; i < obj.length; i++) {
//                                  $('#level_id').append($('<option>', {value: obj[i].id, text: obj[i].name}));
//                                }
//                              });
//                    }
                  </script>
                </li>
                <!----------------------------------------------------------------------------------------end add level ----------------------------------------->

              </ul>
            </div>
          </div>
          <!--***************************************Tab Wrap end***************************************************************************************************-->
        </div>
      </div>
    </div>

    <span style="font-size:11px; color:  #666666">Copyright@ Opam-G Infocons Industries Ltd, Reg. Office- House No-108, Vill-Jalalpur, Post-Parmanandpur, Pin No-844507, Mahnar Road (R.S.) , Dist-Vaishali, Bihar, India  </span>
    <a href="../flower/settings">Settings</a>
    <!------------------------------------------------------------------------------------->
    <script>
      $(document).ready(function () {
        $('#example').DataTable({
          dom: 'Bfrtip',
          buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
          ]
        });
      });
    </script>
    <script>
      function changeLevel(id) {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
          if (this.readyState == 4 && this.status == 200) {

          }
        };
        xhttp.open("GET", "../flower/level/changeLevel?id=" + id, true);
        xhttp.send();
      }
    </script>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.4/js/dataTables.buttons.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.4/js/buttons.flash.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.4/js/buttons.html5.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.4/js/buttons.print.min.js"></script>
    <script src="../../js/oPamGfunctionmy.js"></script>
    <script type="text/javascript" src="../../js/popper.min.js"></script>
    <script type="text/javascript" src="../../js/bootstrap.js"></script>
  </body>
</html>

