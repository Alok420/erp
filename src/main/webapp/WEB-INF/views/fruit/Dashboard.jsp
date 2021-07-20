<%--
    Document   : visitor
    Created on : Aug 28, 2020, 10:08:50 AM
    Author     : Ramesh
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate var="year" value="${now}" pattern="yyyy" />
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
     
        <link rel="stylesheet" href="/css/bootstrap.css"/>
        <script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/chart.js@2.9.3/dist/Chart.min.css" type="text/css">
        <link rel="stylesheet" href="/css/Mystyle.css"/>
        <link rel="stylesheet" href="/icofont/icofont.css"/>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css"/>
        <link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.6.4/css/buttons.dataTables.min.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script>
            var bodywidth = window.innerWidth;
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
                //            var level_fields = {
                //               add_level_id: textWithNumber(getFieldData("add_level_id"))
                //            };
                //
                //            var finallyreturn = true;
                //            for (var key in level_fields) {
                //               if (level_fields.hasOwnProperty(key)) {
                //                  console.log(key + "--" + level_fields[key]);
                //                  if (level_fields[key] === false) {
                //                     finallyreturn = false;
                //                     $('.level_form_errormessage').text("Field is invalid".toUpperCase());
                //                     $("#" + key.toString()).css("border", "thin solid red");
                //                     $("#" + key.toString()).css("box-shadow", "1px 1px 10px red");
                //                     return false;
                //                  } else {
                //                     finallyreturn = true
                //                     $("#" + key.toString()).css("border", "thin solid green");
                //                     $("#" + key.toString()).css("box-shadow", "1px 1px 10px green");
                //                     $('.level_form_errormessage').text("Field is valid ".toUpperCase());
                //
                //                  }
                //               }
                //            }
                //            return finallyreturn;
            }
            function validaterRootChartForm() {
                var level_fields = {
                    add_fruit_id: text(getFieldData("add_fruit_id"))
                };
                var finallyreturn = true;
                for (var key in level_fields) {
                    if (level_fields.hasOwnProperty(key)) {
                        console.log(key + "--" + level_fields[key]);
                        if (level_fields[key] === false) {
                            finallyreturn = false;
                            $('.fruit_form_errormessage').text("Field is invalid".toUpperCase());
                            $("#" + key.toString()).css("border", "thin solid red");
                            $("#" + key.toString()).css("box-shadow", "1px 1px 10px red");
                            return false;
                        } else {
                            finallyreturn = true
                            $("#" + key.toString()).css("border", "thin solid green");
                            $("#" + key.toString()).css("box-shadow", "1px 1px 10px green");
                            $('.fruit_form_errormessage').text("Field is valid ".toUpperCase());
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
                            $('.fruit_form_errormessage').text("Field is invalid".toUpperCase());
                            $("#" + key.toString()).css("border", "thin solid red");
                            $("#" + key.toString()).css("box-shadow", "1px 1px 10px red");
                            return false;
                        } else {
                            finallyreturn = true
                            $("#" + key.toString()).css("border", "thin solid green");
                            $("#" + key.toString()).css("box-shadow", "1px 1px 10px green");
                            $('.fruit_form_errormessage').text("Field is valid ".toUpperCase());
                        }
                    }
                }
                return finallyreturn;
            }
            function onYearChange(thisobj) {
                var url_str = window.location.href;
                var url = new URL(url_str);
                var id = url.searchParams.get("id");
                var subid = url.searchParams.get("subid");
                var year = thisobj.value;
                var actual_url = url_str.split("?");
                window.location.href = actual_url[0] + "?id=" + id + "&subid=" + subid + "&year=" + year;
            }
        </script>

        <style>
            .nav-pills .active{
                background-color: transparent!important;

            }
        </style>
    </head>
    <body>
        <%@include file="../common/header.jsp"%>

        <div id="myCompHeaderhideShow" class= "container-fluid" style="display: none; border-bottom: 0px  solid #1560bd; padding: 1px; margin: 0px; color: #004085">
            <div class=row style="border-bottom: 0px #000066 solid  ;padding: 0px; margin: 0px; height: 60px">
                <div class="col-sm-1 imageFitUser text-center" style="padding: 0px ; border-left: 1px #0056b3 solid; border-right: 1px #bbbbff solid; max-height: 88px; max-width: 112px">
                    <a href="#" ><img src="image/Logo.png" alt=""/> </a>
                </div>
                <div class="col-sm-4 text-justify " style=" border: 0px solid #1560bd; font-size: 11px; letter-spacing: 1.25px; line-height: 12px">
                    <b>Opam-G Infocons Industries Ltd.</b>
                    <br>
                    CIN- U2456666BR201778999  <br>
                    Business Address- H No-58 D, Road No-01, Ashok Nagar, <br>
                    Dist- Ranchi-834002, Jharkahnd
                    Phone- 0651 2240165, Email- opamg2017@gmail.com,
                </div>
                <div class="col-sm-6 text-right" style="border-right: 1px #bbbbff solid; border-left: 1px #bbbbff solid">
                </div>
                <div class="col-sm-1 imageFitUser text-center" style=" padding: 10px 0px 0px 0px ; border-right: 1px #0056b3 solid;  max-width: 112px">
                    <a style=" text-decoration: none; font-size: 11px" href="#" ><img src="image/UserLogo.png" alt=""/><br> <b>Ramesh Kr. Sinha</b> </a>
                </div>
            </div>
        </div>
        <div class= "container-fluid" style="padding: 0px;">

        </div>
        <div class="row" style="border-top: 1px #000099 solid;margin: 0px;">
            <div class="col-sm-1 text-center"  style="border-right: 1px #007bff solid; background-color: #1560bd ; letter-spacing: 1px; color: white; font-size: 15px; padding: 2px 2px 2px 2px">
                Info-Ledger
            </div>
            <div class="col-sm-10 text-center"  style="border: 0px #000 solid  ; background-color: #1560bd ; letter-spacing: 1px; color: white; font-size: 15px; padding: 2px 2px 2px 2px">
                <div class="row">
                    <div class="col-sm-1">
                    </div>
                    <div class="col-sm-10">
                        <span style="background-color: red; padding: 2px 20px 2px 20px; color: white">
                            Info- Ledger of Visitor
                            <select onchange="onYearChange(this)">
                                <option selected>
                                    <c:choose>
                                        <c:when test="${empty param.year}">
                                            ${year}
                                        </c:when>
                                        <c:otherwise>
                                            ${param.year}
                                        </c:otherwise>
                                    </c:choose>
                                </option>
                                <script>
                                    for (var i = 0; i < 40; i++) {
                                        document.write("<option>" + (2020 + i) + "</option>");
                                    }
                                </script>
                            </select>
                        </span>
                    </div>
                    <div class="col-sm-1 hide_showbtn" style="display: inline-block">
                        <button style="font-size: 5px; background:  #000099" onclick="myHeadeRFunction()">Try it</button>
                        <button style="font-size: 5px; background:  #000099" onclick="myGraphFunction()">Try it</button>
                    </div>
                </div>
            </div>

            <div class="col-sm-1 text-center"  style="border-left: 1px #007bff solid; background-color: #1560bd ; letter-spacing: 1px; color: white; font-size: 15px; padding: 2px 2px 2px 2px">
                User Action
            </div>

        </div>
    </div>

    <div class="container-fluid" style="background-color: transparent">
        <div class="row">
            <!----------------------------Left Side bar----------->
            <div class="col-sm-1 text-left" style=" background-color: #1560bd; margin-left: 0px ; padding: 0px 1px 0px 4px; font-size: 10px; letter-spacing: 2px;  color: white ">
                <%@include file="common/RootSidebar.jsp" %>
            </div>
            <!----------------------------Left Side bar----------->
            <div class="col-10" style=" overflow: scroll">
                <!--******************************************Tab wrap*********************************************************************************************-->
                <div id="myGraphhideShow" class="row">
                    <div  class="container-fluid text-center" style=" background-color: #fcfcc6;margin:0px;padding:0px;border: 0px  #0056b3 solid; color: #061148 ;  height: 150px;">
                        <canvas id="myChart" width="100%" height="10"></canvas>
                        <script>
                            function random_rgba() {
                                var o = Math.round, r = Math.random, s = 255;
                                return 'rgba(' + o(r() * s) + ',' + o(r() * s) + ',' + o(r() * s) + ',0.6)';
                            }
                            var months = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
                            var printMonths = [];
                            var datasets = [];
                            <c:choose>
                                <c:when test="${empty param.year}">
                                    <c:set var="year" value="${year}"></c:set>
                                </c:when>
                                <c:otherwise>
                                    <c:set var="year" value="${param.year}"></c:set>
                                </c:otherwise>
                            </c:choose>

                            <c:forEach items="${FormDataService.allGroupByMonth(param.id,year)}" var="obj" varStatus="i">
                            if (printMonths.indexOf(months[${obj[0]-1}]) === -1) {
                                printMonths.push(months[${obj[0]-1}])
                            }
                            </c:forEach>
                            <c:forEach items="${FormDataService.allGroupByLevel(param.id,year)}" var="obj" varStatus="i">
                                <c:if test="${obj[0]>0}">
                            var rgb = random_rgba();

                            var newDataset = {
                                label: '${FormService.findById(obj[0]).level.name}',
                                backgroundColor: rgb,
                                borderColor: rgb,
                                data: [],
                                fill: false
                            };
                            for (var i = 0; i < printMonths.length; i++) {

                                if (printMonths[i] == months[${obj[1]-1}]) {

                                    newDataset.data.push(${obj[2]});
                                } else
                                    newDataset.data.push(0);
                            }
                                </c:if>
                            datasets.push(newDataset);
                            </c:forEach>
                            //		   alert(printMonths);
                            //		   newDataset.data.push(randomScalingFactor());
                            var ctx = document.getElementById('myChart').getContext('2d');
                            var myChart = new Chart(ctx, {
                                type: 'bar',
                                data: {
                                    labels: months,
                                    datasets: datasets
                                },
                                options: {
                                    scales: {
                                        yAxes: [{
                                                ticks: {
                                                    beginAtZero: true
                                                }
                                            }]
                                    }
                                }
                            });
                        </script>

                    </div>
                </div>
                <div class="row">
                    <div class="container-fluid" style=" background: #061148; padding: 2px; min-height: 700px">
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
                        <ul class="nav nav-tabs">
                            <c:forEach items="${LevelService.FindLevelByMain(MainService.findById(param.id))}" var="level" varStatus="i">
                                <c:set var="lastlevel" value="${level}"></c:set>

                                <c:set var="activetab" value="${''}"></c:set>
                                <c:if test="${i.index<1}">
                                    <c:set var="activetab" value="${'active'}"></c:set>
                                </c:if>
                                <li class="${activetab}">
                                    <a class="${activetab}" data-toggle="tab" href="#FruitTabContent${level.id}0">
                                        ${level.name}
                                    </a>
                                </li>
                            </c:forEach>
                            <li>
                                <a href="#"  class="addmore" style="background-color: transparent;border: none;" data-toggle="modal" data-target="#addlevel">&plus; Add level</a>
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
                                                <form action="../fruit/level/create" onsubmit="return validateLevelForm()" method="POST" enctype="multipart/form-data">
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
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </ul>
                        <div class="tab-content" style="background-color: transparent;">
                            <c:forEach items="${LevelService.FindLevelByMain(MainService.findById(param.id))}" var="level" varStatus="i">

                                <c:set var="activetabcontent0" value="${''}"></c:set>
                                <c:if test="${i.index <1}">
                                    <c:set var="activetabcontent0" value="${'active show'}"></c:set>
                                </c:if>
                                <div id="FruitTabContent${level.id}0" class="tab-pane fade ${activetabcontent0}">
                                    <div  style="letter-spacing: 1px; margin-top: 5px">
                                        <section class="panel" style="background-color: transparent;">
                                            <div class="panel-body" style="background-color: #003366;overflow: scroll;">
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
                                                                <form onsubmit="validateLevelForm()" action="../fruit/level-form/create" method="POST" enctype="multipart/form-data">
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
                                                <c:forEach items="${FormService.findByLevel(level)}" var="form" varStatus="formindex">
                                                    <c:set var="form" scope="page" value="${form}"></c:set>
                                                    <%@include file="NewPopup.jsp" %>
                                                    <div style="">
                                                        <table id="table${level.id}" class="display"  style="width:100%;color: black;" >
                                                            <thead>
                                                                <tr>
                                                                    <th>ID</th>
                                                                        <c:forEach items="${LevelFormFieldService.getRepository().findByLevelForm(form)}" var="allField" varStatus="j">
                                                                        <th>
                                                                            ${allField.name}
                                                                        </th>
                                                                    </c:forEach>
                                                                    <th>Parent level</th>
                                                                    <th>Chart</th>
                                                                    <th>Creation date</th>
                                                                    <th>Action</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <c:forEach items="${FormDataService.getRepository().findByLevelForm(form)}" var="row" varStatus="rindex">
                                                                    <tr>
                                                                        <td>${row.id}</td>
                                                                        <c:forEach items="${LevelFormFieldService.getRepository().findByLevelForm(form)}" var="allField" varStatus="j">
                                                                            <td>
                                                                                <c:choose>
                                                                                    <c:when test="${allField.type=='file'}">
                                                                                        <a href="${FormDataNewObject.stringTOJson(row.jsonvalue).get(allField.name)}">
                                                                                            <c:out default="None" escapeXml="true" value="${not empty FormDataNewObject.stringTOJson(row.jsonvalue).get(allField.name) ?FormDataNewObject.stringTOJson(row.jsonvalue).get(allField.name) : ''}" />
                                                                                        </a>
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        ${FormDataNewObject.stringTOJson(row.jsonvalue).get(allField.name)}
                                                                                    </c:otherwise>
                                                                                </c:choose>

                                                                            </td>
                                                                        </c:forEach>
                                                                        <td>${LevelService.findOneById(row.levelForm.level.level_id).name}</td>
                                                                        <td>${row.levelForm.level.chart.name}</td>
                                                                        <td>${row.created_at}</td>
                                                                        <td>
                                                                            <a href="./../fruit/level-form-data/delete/?id=${row.id}" onclick="return confirm('Are you sure? you want to delete this record')" class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></a>
                                                                            <button class="btn btn-sm btn-success" data-toggle="modal" data-target="#updatebox${fn:replace(form.level.chart.name,' ', '_')}${form.level.id}_${i.index}${row.id}"><i class="fa fa-edit"></i></button>
                                                                                <%@include file="UpdatePopUp.jsp" %>
                                                                        </td>
                                                                        <%--<%@include  file="UpdatePopUp.jsp" %>--%>
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
                                                                    <th>Chart</th>
                                                                    <th>Creation date</th>
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
                                        </section>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <!--***************************************Tab Wrap end***************************************************************************************************-->
            </div>
            <div class="col-sm-1 text-left" style=" background-color: #1560bd; margin-left: 0px ; padding: 0px 1px 0px 4px; font-size: 10px; letter-spacing: 2px;  color: white ">
                <%@include file="common/RootSidebar.jsp" %>
            </div>
        </div>
    </div>
    <!-------FOOTER--------------------------------------------->
    <span style="font-size:11px; color:  #666666">Copyright@ Opam-G Infocons Industries Ltd, Reg. Office- House No-108, Vill-Jalalpur, Post-Parmanandpur, Pin No-844507, Mahnar Road (R.S.) , Dist-Vaishali, Bihar, India  </span>
    <a href="../fruit/settings">Settings</a>
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
            xhttp.open("GET", "../fruit/level/changeLevel?id=" + id, true);
            xhttp.send();
        }
        function changeSubLevel(id) {
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {

                }
            };
            xhttp.open("GET", "../subfruit/level/changeLevel?id=" + id, true);
            xhttp.send();
        }
        //      ----------------------------------------------------------------subfruit--------------------
        //------------------------for new popup---------------
        function saveSubFruitData(id) {
            $("#" + id + " #saveSubFruitFormData").text("Saving data...");
            var fruitFormDataOptionList = $(".fruitFormDataOptionList").val();
            if (fruitFormDataOptionList == "") {
                alert("Fill and save personal detail first!");
                $("#" + id + " #saveSubFruitFormData").text("");
            }
            $("#" + id + " #saveSubFruitFormData").text("Saving data");
            var form_data = new FormData($('#' + id)[0]);
            $.ajax({
                url: "../subfruit/level-form-data/create",
                type: "POST",
                data: form_data,
                processData: false,
                contentType: false,
                cache: false,
                timeout: 600000,
                success: function (data) {
                    $("#" + id + " #saveSubFruitFormData").text("New Data Saved");
                    $('#' + id).trigger("reset");
                },
                error: function (data) {
                    $("#" + id + " #saveSubFruitFormData").text("Data not saved");
                }

            });
        }
        function updateSubData(id) {
            //	$("#" + id + " #saveSubFruitFormData2").text("Saving data");
            var form_data = new FormData($('#' + id)[0]);
            $.ajax({
                url: "../subfruit/level-form-data/update",
                type: "POST",
                data: form_data,
                processData: false,
                contentType: false,
                cache: false,
                timeout: 600000,
                success: function (data) {
                    $("#" + id + " #UpdateMessage").text("Data Saved");
                    $('#' + id).trigger("reset");
                },
                error: function (data) {
                    $("#" + id + " #UpdateMessage").text("Data not saved");
                }

            });
        }
        //--------------------------------------------------------------------for update popup-------------------------
        function saveSubFruitData2(id) {
            var fruitFormDataOptionList = $(".fruitFormDataOptionList2").val();
            if (fruitFormDataOptionList == "") {
                alert("Fill and save personal detail first!");
            }
            $("#" + id + " #saveSubFruitFormData2").text("Saving data");
            var form_data = new FormData($('#' + id)[0]);
            $.ajax({
                url: "../subfruit/level-form-data/create",
                type: "POST",
                data: form_data,
                processData: false,
                contentType: false,
                cache: false,
                timeout: 600000,
                success: function (data) {
                    $("#" + id + " #saveSubFruitFormData2").text("New Data Saved");
                    $('#' + id).trigger("reset");
                },
                error: function (data) {
                    $("#" + id + " #saveSubFruitFormData2").text("Data not saved");
                }

            });
        }

        //  -------------------------------------------------------------fruit data-----------------
        function saveFruitData(id) {
            $("#" + id + " #saveFruitFormData").text("Saving data");
            var form_data = new FormData($('#' + id)[0]);
            $.ajax({
                url: "../fruit/level-form-data/create",
                type: "POST",
                data: form_data,
                processData: false,
                contentType: false,
                cache: false,
                timeout: 600000,
                success: function (data) {
                    $("#" + id + " #saveFruitFormData").text("New Data Saved");
                    addFruitFormDataRow(data);
                    $('#' + id).trigger("reset");
                },
                error: function (data) {
                    $("#" + id + " #saveFruitFormData").text("Data not saved");
                }

            });
        }

        function updateFruitData(fid, id) {
            $("#" + id).text("Saving data");

            var form_data = new FormData($('#' + fid)[0]);
            $.ajax({
                url: "../fruit/level-form-data/update",
                type: "POST",
                data: form_data,
                processData: false,
                contentType: false,
                cache: false,
                timeout: 600000,
                success: function (data) {
                    $("#" + id).text("Data Updated");
                    addFruitFormDataRow(data);
                    $('#' + id).trigger("reset");
                },
                error: function (data) {
                    $("#" + id).text("Data not saved");
                }

            });
        }
        function addFruitFormDataRow(data) {
            $(".fruitFormDataOptionList").val(data.id);
        }
        var cat_subcat_level = "";
        var parent_selection;
        var main_selection;
        var level_selection;
        var base_url;

        function selectParentData(thisobj, modalid) {
            var selection = $(thisobj).find(":selected").text();
            cat_subcat_level = selection;
            parent_selection = selection;
            $("#" + modalid + "_fixed_value_field").find("input").val(cat_subcat_level);
            switch (selection)
            {
                case "Fruit":
                {
                    base_url = "../fruit";
                    getAllMain(modalid);

                    break;
                }
                case "Root":
                {
                    base_url = "../root";
                    getAllMain(modalid);

                    break;
                }
                case "Fruit":
                {
                    base_url = "../fruit";
                    getAllMain(modalid);

                    break;
                }
                case "Seed":
                {
                    base_url = "../seed";
                    getAllMain(modalid);

                    break;
                }
                case "Branch":
                {
                    base_url = "../mybranch";
                    getAllMain(modalid);

                    break;
                }
                case "Trunk":
                {
                    base_url = "../trunk";
                    getAllMain(modalid);


                    break;
                }
                case "Leaf":
                {
                    base_url = "../leaf";
                    getAllMain(modalid);

                    break;
                }
                case "Flower":
                {
                    base_url = "../flower";
                    getAllMain(modalid);

                    break;
                }
            }
        }
        function getAllMain(modalid) {
            var data = {
            };
            $.ajax({
                url: base_url + "/main/all",
                type: "POST",
                data: data,
                processData: false,
                contentType: false,
                cache: false,
                timeout: 600000,
                success: function (data) {
                    addMainDropDown(data, modalid);
                },
                error: function (data) {
                    $("#" + modalid).find("#main_list").empty();
                    $("#" + modalid).find("#main_list_data").empty();
                    $("#" + id).text("Data not saved");
                }

            });
        }
        function addMainDropDown(data, modalid) {
            $("#" + modalid).find("#main_list").empty();
            $("#" + modalid).find("#main_list_data").empty();
            $("#" + modalid).find("#main_list").prepend("<option>Select any</option>");
            for (var i = 0; i < data.length; i++) {
                $("#" + modalid).find("#main_list").append("<option value='" + data[i].id + "'>" + data[i].name + "</option>");

            }
        }
        //      ------------------------------------------------parent end
        //-------------------------------------------------------sub category
        function getAllLevelByMain(thisobj, modalid) {
            var selection = $(thisobj).find(":selected").val();
            main_selection = selection;
            cat_subcat_level = parent_selection + "_" + main_selection;
            $("#" + modalid + "_fixed_value_field").find("input").val(cat_subcat_level);
            $.post(base_url + "/level/all",
                    {
                        id: selection
                    },
                    function (data, status) {
                        addMainDropDownData(data, modalid);
                    });
        }
        function addMainDropDownData(data, modalid) {
            $("#" + modalid).find("#main_list_data").empty();
            $("#" + modalid).find("#main_list_data").prepend("<option>Select any</option>");
            for (var i = 0; i < data.length; i++) {
                $("#" + modalid).find("#main_list_data").append("<option onchange=\"getAllLevelByMain('" + modalid + "'," + data[i].id + ")\" value='" + data[i].id + "'>" + data[i].name + "</option>");
            }
        }
        //      -------------------------------------------------------sub category end
        function selectLevel(thisobj, modalid) {
            var selection = $(thisobj).find(":selected").val();
            level_selection = selection;
            cat_subcat_level = parent_selection + "_" + main_selection + "_" + selection;
            $("#" + modalid + "_fixed_value_field").find("input").val(cat_subcat_level);
            $.post(base_url + "/field/all",
                    {
                        id: selection
                    },
                    function (data, status) {
                        addFieldDropDownData(data, modalid);
                    });
        }
        //      -------------------------------------------------------------------field start
        function addFieldDropDownData(data, modalid) {
            $("#" + modalid).find("#field_list").empty();
            $("#" + modalid).find("#field_list").prepend("<option>Select any</option>");
            for (var i = 0; i < data.length; i++) {
                $("#" + modalid).find("#field_list").append("<option>" + data[i].name + "</option>");
            }
        }
        function selectField(thisobj, modalid) {
            var selection = $(thisobj).find(":selected").val();
            field_selection = selection;
            cat_subcat_level = parent_selection + "_" + main_selection + "_" + level_selection + "_" + selection;
            $("#" + modalid + "_fixed_value_field").find("input").val(cat_subcat_level);

        }
        //      -------------------------------------------------------------------field end

        function onInputTypeChange(thisobj, modalid) {
            var selection = $(thisobj).find(":selected").val();
            if (selection == "dropdown") {
                $("#" + modalid).show(1000);
            } else {
                $("#" + modalid).hide(1000);
            }
        }
        function setDefaultType(thisobj, modalid) {
            var selection = $(thisobj).find(":selected").val();
            if (selection == "user") {
                $('#' + modalid).hide(1000);
                $('#' + modalid + "_fixed_value_field").hide(1000);
            } else if (selection == "fixed_data") {
                $('#' + modalid).hide(1000);
                $('#' + modalid + "_fixed_value_field").show(1000);
            } else if (selection == "select_parent") {
                $('#' + modalid + "_fixed_value_field").show(1000);
                $('#' + modalid).show(1000);
            }
        }

        //      ------------------------------------------------------------- on change field dropdown data
        function getDropDownData(thisobj, field_default_value, formid, field_id, select_field) {
            var selected = $(thisobj).find('option:selected');
            var dataid = selected.data('id');
            var request = {
                data: dataid,
                field: field_default_value,
                formid: formid,
                fieldid: field_id
            };
            $.ajax({
                url: "relationl-data",
                type: "POST",
                data: request,
                cache: false,
                timeout: 600000,
                success: function (data) {
                    if ($.isEmptyObject(data)) {
                    } else {
                        var parse_data = JSON.parse(JSON.stringify(data));
                        var select_field_id = select_field + "" + parse_data.data.id;
                        $("#" + select_field_id).empty();
                        $("#" + select_field_id).append("<option>Select any..</option>");

                        for (var i = 0; i < parse_data.data.data.length; i++) {
                            $("#" + select_field_id).append("<option data-id='" + parse_data.data.data[i].id + "'>" + parse_data.data.data[i].name + "</option>");
                        }
                    }

                },
                error: function (data) {
                    alert(data);
                }

            });
        }
        //      ------------------------------------------------------------- subfruit on change field dropdown data
        function getSubFruitDropDownData(thisobj, field_default_value, formid, field_id, select_field) {
            var selected = $(thisobj).find('option:selected');
            var dataid = selected.data('id');
            var request = {
                data: dataid,
                field: field_default_value,
                formid: formid,
                fieldid: field_id
            };
            $.ajax({
                url: "subfruit/relationl-data",
                type: "POST",
                data: request,
                cache: false,
                timeout: 600000,
                success: function (data) {
                    if ($.isEmptyObject(data)) {
                    } else {
                        var parse_data = JSON.parse(JSON.stringify(data));
                        var select_field_id = select_field + "" + parse_data.data.id;
                        $("#" + select_field_id).empty();
                        $("#" + select_field_id).append("<option>Select any..</option>");

                        for (var i = 0; i < parse_data.data.data.length; i++) {
                            $("#" + select_field_id).append("<option data-id='" + parse_data.data.data[i].id + "'>" + parse_data.data.data[i].name + "</option>");
                        }
                    }

                },
                error: function (data) {
                    alert(data);
                }

            });
        }
    </script>


    <script type="text/javascript" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.4/js/dataTables.buttons.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.4/js/buttons.flash.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.4/js/buttons.html5.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.4/js/buttons.print.min.js"></script>
    <script src="/js/oPamGfunctionmy.js"></script>

    <script type="text/javascript" src="/js/popper.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap.js"></script>

</body>
</html>


